<%@page import="Model.Entities.Programme"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Des Programmes</title>
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
        <a class="btn btn-primary btn-sm" href="<%= request.getContextPath() %>/ServletFilm/user" >Aller Consulter La Liste des Films</a>
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
<center><h1>Listes Des Programmes</h1></center>
<% Object o = request.getAttribute("programmes");
    ArrayList<Programme> l = new ArrayList<>(); 
    if(o instanceof ArrayList){
        l= (ArrayList) o ; 
    }
%>
<table class="table table-bordered table-hover ">
        <thead>
            <tr class="table-secondary">
                <th>ID Programme</th>
                <th>ID Film</th>
                <th>ID Salle</th>
                <th>Date Programme</th>
            </tr>
        </thead>
        <tbody>
           <%  for (Programme p : l) { %>
                <tr>

                    <td><%= p.getId_programme() %></td>
                    <td><%= p.getId_film() %></td>
                    <td><%= p.getId_salle() %></td>
                    <td><%= p.getDate_programme() %></td>

                </tr>
            <% } %>
        </tbody>
    </table>
 
 </div>
</body>
</html>