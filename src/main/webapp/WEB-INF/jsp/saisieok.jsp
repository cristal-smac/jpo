<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<title>Confirmation de l'inscription</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
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
	</div>
</body>
</html>