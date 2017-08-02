<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
	<link rel="stylesheet" href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body>
	<h1>Les collaborateurs de DTA</h1>
	<!-- Liste des noms -->
	
	
		
<c:forEach var="col" items="${listeCollabs}">

<ul>
<li> ${col.nom}  ${col.prenom} </li>

</ul>

</c:forEach>
		
		
		
		
	
</body>
</html>