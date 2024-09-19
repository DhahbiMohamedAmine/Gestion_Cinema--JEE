<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Supprimer Un User</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<center><h1>Suppression d'Un User</h1></center>
<form action="<%=request.getContextPath()%>/ServletUser/del?id=<%= request.getAttribute("id_user") %>"method="post">
            <div>
                <div>
                <% int id_user = (int) request.getAttribute("id_user"); %>
                    Voullez-vous vraiment supprimer la salle avec l'ID <input type="text" id="id_user"
                        name="id_user" value="<%= id_user %>" placeholder="Enter id salle" class="form-control m-2" readonly="readonly" required>
                </div>

                <div>
                    <input type="submit" class="btn btn-success m-2" value="supprimer">
                </div>
            </div>
        </form>
</body>
</html>