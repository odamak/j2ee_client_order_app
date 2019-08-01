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

public class SuppressionClient extends HttpServlet {
	
    public static final String VUE_AFFICHAGE = "/WEB-INF/supprimerClient.jsp";
    public static final String ATT_SESSION_USERS = "clients";
    public static final String PARAM_PRENOM = "prenom";
    public static final String PARAM_NOM = "nom";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		String prenom = request.getParameter(PARAM_PRENOM);
		String nom = request.getParameter(PARAM_NOM);
		
		/* Récupération de la session */
        HttpSession session = request.getSession();
        
        Map<String, Client> clients = (HashMap<String, Client>) (session.getAttribute(ATT_SESSION_USERS));
        
        clients.remove(prenom + " " + nom);
		
        this.getServletContext().getRequestDispatcher( VUE_AFFICHAGE ).forward( request, response );
    }
	
}