<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un Film</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
<center><h1>Ajouter Un Film</h1></center>
 <form action="<%=request.getContextPath()%>/ServletFilm/admin/add" method="post">
            <div>
                <div>Titre 
                    <input type="text" id="titre" name="titre"
                        placeholder="titre" value="" class="form-control m-2" required>
                </div>
                <div>Nom Auteur
                    <input type="text" name="nom_auteur" id="nom_auteur"
                        placeholder="nom_auteur" value="" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>