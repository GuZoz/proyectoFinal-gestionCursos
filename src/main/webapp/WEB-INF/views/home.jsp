<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<base href="/proyectofinal/">
	<title>Home - Gestión de cursos</title>
	
	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Estilos para el autocomplete -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<!-- Estilos custom del Frontoffice -->
	<link href="resources/css/custom-frontoffice.css" rel="stylesheet">
</head>
<body>
	<h1>Gestión de Cursos</h1>
	
	<span><a href="admin" class="btn btn-default">Back Office</a></span>
	
	<div class="input-group">

       <label for="buscadorCursos" class="input-group-addon"><span class="glyphicon glyphicon-search"></span>&nbsp;Buscar:&nbsp;</label>

       <input type="text" id="buscadorCursos" class="form-control" size= 55 placeholder="Buscar un curso"> 

    </div>
	
	<div>
		<c:if test="${ultimosCursos.size()>0 }">
			<h2>Ultimos Cursos</h2>
			<ol>
				<c:forEach items="${ultimosCursos}" var="curso">
					<li>${curso.nomCurso} - ${curso.codCurso}</li>
				</c:forEach>
			</ol>
		</c:if>
		<c:if test="${ultimosCursos.size()== 0}">
			<h2> No hay cursos </h2>
		</c:if>
	</div>
	
	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	
	<!-- Script para js de Bootstrap -->
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
	
	<!-- Script para js de jquery-ui para el autocomplete del buscador -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<!-- Script del buscador de cursos -->
	<script src="resources/js/cursos-search.js"></script>

</body>
</html>
