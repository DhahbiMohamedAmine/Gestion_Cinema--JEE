<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Un Film</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<div class="container mt-3">
<center><h1>Modifier Un Film</h1></center>
<body>
 <form action="<%=request.getContextPath()%>/ServletFilm/admin/edit?id=<%= request.getAttribute("id_film") %>" method="post">
            <div>
                <div>ID
                    <input type="text" id="id_film" name="id_film"
                        placeholder="id_film" value="<%=request.getAttribute("id") %>" class="form-control m-2" required readonly="readonly">
                </div>
                <div>Titre Film
                    <input type="text" id="titre" name="titre"
                        placeholder="titre" value="<%=request.getAttribute("titre") %>" class="form-control m-2" required>
                </div>
                <div>Nom Auteur
                    <input type="text" name="nom_auteur" id="nom_auteur"
                        placeholder="nom_auteur" value="<%=request.getAttribute("nom_auteur") %>" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>