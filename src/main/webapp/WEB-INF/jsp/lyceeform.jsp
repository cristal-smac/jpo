<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!Doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
	<div style="height: 98vh;margin : 1vh">
		<div class="d-flex justify-content-center" style="height:8em" >
			<img src="logo-IUT-de-Lille_2022.png">  <%----  logo-ulille_black.png ----%>
		</div>
		<div class="d-flex justify-content-center">
		    <form action="/lycee" method="post">
				<div class="mb-2">
					<label for="lycee">Lycée</label>
		            <input type="text" class="form-control" id="lycee" name="nom" autofocus required>
		        </div>
				<div class="mb-2">
					<label for="codepostal">Code postal</label>
		            <input type="text" class="form-control" id="codepostal" name="codepostal" maxlength=5 required>
		        </div>
				<div class="mb-2">
					<label for="commune">Commune</label>
		            <input type="text" class="form-control" id="commune" name="commune" required>
		        </div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
				</div>
		    </form>
		</div>

    </div>
</body>
</html>