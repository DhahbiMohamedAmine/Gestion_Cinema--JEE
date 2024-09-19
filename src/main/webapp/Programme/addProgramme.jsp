<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout d'un Programme</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
<center><h1>Ajouter Un nouveau Programme</h1></center>
 <form action="<%=request.getContextPath()%>/ServletProgramme/admin/add" method="post">
            <div>
                <div>Id Film 
                    <input type="text" id="id_film" name="id_film"
                        placeholder="id_film" value="" class="form-control m-2" required>
                </div>
                <div>Id Salle
                    <input type="text" name="id_salle" id="id_salle"
                        placeholder="id_salle" value="" class="form-control m-2" required>
                </div>
                <div>Date Programme
                    <input type="datetime" name="date_programme" id="date_programme"
                        placeholder="date_programme" value="" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>