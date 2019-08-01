package com.sdzee.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.tp.beans.Client;
import com.sdzee.tp.beans.Commande;
import com.sdzee.tp.forms.CreationCommandeForm;

public class CreationCommandeAncien extends HttpServlet {
    public static final String ATT_COMMANDE = "commande";
    public static final String ATT_FORM     = "form";
    public static final String ATT_SESSION_COMMANDES = "commandes";
    public static final String ATT_SESSION_NOUVEAU_CLIENT = "nouveauClient";
    public static final String ATT_SESSION_USERS = "clients";
    
    public static final String ATT_NOM = "nomClient";
    public static final String ATT_PRENOM = "prenomClient";
    public static final String ATT_ADRESSE = "adresseClient";
    public static final String ATT_TELEPHONE = "telephoneClient";
    public static final String ATT_EMAIL = "emailClient";

    public static final String VUE_SUCCES   = "/WEB-INF/afficherCommande.jsp";
    public static final String VUE_FORM     = "/WEB-INF/creerCommandeAncien.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
            
        /* Récupération de la session */
        HttpSession session = request.getSession();
        
        String choix = request.getParameter("ancienClient");
        
        Map<String, Client> clients = new HashMap<String, Client> ();
        if (session.getAttribute(ATT_SESSION_USERS) != null) {
        	clients = (HashMap<String, Client>) (session.getAttribute(ATT_SESSION_USERS));
        }
        
        /* Récupération de toute les propriétés du client à partir de la hashmap qui contient tous les clients "clients" */
        /* et en utilisant l'id "choix" recupéré à partir du paramètre de requête "ancienClient" qui contient nom+prénom */
        Client client = clients.get(choix);
        
        /* Affichage dans console pour vérification */
//        System.out.println("par exemple adresse client choisi est " + client.getAdresse());
        
        boolean isClientOld = false;
        
        if (client != null) {
        	isClientOld = true;
        	request.setAttribute(ATT_NOM, client.getNom());
    		request.setAttribute(ATT_PRENOM, client.getPrenom());
    		request.setAttribute(ATT_ADRESSE, client.getAdresse());
    		request.setAttribute(ATT_TELEPHONE, client.getTelephone());
    		request.setAttribute(ATT_EMAIL, client.getEmail());
        }
      
        /* Création de la HashMap commandes pour stocker toutes les commandes */
        Map<String, Commande> commandes = new HashMap<String, Commande> ();
        
        /* Chargement de la HashMap commandes à partir de la session s'il y a des commandes */
        /* déjà sauvegardés */
        if (session.getAttribute(ATT_SESSION_COMMANDES) != null) {
        	commandes = (HashMap<String, Commande>) (session.getAttribute(ATT_SESSION_COMMANDES));
        }
        
        /* Préparation de l'objet formulaire */
        CreationCommandeForm form = new CreationCommandeForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Commande commande = form.creerCommande( request, isClientOld );
        
        /* Ajout de la commande nouvellement créée à commandes s'il n'y a pas eu d'erreur */    
        if (form.getErreurs().isEmpty()) {
        	commandes.put(commande.getDate(), commande);
        	
        }
        
        /* Mise à jour de l'attribut de session avec la nouvelle version de commandes*/
        session.setAttribute(ATT_SESSION_COMMANDES, commandes);
        
        /* Affichage dans console pour vérification */
//        for (Map.Entry m: commandes.entrySet()) {
//        	System.out.println(m.getKey() + " " + m.getValue());
//        }

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_COMMANDE, commande );
        request.setAttribute( ATT_FORM, form );

        if ( form.getErreurs().isEmpty() ) {
            /* Si aucune erreur, alors affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}