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
</head>
<body>
	<h1>Backoffice - Gestión de Cursos</h1>
			
	<span><a href="" class="btn btn-default">Front Office</a></span>

	<c:if test="${not empty msg}">
		<div class="alert alert-success alert-dismissable">
 				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
 				${msg}
		</div>
	</c:if>

	
	<a href="admin/curso/edit" class="btn btn-default">Crear nuevo curso</a>
	
	<div>
		<h2>Listado de Cursos</h2>
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
	
	<p> El tiempo en el servidor es ${serverTime}. </p>		

	<!-- Script de libreria JQuery para Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    
    <!-- Script del dataTable -->
 	<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
 	
 	<!-- Script para js de Bootstrap -->
 	<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

    <!-- Scripts para dataTable -->
    <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    
	<script>
var castellano = {
	    "sProcessing":     "Procesando...",
	    "sLengthMenu":     "Mostrar _MENU_ registros",
	    "sZeroRecords":    "No se encontraron resultados",
	    "sEmptyTable":     "Ningún dato disponible en esta tabla",
	    "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
	    "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
	    "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
	    "sInfoPostFix":    "",
	    "sSearch":         "Buscar:",
	    "sUrl":            "",
	    "sInfoThousands":  ",",
	    "sLoadingRecords": "Cargando...",
	    "oPaginate": {
	        "sFirst":    "Primero",
	        "sLast":     "Último",
	        "sNext":     "Siguiente",
	        "sPrevious": "Anterior"
	    },
	    "oAria": {
	        "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
	        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
	    }
	};



//Esperara a que todo el DOM este cargado
$(document).ready(function() {
	
    $('.tablePlugin').DataTable({
    		language: castellano,
    		order:[]
    });
    
    
});//$(document).ready
</script>
</body>
</html>
	
