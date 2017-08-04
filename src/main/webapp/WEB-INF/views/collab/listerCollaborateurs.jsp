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
	
	
	
	
	
	
	
	<h1>Les collaborateurs de DTA</h1>
	<!-- Liste de collaborateurs    -->
	
	
	
	
	
	<form class="form-horizontal">
<fieldset>

<!-- Search input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="searchinput">Rechercher un nom ou un prénom qui commence par:</label>
  <div class="col-md-4">
    <input id="searchinput" name="searchinput" type="search" placeholder="" class="form-control input-md">

    
  </div>
  
  <!-- Button -->
				<div class="form-group">
  					<label class="col-md-4 control-label" for="Envoyer"></label>
  						<div class="col-md-4">
    					<a id="Chercher" href='<c:url value="/collaborateurs/editer"></c:url>' class="btn btn-primary">Chercher</a>
  						</div>
					</div>

</div>
				



<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Filtrer par département:</label>
  <div class="col-md-4">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">Touts</option>
      <option value="2">Comptabilite</option>
      <option value="3">Informatique</option>
      <option value="4">Ressources Humaines</option>
      <option value="5">Administratif</option>
    </select>
  </div>
</div>

</fieldset>



      				<!-- Multiple Checkboxes (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="checkboxes">Voir les collaborateurs désactivés</label>
  <div class="col-md-4">
    <label class="checkbox-inline" for="checkboxes-0">
      <input type="checkbox" name="checkboxes" id="checkboxes-0" >
      
    </label>
  </div>
</div>


</form>
	
	
	
	    

	
	
	
	
	
	
	
	
	
	
	
	

            <section class="row">
                <c:forEach var="col" items="${listeCollabs}">
				<div class="col-lg-4 col-md-6 col-xs-12">
				
				<table ALIGN="CENTER" >
				
				<tbody>
				<tr><h3>${col.nom} ${col.prenom}</h3></tr>
				<tr>
				<td><img src="${col.photo}" height="200" /></td>
				
				<td>
				<ul>
				<li> Department : ${col.departement.nom} </li>
				<li> Email : ${col.emailPro} </li>
				<li> Telephone : 6625842146 </li>
				<li> Function : Chef </li>
				<br></br>
				<!-- Button -->
				<div class="form-group">
  					<label class="col-md-4 control-label" for="Envoyer"></label>
  						<div class="col-md-4">
    					<a id="Editer" href='<c:url value="/collaborateurs/editer"></c:url>' class="btn btn-primary">Editer</a>
  						</div>
					</div>
				
				</ul>
				</td>
               
               
               
                </tr>
                </tbody>
				</table>
				</div>
				</c:forEach>
				</section>
                
 
	
</body>
</html>