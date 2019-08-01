<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Choisir client</title>
		<link type="text/css" rel="stylesheet" href="inc/style.css" />
	</head>
	<body>
		<c:import url="/inc/menu.jsp" />
		<form method="post" action="<c:url value="/choixTypeClient"/>">
			<fieldset>
				<legend>Informations client</legend>
				<legend>Informations client</legend>
				<p>Nouveau client? <span class="requis">*</span></p>
					<input type="radio" checked="checked" name="radioClient" value="estNouveauClient"> Oui
					<input type="radio" name="radioClient" value="estAncienClient"> Non<br>
					<input type="submit" value="Valider"  /><br />
			</fieldset>
		</form>
	</body>
</html>