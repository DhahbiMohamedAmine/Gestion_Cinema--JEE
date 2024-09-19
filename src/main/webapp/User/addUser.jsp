<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Un User</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
<center><h1>Ajouter Un User</h1></center>
 <form action="<%=request.getContextPath()%>/ServletUser/admin/add" method="post">
            <div>
                <div>Nom Utilisateur
                    <input type="text" id="name" name="name"
                        placeholder="name" value="" class="form-control m-2" required>
                </div>
                <div>Role
                    <input type="text" name="role" id="role"
                        placeholder="role" class="form-control m-2" required>
                </div>
                <div>Email
                    <input type="text" name="email" id="email"
                        placeholder="email" value="" class="form-control m-2" required>
                </div>
                <div>Password
                    <input type="text" name="password" id="password"
                        placeholder="password" value="" class="form-control m-2" required>
                </div>
                <div>
                    <input type="submit" class="btn btn-success m-2" value="Effectuer">
                </div>
            </div>
        </form>
        </div>
</body>
</html>