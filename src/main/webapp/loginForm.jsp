<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="/proyectofinal/">
	
	<title>Vista de Formulario de Login</title>
	
	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Estilos custom del Frontoffice -->
	<link href="resources/css/custom-frontoffice.css" rel="stylesheet">
	
	<!-- Google Fonts - lobster -->
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"> 
	
</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-custom navbar-static-top">
   			<div class="container">
   				<div class="navbar-header navbar-header-custom">
   					<h1>Acceso al Back Office</h1>
    			</div>
   				<ul class="nav navbar-nav navbar-nav-custom navbar-right">
					<li ><a class="navbar-btn-custom" href="" >Home</a></li>
				</ul>
  			</div>
		</nav>
	</header>
	<div class="container-fluid">
		<div class="container-login-circle">
			<form action="login" method="post">
				<div class="input-group input-group-custom">
					<label for="usuario" class="input-group-addon">Usuario:</label>
					<input type="text" name="usuario" class="form-control" size="50" placeholder="Nombre de usuario">
				</div>
				<br>
				<div class="input-group input-group-custom">
					<label for="clave" class="input-group-addon">Clave: &nbsp; &nbsp;</label>
					<input type="password" name="clave" class="form-control" size="50" placeholder="Contraseña de usuario">
				</div>
				<br><br>
				<div>
					<label for="clave"></label>
					<input class="btn-login-validar" type="submit" value="Validar">
				</div>
			</form>
		</div>
	</div>
	
	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- Script para js de Bootstrap -->
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
	
</body>
</html>