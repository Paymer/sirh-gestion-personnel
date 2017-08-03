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
<li><a href='<c:url value="/collaborateurs/lister"></c:url>'><span aria-hidden="true"></span> Liste Collab</a></li>
<li><a href='<c:url value="/collaborateurs/statistiques"></c:url>'><span aria-hidden="true"></span> Statistiques</a></li>
<li><a href='<c:url value="/collaborateurs/event"></c:url>'><span aria-hidden="true"></span> Event</a></li>
</ul>
</div>
</nav>




<form class="form-horizontal" method="post">
<fieldset>

<!-- Form Name -->
<legend>AddNewCollaborateur</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Nom">Nom</label>  
  <div class="col-md-4">
  <input id="Nom" name="Nom" type="text" placeholder="Nom" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Prenom">Prenom</label>  
  <div class="col-md-4">
  <input id="Prenom" name="Prenom" type="text" placeholder="Prenom" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="DateNaissance">Date de Naissance</label>  
  <div class="col-md-4">
  <input id="DateNaissance" name="DateNaissance" type="Date" placeholder="Date de Naissance" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Adresse">Adresse</label>  
  <div class="col-md-5">
  <input id="Adresse" name="Adresse" type="text" placeholder="Adresse" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="NumSecSoc">Numero de la securite sociale</label>  
  <div class="col-md-5">
  <input id="NumSecSoc" name="NumSecSoc" type="text" placeholder="Numero de la securite sociale" class="form-control input-md" pattern="[0-9]{15}" required="">
    
  </div>
</div>


<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Envoyer"></label>
  <div class="col-md-4">
    <button id="Envoyer" name="Envoyer" class="btn btn-primary">Envoyer</button>
  </div>
</div>



</fieldset>
</form>

<form class="form-horizontal" method="post">
<fieldset>



</body>
</html>
