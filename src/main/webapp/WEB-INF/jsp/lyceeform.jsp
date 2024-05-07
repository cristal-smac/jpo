<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		    <form action="/lycee" method="post" id="lycee">
		        <div class="mb-2">
		            <input type="text" class="form-control" name="nom" placeholder="Lycee" required>
		        </div>
		        <div class="mb-2">
		            <input type="text" class="form-control" name="codepostal" placeholder="Code Postal" maxlength=5 required>
		        </div>
		        <div class="mb-2">
		            <input type="text" class="form-control" name="commune" placeholder="Commune" required>
		        </div>
		    </form>
		</div>
		<div class="d-flex justify-content-center">
			<button type="submit" form="lycee" class="btn btn-primary mb-2">Enregistrer</button>
		</div>
    </div>
</body>
</html>