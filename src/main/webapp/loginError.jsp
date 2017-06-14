</pre>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="/proyectofinal/">
	
	<title>Filtro de acceso</title>
	
	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Estilos custom del Frontoffice -->
	<link href="resources/css/custom-frontoffice.css" rel="stylesheet">
	
	<!-- Google Fonts - lobster -->
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
	
</head>
<header>
		<nav class="navbar navbar-default navbar-custom navbar-static-top">
   			<div class="container">
   				<div class="navbar-header navbar-header-custom">
   					<h1>Filtro de Acceso</h1>
    			</div>
   				<ul class="nav navbar-nav navbar-nav-custom navbar-right">
					<li ><a class="navbar-btn-custom" href="" >Home</a></li>
				</ul>
  			</div>
		</nav>
</header>
<body>
	<div class="container-fluid">
		<div class="container-login-circle">
			<div class="container-login-redirect">
				<p>
					No es posible acceder al recurso solicitado al hallarse protegido, 
					por favor acceda completando el formulario de acceso:
				<p>
			</div>
			<div>
				<a href="loginForm.jsp" class="btn-login-redirect">Login</a>
			</div>
		</div>
	</div>
	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- Script para js de Bootstrap -->
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
</body>
</html>