package com.sdzee.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.tp.beans.Client;

public class CreationClient extends HttpServlet {
	
	public final static String SUCCESS_MESSAGE = "Client créé avec succès !";
	public static final String ATT_MESSAGE = "message";
	public static final String ATT_CLIENT	 = "client";
	public static final String ATT_FIELDS = "fields";
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( "nomClient" );
        String prenom = request.getParameter( "prenomClient" );
        String adresse = request.getParameter( "adresseClient" );
        String telephone = request.getParameter( "telephoneClient" );
        String email = request.getParameter( "emailClient" );
        String message;
        Boolean fields;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\" <c:url value= \"creerClient.jsp\" /> \">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
            fields = false;
        } else {
            message = SUCCESS_MESSAGE;
            fields = true;
        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_MESSAGE , message );
        request.setAttribute( ATT_FIELDS, fields);

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/afficherClient.jsp" ).forward( request, response );
    }
}