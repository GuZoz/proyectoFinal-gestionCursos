<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<base href="/proyectofinal/">
	<title>Gestión de Cursos</title>
	
	<link rel="shortcut icon" href="resources/img/favicon.ico" type="image/x-icon">
	<link rel="icon" href="resources/img/favicon.ico" type="image/x-icon">
	
	<!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Estilos para el autocomplete -->
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	
	<!-- Estilos custom del Frontoffice -->
	<link href="resources/css/custom-frontoffice.css" rel="stylesheet">
	
	<!-- Google Fonts - lobster -->
	<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet"> 
</head>
<body class="bg-img-main">
	<header>
		<nav class="navbar navbar-default navbar-custom navbar-static-top">
   			<div class="container">
   				<div class="navbar-header navbar-header-custom">
   					<h1 >Gestión de Cursos</h1>
    			</div>
   				<ul class="nav navbar-nav navbar-nav-custom navbar-right">
					<li><a class="navbar-btn-custom" href="" >Home</a></li>
					<li><a class="navbar-btn-custom" href="admin" >Login</a></li>
				</ul>
  			</div>
		</nav>
	</header>
	
	<div class="container-fluid">
  		<div class="row">
  		
			<div class="col-md-6 col-sm-5" id="widget-buscador">
				<h2>Buscador de cursos</h2>
				<div class="input-group input-group-custom">
			       	<label for="buscadorCursos" class="input-group-addon">Buscar:</label>
			       	<input type="text" id="buscadorCursos" class="form-control" size= 55 placeholder="Buscar un curso"> 
			    </div>
			</div>
		
			<div class="col-md-6 col-sm-7" id="widget-lista-ultimos">
				<div>
					<c:if test="${ultimosCursos.size()>0 }">
					<h2>Ultimos Cursos</h2>
					<c:set var="contador" value="0" scope="page" />
					<ol>
						<c:forEach items="${ultimosCursos}" var="curso">
						<c:set var="contador" value="${contador + 1}" scope="page"/>
					
						<a class="list-anchor" href="detail/${curso.id}">
							<div class="container-li">
								<li class="list-item">
									<div class="list-number">${contador}</div>
									<div class="list-content">
										<div><p class="list-line">${curso.nomCurso}</p> </div>
										<div><p class="list-line"><strong>Código # ${curso.codCurso}</strong></p></div>
									</div>
								</li>
							</div>
						</a>
					
						</c:forEach>
					</ol>
					</c:if>
					<c:if test="${ultimosCursos.size()== 0}">
					<h3 class="lista-cursos"> Ups! Hay un problema que impide mostrar los últimos cursos </h3>
					</c:if>
				</div>
			</div>
		</div>
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
