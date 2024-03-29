package com.sdzee.tp.forms;
import com.sdzee.tp.beans.*;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class CreationClientForm {
	private static final String CHAMP_NOM  = "nomClient";
	private static final String CHAMP_PRENOM  = "prenomClient";
    private static final String CHAMP_ADRESSE  = "adresseClient";
    private static final String CHAMP_TELEPHONE   = "telephoneClient";
    private static final String CHAMP_EMAIL   = "emailClient";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    

    public Client inscrireClient( HttpServletRequest request, boolean isClientOld ) {
    	
    	String nom;
        String prenom;
        String adresse;
        String telephone;
        String email;
    	
    	if (!isClientOld) {
    		nom = getValeurChamp( request, CHAMP_NOM );
            prenom = getValeurChamp( request, CHAMP_PRENOM );
            adresse = getValeurChamp( request, CHAMP_ADRESSE );
            telephone = getValeurChamp( request, CHAMP_TELEPHONE );
            email = getValeurChamp( request, CHAMP_EMAIL );
    	}
    	else {
    		nom = getValeurAttribut( request, CHAMP_NOM );
            prenom = getValeurAttribut( request, CHAMP_PRENOM );
            adresse = getValeurAttribut( request, CHAMP_ADRESSE );
            telephone = getValeurAttribut( request, CHAMP_TELEPHONE );
            email = getValeurAttribut( request, CHAMP_EMAIL );
    		
    	}
        

        Client client = new Client();
        
        if (!isClientOld) {
        	
        	try {
                validationNom( nom );
            } catch ( Exception e ) {
                setErreur( CHAMP_NOM, e.getMessage() );
                System.out.println("erreur nom " + e.getMessage());
            }
            
            
            try {
                validationPrenom( prenom );
            } catch ( Exception e ) {
                setErreur( CHAMP_PRENOM, e.getMessage() );
                System.out.println("erreur prenom " + e.getMessage());

            }
            
            
            try {
                validationAdresse( adresse );
            } catch ( Exception e ) {
                setErreur( CHAMP_ADRESSE, e.getMessage() );
                System.out.println("erreur adresse " + e.getMessage());

            }
            
            
            try {
                validationTelephone( telephone );
            } catch ( Exception e ) {
                setErreur( CHAMP_TELEPHONE, e.getMessage() );
                System.out.println("erreur telephone " + e.getMessage());

            }
            

            try {
                validationEmail( email );
            } catch ( Exception e ) {
                setErreur( CHAMP_EMAIL, e.getMessage() );
                System.out.println("erreur email " + e.getMessage());

            }
  	
        }
                

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";

        }
        
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        return client;
    }
    
    private void validationNom( String nom ) throws Exception {
    	if ( nom == null) {
    		throw new Exception( "Vous devez saisir le nom.");
    	}
    	else if ( nom != null && nom.length() < 2 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 2 caractères." );
        }
    }
    
    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 2 ) {
            throw new Exception( "Le prénom d'utilisateur doit contenir au moins 2 caractères." );
        }
    }
    
    private void validationAdresse( String adresse ) throws Exception {
    	if ( adresse == null) {
    		throw new Exception( "Vous devez saisir l'adresse.");
    	}
    	else if ( adresse != null && adresse.length() < 10 ) {
            throw new Exception( "L'adresse doit contenir au moins 10 caractères." );
        }
    }
    
    private void validationTelephone( String telephone ) throws Exception {
    	if ( telephone !=null ) {
    		try {  
        	    Double.parseDouble(telephone);  
        	    if ( telephone.length() < 4 ) {
                    throw new Exception( "Le téléphone doit contenir au moins 4 caractères." );
                }
        	  } catch(NumberFormatException e){  
        		  throw new Exception( "Le téléphone doit contenir seulement des chiffres." );
        	  }	
    	}
    	else {
          throw new Exception( "Merci d'entrer un numéro de téléphone." );
      }
    	
    }
    
//    private void validationTelephone( String telephone ) throws Exception {
//        if ( telephone != null ) {
//            if ( !telephone.matches( "^\\d+$" ) ) {
//                throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );
//            } else if ( telephone.length() < 4 ) {
//                throw new Exception( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
//            }
//        } else {
//            throw new Exception( "Merci d'entrer un numéro de téléphone." );
//        }
//    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

 
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    
    private static String getValeurAttribut( HttpServletRequest request, String nomAttribut ) {
        String valeur = (String) request.getAttribute ( nomAttribut );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    

}