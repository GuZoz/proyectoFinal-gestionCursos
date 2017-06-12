<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<base href="/proyectofinal/">
	<title>Home - Detalle de curso</title>
	
	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Estilos para el autocomplete -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<!-- Estilos custom del Frontoffice -->
	<link href="resources/css/custom-frontoffice.css" rel="stylesheet">
	
	<!-- Google Fonts - lobster -->
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"> 
	
</head>
<body class="bg-img-detail">
	<header>
		<nav class="navbar navbar-default navbar-custom navbar-static-top">
   			<div class="container">
   				<div class="navbar-header navbar-header-custom">
   					<h1>Detalle del Curso # ${curso.codCurso}</h1>
    			</div>
   				<ul class="nav navbar-nav navbar-nav-custom navbar-right">
					<li ><a class="navbar-btn-custom" href="" >Volver</a></li>
				</ul>
  			</div>
		</nav>
	</header>
	
	<div class="container-fluid">
		<div class="container-detail-title">	
		<h2 class="detail-title"> ${curso.nomCurso}</h2>
		</div>
		
		<div class="container-detail">	
			<h3>Descripción del curso</h3>
			<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
				incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
				exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure 
				dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
				Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt 
				mollit anim id est laborum."
			</p>
			<hr class="hr-detail">
			<ul>
				<li><strong>Código del Curso - </strong> ${curso.codCurso}</li>
				<li><strong>Duración - </strong> ### Horas</li>
				<li><strong>Precio - </strong> $$$ Euros</li>
			</ul>
			
		</div>
	</div>
	
	
	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- Script para js de Bootstrap -->
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
	
	
</body>
</html>