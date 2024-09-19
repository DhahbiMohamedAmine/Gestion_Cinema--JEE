<%@page import="Model.Entities.Film"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Des Films</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet" >
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">Cinema Mechergui</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav me-auto">
    <li class="nav-item">	
        <a class="btn btn-primary btn-sm m-2" href="<%= request.getContextPath() %>/ServletProgramme/user" >Aller Consulter La Liste De Programme</a>
        </li>
    </ul>
      <ul class="navbar-nav ml-auto">

        
        <li class="nav-item">
          <a href="http://localhost:8081/Gestion_Cinema/Auth" class="btn btn-danger btn-sm">Log Out</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="container mt-3">
<center><h1>Listes Des Films</h1></center>
<% Object o = request.getAttribute("films");
    ArrayList<Film> l = new ArrayList<>(); 
    if(o instanceof ArrayList){
        l= (ArrayList) o ; 
    }
%>
<table class="table table-bordered table-hover ">
        <thead>
            <tr class="table-secondary">
                <th>ID Film</th>
                <th>Titre</th>
                <th>nom Auteur</th>
            </tr>
        </thead>
        <tbody>
           <%  for (Film f : l) { %>
                <tr>

                    <td><%= f.getId_film() %></td>
                    <td><%= f.getTitre() %></td>
                    <td><%= f.getNom_auteur() %></td>

                </tr>
            <% } %>
        </tbody>
    </table>
 </div>
</body>
</html>