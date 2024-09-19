<%@page import="Model.Entities.Salle"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Salles</title>
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
        <a class="btn btn-primary m-2 btn-sm" href="<%= request.getContextPath() %>/ServletFilm/admin" >Aller au Gestion des Films</a>
        </li>
        <li class="nav-item">
    	<a class="btn btn-primary m-2 btn-sm" href="<%= request.getContextPath() %>/ServletUser/admin" >Aller au Gestion des Users</a>
   		</li>
    	<li class="nav-item">
    	<a class="btn btn-primary m-2 btn-sm" href="<%= request.getContextPath() %>/ServletProgramme/admin" >Aller au Gestion des Programmes</a>
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
<center><h1>Listes Des Salles</h1></center>
<% Object o = request.getAttribute("Salles");
    ArrayList<Salle> l = new ArrayList<>(); 
    if(o instanceof ArrayList){
        l= (ArrayList) o ; 
    }
%>
<table class="table table-bordered table-hover ">
        <thead>
            <tr class="table-secondary">
                <th>ID Salle</th>
                <th>nom Salle</th>
                <th>capcité Salle</th>
                <th colspan=2 class="text-center">Action</th>
            </tr>
        </thead>
        <tbody>
           <%  for (Salle s : l) { %>
                <tr>

                    <td><%= s.getId() %></td>
                    <td><%= s.getNomSalle() %></td>
                    <td><%= s.getNb_place() %></td>
                    <td class="text-center" > <a class="btn btn-primary" href="<%= request.getContextPath() %>/salle/edit?id=<%= s.getId() %>" >Editer</a> </td>
                    <td class="text-center" > <a class="btn btn-danger" href="<%= request.getContextPath() %>/salle/del?id=<%= s.getId() %>">Supprimer</a> </td>
                </tr>
            <% } %>
        </tbody>
    </table>
	 <a class="btn btn-success m-2" href="<%= request.getContextPath() %>/salle/add" >Ajouter Une Salle</a> 
</body>
</html>