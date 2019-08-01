package com.sdzee.tp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChoixTypeClient extends HttpServlet {
	
    public static final String VUE_CHOIX_TYPE_CLIENT = "/WEB-INF/choisirTypeClient.jsp";
    public static final String VUE_FORM_NOUVEAU     = "/WEB-INF/creerCommande.jsp";
    public static final String VUE_FORM_ANCIEN    = "/WEB-INF/creerCommandeAncien.jsp";
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE_CHOIX_TYPE_CLIENT ).forward( request, response );
    }
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		// get the value of the button group 
	    String choix = request.getParameter("radioClient");
	    
	    // compare selected value 
		
		//if (form.getErreurs().isEmpty()) {
		if (choix.equals("estNouveauClient") ) {
        	this.getServletContext().getRequestDispatcher( VUE_FORM_NOUVEAU ).forward( request, response );     	
        }
        else if (choix.equals("estAncienClient")) {
        	this.getServletContext().getRequestDispatcher( VUE_FORM_ANCIEN).forward( request, response );
        }		
	}
	
}