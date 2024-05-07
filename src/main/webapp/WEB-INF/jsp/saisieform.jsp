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
		    <form action="saisie" method="post" id="saisie">
			    <div class="mb-2">
			        <input type="text" class="form-control" name="prenom" placeholder="Prenom" required>
			    </div>
			    <div class="mb-2">
			        <input type="text" class="form-control" name="nom" placeholder="Nom" required>
			    </div>
			    <%------------------ saisie de l'email  --------------%>
			    <div class="mb-2">
			        <input type="email" class="form-control" name="email" placeholder="Email" required>
			    </div>
			    <%------------------ departement IUT  --------------%>		
			    <div class="mb-2">
			        <select class="form-select form-control" name="dept" required>
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
				<div class="input-group mb-2">
					<select class="form-select form-control" name="lycee" required>
						<option disabled selected value> -- selectionnez votre lycée -- </option>
						<c:forEach items="${lycees}" var="lycee">
							<option value="${lycee.lno}">${lycee.commune} - ${lycee.nom}</option>
						</c:forEach>
					</select>
					<a href="lycee" class="btn btn-secondary">+</a>
				</div>
		    </form>
	    </div>
		<div class="d-flex justify-content-center">
			<button type="submit" form="saisie" class="btn btn-primary mb-2">S'enregistrer</button>
		</div>
    </div>
</body>
</html>