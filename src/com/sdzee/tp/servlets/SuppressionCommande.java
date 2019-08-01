package com.sdzee.tp.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.tp.beans.Commande;

public class SuppressionCommande extends HttpServlet {
	
    public static final String VUE_AFFICHAGE = "/WEB-INF/supprimerCommande.jsp";
    public static final String ATT_SESSION_COMMANDES = "commandes";
    public static final String PARAM_DATE = "date";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
		String date = (String) request.getParameter(PARAM_DATE);
		
		/* Récupération de la session */
        HttpSession session = request.getSession();
        
        Map<String, Commande> commandes = (HashMap<String, Commande>) (session.getAttribute(ATT_SESSION_COMMANDES));
        
        System.out.println("printing value of date\""+date+"\"");
        System.out.println("printing orders");
        for (String name: commandes.keySet()){
            String key = name.toString();
            String value = commandes.get(name).toString();  
            System.out.println("\""+key + "\" " + value);  
} 
        
        commandes.remove(date);
		
        this.getServletContext().getRequestDispatcher( VUE_AFFICHAGE ).forward( request, response );
    }
	
}
