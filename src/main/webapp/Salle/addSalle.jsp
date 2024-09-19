<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Une Salle</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
<center><h1>Ajouter Une Salle</h1></center>
 <form action="<%=request.getContextPath()%>/salle/add" method="post">
            <div>
                <div>Nom Salle
                    <input type="text" id="name" name="name"
                        placeholder="name" value="" class="form-control m-2" required>
                </div>
                <div>Capacité
                    <input type="text" name="nb_place" id="nb_place"
                        placeholder="nb_place" value="" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>