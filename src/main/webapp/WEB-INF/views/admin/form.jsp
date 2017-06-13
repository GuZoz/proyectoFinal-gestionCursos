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
	
</head>
<body>

	<header>
		<nav class="navbar navbar-default navbar-custom navbar-static-top">
   			<div class="container">
   				<div class="navbar-header navbar-header-custom">
   					<h1>Formulario de Cursos</h1>
    			</div>
   				<ul class="nav navbar-nav navbar-nav-custom navbar-right">
					<li><a href="admin" class="navbar-btn-custom">Volver</a></li>
				</ul>
  			</div>
		</nav>
	</header>
	
	<c:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissable">
			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			${msg}
		</div>
	</c:if>
	
	<div class="container-fluid">
		<div class="container-form">
	
			<form:form action="curso/crear" modelAttribute="curso">
				<label>Id:</label>
				<form:input class="form-control form-custom" path="id" readonly="true"/>
				
				<label>Nombre del Curso:</label>
				<form:errors path="nomCurso" cssStyle="color:red;"/>
				<form:input class="form-control form-custom" path="nomCurso"/>
					
				<label>Código del Curso:</label>
				<form:errors path="codCurso" cssStyle="color:red;"/>
				<form:input class="form-control form-custom" path="codCurso"/>
				
				<hr>
				<c:choose>
					<c:when test="${curso.id == -1}">
						<form:button type="submit" class="btn-widget-backoffice">Crear</form:button>
					</c:when>
					<c:otherwise>
						<form:button type="submit" class="btn-widget-backoffice">Modificar</form:button>
					</c:otherwise>
				</c:choose>
			</form:form>
			<form:form action="curso/eliminar" modelAttribute="curso">
				<form:hidden path="id"/>
				<form:button type="submit" class="btn-widget-bo-delete">Eliminar</form:button>
			</form:form>
	
		</div>
	</div>

 	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

 	<!-- Script para js de Bootstrap -->
 	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

</body>
</html>