<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- TODO - ver si hace falta, y en que pagina -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- TODO - ver si hace falta, y en que pagina -->
<%@ page session="false" %>

<html lang="es">
<head>
	<meta charset="UTF-8">
	<base href="/proyectofinal/">
	<title>Backoffice - CRUD de Cursos</title>

	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Estilos custom del Backoffice -->
	<link href="resources/css/custom-backoffice.css" rel="stylesheet">
	
	<!-- Estilos de dataTables - Para index del Backoffice -->
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
</head>
<body>
	<span><a href="admin" class="btn btn-default">Volver</a></span>
	<c:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissable">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			${msg}
		</div>
	</c:if>
	<h1>Backoffice - CRUD de Cursos</h1>
	<form:form action="curso/crear" modelAttribute="curso">
		<label>Id:</label>
		<form:input class="form-control" path="id" readonly="true"/>
		<label>Nombre del Curso:</label>
		<form:input class="form-control" path="nomCurso"/>
		<form:errors path="nomCurso" cssStyle="color:red;"/>
		<label>Código del Curso:</label>
		<form:input class="form-control" path="codCurso"/>
		<c:choose>
			<c:when test="${curso.id == -1}">
				<form:button type="submit" class="btn btn-primary">Crear</form:button>
			</c:when>
			<c:otherwise>
				<form:button type="submit" class="btn btn-primary">Modificar</form:button>
			</c:otherwise>
		</c:choose>
	</form:form>
	
	<form:form action="curso/eliminar" modelAttribute="curso">
		<form:hidden path="id"/>
		<form:button type="submit" class="btn btn-danger">Eliminar</form:button>
	</form:form>
		

 	<!-- Script para Ajax de libreria JQuery TODO ver si hace falta -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

 	<!-- Script para js de Bootstrap -->
 	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

</body>
</html>