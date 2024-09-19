<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un Programme</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
<center><h1>Modifier un Programme</h1></center>
 <form action="<%=request.getContextPath()%>/ServletProgramme/admin/edit?id=<%= request.getAttribute("id_programme") %>" method="post">
            <div>
                <div>ID Programme
                    <input type="text" id="id_programme" name="id_programme"
                        placeholder="id_programme" value="<%=request.getAttribute("id") %>" class="form-control m-2" required readonly="readonly">
                </div>
                <div>ID Film
                    <input type="text" id="id_film" name="id_film"
                        placeholder="id_film" value="<%=request.getAttribute("id_film") %>" class="form-control m-2" required>
                </div>
                <div>ID salle
                    <input type="text" name="id_salle" id="id_salle"
                        placeholder="id_salle" value="<%=request.getAttribute("id_salle") %>" class="form-control m-2" required>
                </div>
                <div>Date PRogramme
                    <input type="datetime" name="date_programme" id="date_programme"
                        placeholder="date_programme" value="<%=request.getAttribute("date_programme") %>" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>