<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<title>Inscription Portes Ouvertes</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="d-flex justify-content-center mb-4">
			À remplir par le futur candidat
		</div>
		<form action="/saisie" method="post">
			<div class="mb-2">
				<label for="prenom">Prénom</label>
				<input type="text" class="form-control" id="prenom" name="prenom" value="${saisie.prenom}" autofocus required>
			</div>
			<div class="mb-2">
				<label for="nom">Nom</label>
				<input type="text" class="form-control" id="nom" name="nom" value="${saisie.nom}" required>
			</div>
			<%------------------ saisie de l'email  --------------%>
			<div class="mb-2">
				<label for="email">Email</label>
				<input type="email" class="form-control" id="email" name="email" value="${saisie.email}" required>
			</div>
			<%------------------ departement IUT  --------------%>
			<div class="mb-2">
				<label for="dept">Département</label>
				<select class="form-select form-control" id="dept" name="dept" required>
					<option disabled selected value> -- sélectionnez le dept souhaité -- </option>
					<c:forEach items="${departements}" var="lycee">
						<option ${lycee.sigle == saisie.dept ? "selected" : ""} value="${lycee.sigle}">${lycee.libelle}</option>
					</c:forEach>
				</select>
			</div>
			<%------------------ saisie du lycée  --------------%>
			<div>
				<label for="lycee">Lycée</label>
				<select class="form-select form-control" id="lycee" name="lycee" required>
					<option disabled selected value> -- sélectionnez votre lycée -- </option>
					<c:forEach items="${lycees}" var="lycee">
						<option ${lycee.lno == saisie.lycee ? "selected" : ""} value="${lycee.lno}">${lycee.commune} - ${lycee.nom}</option>
					</c:forEach>
				</select>
			</div>

			<div class="d-flex flex-column-reverse p-0 align-items-start">
				<input type="submit" class="btn btn-primary btn-block w-100 py-2"
					   value="S'enregistrer" formaction="saisie" />
				<input type="submit" class="btn btn-link p-0 text-black mb-4"
					   value="Votre lycée n'est pas dans la liste? Ajoutez-le ici"
					   formnovalidate formaction="saveSaisieForm"
				/>
			</div>
		</form>
    </div>
</body>
</html>