<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'une commande</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body onload="onLoadFunction()">
        <c:import url="/inc/menu.jsp" />
        <div>
            <form method="post" action="<c:url value="/creationCommande"/>">
                <%-- Petite astuce ici : placer le client accessible via  
                 l'EL ${ commande.client } dans une variable "client" de 
                 portée request, pour que le code du fragment fonctionne
                 à la fois depuis le formulaire de création d'un client 
                 et depuis celui de création d'une commande. --%>
                <c:set var="client" value="${ commande.client }" scope="request" />
                <fieldset>
                    <legend>Informations client</legend>
                    <p>Nouveau client? <span class="requis">*</span></p>
                    <input type="radio" name="radioClient" value="oui" onclick="fonctionOui()"> Oui
                    <input type="radio" name="radioClient" value="non" onclick="fonctionNon()"> Non<br>
                    <div id="nouveauClient">
                    	<c:import url="/inc/inc_client_form.jsp" />
                    </div>
                    <script type="text/javascript">
						function fonctionOui() {
							document.getElementById("ancienClient").style.display = "none";
							document.getElementById("nouveauClient").style.display = "block";
							//alert("Hello! I am an alert box Oui!");
						}
						function fonctionNon() {
							document.getElementById("nouveauClient").style.display = "none";
							document.getElementById("ancienClient").style.display = "block";
							//alert("Hello! I am an alert box Non!");
						}
						function onLoadFunction() {
							document.getElementById("ancienClient").style.display = "none";
							document.getElementById("nouveauClient").style.display = "none";
							//alert("Hello! I am on load function");
							}
					</script>
                    <div id="ancienClient">
		                    <select>
							  <option value="" selected disabled hidden>Choisissez un client...</option>
							  <option value="1">One</option>
							  <option value="2">Two</option>
							  <option value="3">Three</option>
							  <option value="4">Four</option>
							  <option value="5">Five</option>
							</select>
					</div>
				</fieldset>
                <fieldset>
                    <legend>Informations commande</legend>
                    
                    <label for="dateCommande">Date <span class="requis">*</span></label>
                    <input type="text" id="v" name="dateCommande" value="<c:out value="${commande.date}"/>" size="30" maxlength="30" disabled />
                    <span class="erreur">${form.erreurs['dateCommande']}</span>
                    <br />
                    
                    <label for="montantCommande">Montant <span class="requis">*</span></label>
                    <input type="text" id="montantCommande" name="montantCommande" value="<c:out value="${commande.montant}"/>" size="30" maxlength="30" />
                    <span class="erreur">${form.erreurs['montantCommande']}</span>
                    <br />
                    
                    <label for="modePaiementCommande">Mode de paiement <span class="requis">*</span></label>
                    <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="<c:out value="${commande.modePaiement}"/>" size="30" maxlength="30" />
                    <span class="erreur">${form.erreurs['modePaiementCommande']}</span>
                    <br />
                    
                    <label for="statutPaiementCommande">Statut du paiement</label>
                    <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="<c:out value="${commande.statutPaiement}"/>" size="30" maxlength="30" />
                    <span class="erreur">${form.erreurs['statutPaiementCommande']}</span>
                    <br />
                    
                    <label for="modeLivraisonCommande">Mode de livraison <span class="requis">*</span></label>
                    <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="<c:out value="${commande.modeLivraison}"/>" size="30" maxlength="30" />
                    <span class="erreur">${form.erreurs['modeLivraisonCommande']}</span>
                    <br />
                    
                    <label for="statutLivraisonCommande">Statut de la livraison</label>
                    <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="<c:out value="${commande.statutLivraison}"/>" size="30" maxlength="30" />
                    <span class="erreur">${form.erreurs['statutLivraisonCommande']}</span>
                    <br />
                </fieldset>
                <p class="info">${ form.resultat }</p>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>