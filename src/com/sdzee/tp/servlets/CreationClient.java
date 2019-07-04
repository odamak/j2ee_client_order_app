package com.sdzee.tp.servlets;
import com.sdzee.tp.forms.* ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.tp.beans.Client;

public class CreationClient extends HttpServlet {
	
    public static final String ATT_USER = "client";
    public static final String ATT_FORM = "form";
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