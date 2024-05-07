<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>
<!Doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div style="height: 98vh;margin : 1vh">
		<div class="d-flex justify-content-center" style="height:8em" >
			<img src="logo-IUT-de-Lille_2022.png">  <%----  logo-ulille_black.png ----%>
		</div>
		<div class="d-flex justify-content-center" style="height:8em" >
		à remplir par le futur candidat
		</div>
		<div class="d-flex justify-content-center">
		    <form action="saisie" method="post">
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
						<option disabled selected value> -- selectionnez le dept souhaité -- </option>
						<c:forEach items="${departements}" var="lycee">
							<option ${lycee.sigle == saisie.dept ? "selected" : ""} value="${lycee.sigle}">${lycee.libelle}</option>
						</c:forEach>
			        </select>
			    </div>
			    <%------------------ saisie du lycée  --------------%>
				<div>
					<label for="lycee">Lycée</label>
					<select class="form-select form-control" id="lycee" name="lycee" required>
						<option disabled selected value> -- selectionnez votre lycée -- </option>
						<c:forEach items="${lycees}" var="lycee">
							<option ${lycee.lno == saisie.lycee ? "selected" : ""} value="${lycee.lno}">${lycee.commune} - ${lycee.nom}</option>
						</c:forEach>
					</select>
				</div>

				<div class="d-flex flex-column-reverse p-0 align-items-start">
					<div class="d-flex align-self-center">
						<input type="submit" class="btn btn-primary mb-2" value="S'enregistrer" formaction="saisie">
					</div>

					<input type="submit" class="btn btn-link p-0 text-black mb-2"
						   value="Votre lycée n'est pas dans la liste? Ajoutez-le ici" formnovalidate formaction="saveSaisieForm"
					/>
				</div>

		    </form>
	    </div>

    </div>
</body>
</html>