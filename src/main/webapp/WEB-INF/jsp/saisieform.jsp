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
			        <input type="text" class="form-control" id="prenom" name="prenom" autofocus required>
			    </div>
			    <div class="mb-2">
					<label for="nom">Nom</label>
			        <input type="text" class="form-control" id="nom" name="nom" required>
			    </div>
			    <%------------------ saisie de l'email  --------------%>
			    <div class="mb-2">
					<label for="email">Email</label>
			        <input type="email" class="form-control" id="email" name="email" required>
			    </div>
			    <%------------------ departement IUT  --------------%>		
			    <div class="mb-2">
					<label for="dept">Département</label>
			        <select class="form-select form-control" id="dept" name="dept" required>
						<option disabled selected value> -- selectionnez le dept souhaité -- </option>
						<option value="Chimie">Chimie</option>
						<option value="Bio">Génie Biologique</option>
						<option value="GEA">Gestion et Administration des Entreprises</option>
						<option value="Info">Informatique</option>
						<option value="GEII">Génie électrique et Informatique industrielle</option>
						<option value="MP">Mesures Physiques</option>
						<option value="GMP">Génie mécanique et productique</option>
						<option value="QHS">Master QHS</option>
			        </select>
			    </div>
			    <%------------------ saisie du lycée  --------------%>
				<div class="mb-2">
					<label for="lycee">Lycée</label>
					<div class="input-group">
						<select class="form-select form-control" id="lycee" name="lycee" required>
							<option disabled selected value> -- selectionnez votre lycée -- </option>
							<c:forEach items="${lycees}" var="lycee">
								<option value="${lycee.lno}">${lycee.commune} - ${lycee.nom}</option>
							</c:forEach>
						</select>
						<a href="lycee" class="btn btn-secondary d-flex align-items-center">+</a>
					</div>
				</div>

				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mb-2">S'enregistrer</button>
				</div>
		    </form>
	    </div>

    </div>
</body>
</html>