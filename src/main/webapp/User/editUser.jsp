<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Un User</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
<center><h1>Modification d'Un User</h1></center>
 <form action="<%=request.getContextPath()%>/ServletUser/admin/edit?id=<%= request.getAttribute("id_user") %>" method="post">
            <div>
                <div>ID
                    <input type="text" id="id_user" name="id_user"
                        placeholder="id_user" value="<%=request.getAttribute("id") %>" class="form-control m-2" required readonly="readonly">
                </div>
                <div>Nom User
                    <input type="text" id="name" name="name"
                        placeholder="name" value="<%=request.getAttribute("name") %>" class="form-control m-2" required>
                </div>
                <div>Role
                    <input type="text" name="role" id="role"
                        placeholder="role" value="<%=request.getAttribute("role") %>" class="form-control m-2" required>
                </div>
                <div>Email
                    <input type="text" name="email" id="email"
                        placeholder="email" value="<%=request.getAttribute("email") %>" class="form-control m-2" required>
                </div>
                <div>Password
                    <input type="text" name="password" id="password"
                        placeholder="password" value="<%=request.getAttribute("password") %>" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>