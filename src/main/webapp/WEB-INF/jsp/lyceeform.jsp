<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
		    <form:form action="/lycee" method="post" modelAttribute="lycee">
				<div class="mb-2">
					<label for="lycee">Lycée</label>
					<form:input type="text" path="nom" id="lycee" class="form-control" />
					<form:errors path="nom" />
		        </div>
				<div class="mb-2">
					<label for="codepostal">Code postal</label>
					<form:input type="text" path="codepostal" id="codepostal" class="form-control" />
					<form:errors path="codepostal" />
		        </div>
				<div class="mb-2">
					<label for="commune">Commune</label>
					<form:input type="text" path="commune" id="commune" class="form-control" />
					<form:errors path="commune" />
		        </div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
				</div>
		    </form:form>
		</div>

    </div>
</body>
</html>