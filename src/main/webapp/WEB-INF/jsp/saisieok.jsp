<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!Doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
		<div class="d-flex justify-content-center" style="height:8em" >
			<img src="logo-IUT-de-Lille_2022.png">  <%----  logo-ulille_black.png ----%>
		</div>

	<c:choose>
		<c:when test="${numero == 0 }">
			<div class="alert alert-danger" role="alert">
    			<!-- Vos informations n'ont pas été enregistrées. (email existante dans la base) -->
    			Vos informations ont déjà été enregistrées précédemment. 
    		</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-success" role="alert">
    			Vos informations ont bien été enregistrées. Merci pour votre venue. Vous êtes la ${numero}e personne enregistrée.
    		</div>
   	 	</c:otherwise>
    </c:choose>
</body>
</html>