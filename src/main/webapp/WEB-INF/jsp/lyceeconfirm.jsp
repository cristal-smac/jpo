<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <title>Confirmation ajout d'un lycée</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="container">
    <div class="card">
        <div class="card-header">
            Avertissement
        </div>
        <div class="card-body">
            <h5 class="card-text mb-4">Un lycée avec un nom similaire existe déjà dans cette ville :</h5>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Votre saisie</th>
                    <th scope="col">Lycée existant</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Nom</th>
                    <td>${input.nom}</td>
                    <td>${similar.nom}</td>
                </tr>
                <tr>
                    <th scope="row">Code postal</th>
                    <td>${input.codepostal}</td>
                    <td>${similar.codepostal}</td>
                </tr>
                <tr>
                    <th scope="row">Commune</th>
                    <td>${input.commune}</td>
                    <td>${similar.commune}</td>
                </tr>
                </tbody>
            </table>
            <p class="card-text">Voulez-vous quand même ajouter votre saisie?</p>
            <div class="row">
                <div class="col">
                    <form action="/lycee?force" method="post">
                        <input type="hidden" name="nom" value=${input.nom} />
                        <input type="hidden" name="codepostal" value=${input.codepostal} />
                        <input type="hidden" name="commune" value=${input.commune} />
                        <input type="submit" class="btn btn-primary btn-block w-100 py-2" value="Oui" />
                    </form>
                </div>
                <div class="col">
                    <form action="/saisie" method="get">
                        <input type="submit" class="btn btn-secondary btn-block w-100 py-2" value="Non" />
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>