<%@page import="dev.sgp.entite.VisiteWeb"%>
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
	<h1>Les statistiques de DTA</h1>
	<!-- Liste des noms -->
	
	<section>
      <table ALIGN="CENTER" BORDER="2">
        <thead>
            <tr>
                <th ALIGN="CENTER"> Chemin </th>
                <th ALIGN="CENTER"> Nombre de Visites </th>
                <th ALIGN="CENTER"> Min (ms) </th>
                <th ALIGN="CENTER"> Max (ms) </th>
                <th ALIGN="CENTER"> Moyenne (ms) </th>
            </tr>   
        </thead>
        <tbody>
		
<c:forEach var="st" items="${statis}">

<tr>
<td> ${st.chemin} </td>
<td> ${st.nomVisites} </td>
<td> ${st.min} </td>
<td> ${st.max} </td>
<td> ${st.moyenne} </td>
</tr>

</c:forEach>	
		
	</tbody>
	</table>
 	</section> 	
	
	
	
	
	
	
	
	<section>
      <table ALIGN="CENTER" BORDER="2">
        <thead>
        	<h1>Liste de Visites</h1>
        
            <tr>
                <th ALIGN="CENTER"> Chemin </th>
                <th ALIGN="CENTER"> Temps </th>

            </tr>   
        </thead>
        <tbody>
		
<c:forEach var="vis" items="${listeVisits}">

<tr>
<td> ${vis.chemin} </td>
<td> ${vis.tempsExecution} </td>

</tr>

</c:forEach>	
		
	</tbody>
	</table>
 	</section> 	
	
	
	
	
	
</body>
</html>