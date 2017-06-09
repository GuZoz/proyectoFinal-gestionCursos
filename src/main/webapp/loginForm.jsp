<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="/proyectofinal/">
	
	<title>Vista de Formulario de Login</title>
	
	<!-- Estilos custom de vistas de login-->
	<link href="resources/css/custom-login.css" rel="stylesheet">
</head>
<body>
<h1>Acceso al Back Office</h1>

	<form action="login" method="post">
		<p>
			<label for="usuario">Usuario</label>
			<input type="text" name="usuario">
		</p>
		<p>
			<label for="clave">Clave</label>
			<input type="password" name="clave">
		</p>
		<p>
			<label for="clave"></label>
			<input type="submit" value="validar">
		</p>
	</form>
</body>
</html>