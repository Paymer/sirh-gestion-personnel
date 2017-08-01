<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs de DTA</h1>
	<!-- Liste des noms -->
	<ul>
		<%
			List<Collaborateur> listeCollabs = (List<Collaborateur>)request.getAttribute("listeCollabs");
			for (Collaborateur col : listeCollabs) {
		%>
		<li><%=col.getMatricule()%> <%=col.getNom()%> <%=col.getPrenom()%> 
		  <%=col.getAdresse()%>  </li>
		<%
			}
		%>
	</ul>
</body>
</html>