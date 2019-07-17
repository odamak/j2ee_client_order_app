package com.sdzee.tp.servlets;
import com.sdzee.tp.forms.* ;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.tp.beans.Client;

public class CreationClient extends HttpServlet {
	
    public static final String ATT_USER = "client";
    public static final String ATT_FORM = "form";
    public static final String ATT_SESSION_USERS = "form";
    public static final String VUE_CREATION = "/WEB-INF/creerClient.jsp";
    public static final String VUE_AFFICHAGE = "/WEB-INF/afficherClient.jsp";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE_CREATION ).forward( request, response );
    }
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
		/* Préparation de l'objet formulaire */
        CreationClientForm form = new CreationClientForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Client client = form.inscrireClient( request );
        
        HttpSession session = request.getSession();
        System.out.println("session.getAttribute(ATT_SESSION_USERS is "+ session.getAttribute(ATT_SESSION_USERS));
        if (session.getAttribute(ATT_SESSION_USERS) == null) {
        	Map<String, Client> clients = new HashMap<String, Client> ();
        			session.setAttribute(ATT_SESSION_USERS,clients);
        }
        if (session.getAttribute(ATT_SESSION_USERS) != null) {
        	Map<String, Client> clients = (HashMap<String, Client>) (session.getAttribute(ATT_SESSION_USERS));
        	if (!clients.isEmpty()) {
            	System.out.println("printing users HashMap!!!!!!");
                for(Map.Entry m : clients.entrySet()) {
                	System.out.println(m.getKey() + " " + m.getValue());
                }
                System.out.println("End printing users HashMap!!!!!!");  	
            }
            
            if (form.getErreurs().isEmpty()) {
            	clients.put(client.getPrenom()+" "+client.getNom(), client);
            	System.out.println("printing NEW users HashMap!!!!!");
                for(Map.Entry m : clients.entrySet()) {
                	System.out.println(m.getKey() + " " + m.getValue());
                }
                System.out.println("End printing NEW users HashMap!!!!!!");
            	
            }
            request.setAttribute(ATT_SESSION_USERS, clients);
        	
        }
        
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );

        request.setAttribute( ATT_USER, client );
        
        System.out.println("les erreurs sont " + form.getErreurs());
        
        if (form.getErreurs().isEmpty()) {
        	this.getServletContext().getRequestDispatcher( VUE_AFFICHAGE ).forward( request, response );     	
        }
        else {
        	this.getServletContext().getRequestDispatcher( VUE_CREATION ).forward( request, response );
        }
		
        
    }
}