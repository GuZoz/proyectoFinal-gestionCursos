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
	
	<!-- Estilos custom del Frontoffice -->
	<link href="resources/css/custom-frontoffice.css" rel="stylesheet">
</head>
<body>
	<h1>Gestión de Cursos</h1>
	
	<span><a href="admin" class="btn btn-default">Back Office</a></span>
	
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
	

	
	<!-- Script para js de Bootstrap -->
	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

</body>
</html>
