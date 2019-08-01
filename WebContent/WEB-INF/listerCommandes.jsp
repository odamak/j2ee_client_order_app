<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>
		<body>
			<c:import url="/inc/menu.jsp" />
			<c:choose>
				<c:when test="${ !empty commandes }">
					<table>
						<tr>
							<th>Nom</th>
				    		<th>Prénom</th>
				    		<th>Adresse</th>
				    		<th>Téléphone</th>
				    		<th>Email</th>
				    		<th>Date</th>
				    		<th>Montant</th>
				    		<th>Mode de paiement</th>
				    		<th>Statut de paiement</th>
				    		<th>Mode de livraison</th>
				    		<th>Statut de la livraison</th>
				    		<th>Supprimer</th>
						</tr>
						<c:forEach items="${sessionScope.commandes}" var="element">    
						<tr>
						    <td>${element.value.client.nom}</td>
						    <td>${element.value.client.prenom}</td>
						    <td>${element.value.client.adresse}</td>
						    <td>${element.value.client.telephone}</td>
						    <td>${element.value.client.email}</td>
						    <td>${element.value.date}</td>
						    <td>${element.value.montant}</td>
						    <td>${element.value.modePaiement}</td>
						    <td>${element.value.statutPaiement}</td>
						    <td>${element.value.modeLivraison}</td>
						    <td>${element.value.statutLivraison}</td>
						    <td>suppression</td>
						</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<c:out value="${'Aucune commande'}"/>
				</c:otherwise>
			</c:choose>
		</body>
</html>