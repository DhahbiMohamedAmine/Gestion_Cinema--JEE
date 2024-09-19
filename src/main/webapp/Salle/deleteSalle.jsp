<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer Une Salle</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<center><h1>Suppression d'Une Salle</h1></center>
<form action="<%=request.getContextPath()%>/salle/del?id=<%= request.getAttribute("id_salle") %>"method="post">
            <div>
                <div>
                <% int id_salle = (int) request.getAttribute("id_salle"); %>
                    Voullez-vous vraiment supprimer la salle avec l'ID <input type="text" id="id_salle"
                        name="id_salle" value="<%= id_salle %>" placeholder="Enter id salle" class="form-control m-2" readonly="readonly" required>
                </div>

                <div>
                    <input type="submit" class="btn btn-success m-2" value="supprimer">
                </div>
            </div>
        </form>
</body>
</html>