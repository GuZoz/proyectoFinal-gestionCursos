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
	<title>Backoffice - Gestión de cursos</title>

	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Estilos custom del Backoffice -->
	<link href="resources/css/custom-backoffice.css" rel="stylesheet">
	
	<!-- Estilos de dataTables - Para index del Backoffice -->
	<link href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" rel="stylesheet">
	
	<!-- Estilos para el autocomplete -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    
</head>
<body>
	
	<header>
		<nav class="navbar navbar-default navbar-custom navbar-static-top">
   			<div class="container">
   				<div class="navbar-header navbar-header-custom">
   					<h1>Back Office</h1>
    			</div>
    			<form class="navbar-form navbar-left">
	    			<div class="input-group navbar-search-custom">
				       	<label for="buscadorCursosBO" class="input-group-addon">Buscar:</label>
				       	<input type="text" id="buscadorCursosBO" class="form-control" size="20" placeholder="Buscar en la BBDD"> 
				    </div>
			    </form>
   				<ul class="nav navbar-nav navbar-nav-custom navbar-right">
					<li><a href="" class="navbar-btn-custom">Home</a></li>
					<li><a href="logout" class="navbar-btn-custom">Logout</a></li>
				</ul>
  			</div>
		</nav>
	</header>
	
	<div class="container-fluid">
  		<div class="row">
  			<div class="col-md-8 col-sm-12">
	
				<c:if test="${not empty msg}">
					<div class="alert alert-info alert-dismissable">
			 				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			 				${msg}
					</div>
				</c:if>
			
				<div  id="widget-listado-bo">
					<h2>Panel de listado de cursos</h2>
					<h3> - 500 últimos cursos - </h3>
					<table class="tablePlugin" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre del Curso</th>
								<th>Código del Curso</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cursos}" var="curso">
							<tr>
								<td>${curso.id}</td>
								<td><a href="admin/curso/edit/${curso.id}">${curso.nomCurso}</a></td>
								<td>${curso.codCurso}</td>
							</tr>		
							</c:forEach>
						</tbody>	
					</table>
				</div>
			</div>
			<!-- Fin de la columna que contiene el widget de listado -->
		
			<div class="col-md-3 col-sm-12">
				<div class="row">
					
					<div class="col-md-11 col-sm-5" id="widget-creacion-bo">
						<h2>Panel de nuevo curso</h2>
						<a href="admin/curso/edit" class="btn-widget-backoffice">Crear nuevo curso</a>
					</div>
					
					<div class="col-md-11 col-sm-5" id="widget-migracion-bo">
						<h2>Panel de migración de BBDD</h2>
						
						<form action="admin/migrar" method="get">
						<label for="rutaCSV">Ruta de acceso:</label>
							<input class="form-control form-custom" type="text" id="rutaCSV" name="ruta" value="c:\\cursos.csv"/>
							<input type="submit" class="btn-widget-backoffice" value="Migrar">
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>	

	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 	
 	<!-- Script para js de Bootstrap -->
 	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

    <!-- Script de jquery para dataTable -->
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    
    <!-- Script del datatable -->
	<script src="resources/js/datatable.js"></script>
	
	<!-- Script para js de jquery-ui para el autocomplete del buscador -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	<!-- Script del buscador de cursos del backoffice-->
	<script src="resources/js/cursos-search-backoffice.js"></script>
	
</body>
</html>
	
