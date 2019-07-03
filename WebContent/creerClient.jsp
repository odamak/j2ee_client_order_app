<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
        	<c:import url="/inc/menu.jsp" />
        	<form method="get" action="creationClient">
           		<c:import url="/inc/inc_client_form.jsp" />
            	<input type="submit" value="Valider"  />
            	<input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>