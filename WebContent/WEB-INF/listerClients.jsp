<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Affichage d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<c:import url="/inc/menu.jsp" />
        <c:choose>
  			<c:when test="${ !empty clients }">
  				<table>
  					<tr>
						<th>Nom</th>
					    <th>Prénom</th>
					    <th>Adresse</th>
					    <th>Téléphone</th>
					    <th>Email</th>
					    <th>Supprimer</th>
					</tr>
	  				<c:forEach items="${sessionScope.clients}" var="element">
	  				<c:url value="/suppressionClient" context="/" var="suppression">
					  <c:param name="prenom"   value="${element.value.prenom}" />
					  <c:param name="nom"    value="${element.value.nom}" />
					</c:url>    
						<tr>
						    <td>${element.value.nom}</td>
						    <td>${element.value.prenom}</td>
						    <td>${element.value.adresse}</td>
						    <td>${element.value.telephone}</td>
						    <td>${element.value.email}</td>
							<td> <a href = "<c:url value = "${suppression}"/>"> Suppression</a> </td>					
						</tr>
					</c:forEach>
				</table>
  			</c:when>
  			<c:otherwise>
				<c:out value="${'Aucun client'}"/>
  			</c:otherwise>
		</c:choose>
    </body>
</html>