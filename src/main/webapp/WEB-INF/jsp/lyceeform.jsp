<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<title>Ajouter un lycée</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<form action="/lycee" method="post" modelAttribute="lycee">
			<div class="mb-2">
				<label for="lycee">Lycée</label>
				<input type="text" name="nom" id="lycee" class="form-control"  required />
			</div>
			<div class="mb-2">
				<label for="codepostal">Code postal</label>
				<input type="text" name="codepostal" pattern="[0-9]{5}" maxlength="5" id="codepostal" class="form-control"  required />
			</div>
			<div class="mb-2">
				<label for="commune">Commune</label>
				<input type="text" name="commune" id="commune" class="form-control"  required />
			</div>
			<div class="d-flex justify-content-center">
				<input type="submit" class="btn btn-primary mb-2 btn-block w-100 py-2" value="Enregistrer" />
			</div>
		</form>
	</div>
</body>
</html>