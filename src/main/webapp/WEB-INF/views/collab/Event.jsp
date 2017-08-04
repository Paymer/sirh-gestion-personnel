<%@page import="dev.sgp.entite.CollabEvt"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - Event</title>
	<link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body>

	<!-- Barra de Navegacion -->
<nav class="navbar navbar-default">
<div class="collapse navbar-collapse" id="maNavBar">
 <ul class="nav navbar-nav">
 <li><a href='<c:url value="/collaborateurs/add"></c:url>'><span aria-hidden="true"></span> Add</a></li>
<li><a href='<c:url value="/collaborateurs/lister"></c:url>'><span aria-hidden="true"></span> Liste Collab</a></li>
<li><a href='<c:url value="/collaborateurs/statistiques"></c:url>'><span aria-hidden="true"></span> Statistiques</a></li>
<li><a href='<c:url value="/collaborateurs/event"></c:url>'><span aria-hidden="true"></span> Event</a></li>
</ul>
</div>
</nav>

	<h1>Les evenements</h1>
	<!-- Liste des noms -->
	
	<section>
      <table ALIGN="CENTER" BORDER="2">
        <thead>
            <tr>
                <th ALIGN="CENTER"> Type </th>
                <th ALIGN="CENTER"> Date </th>
                <th ALIGN="CENTER"> Matricule </th>
                
            </tr>   
        </thead>
        <tbody>
		
<c:forEach var="ev" items="${event}">

<tr>
<td> ${ev.type} </td>
<td> ${ev.dateHeure} </td>
<td> ${ev.matricule} </td>

</tr>

</c:forEach>	
		
	</tbody>
	</table>
 	</section> 	
	

	
	
</body>
</html>