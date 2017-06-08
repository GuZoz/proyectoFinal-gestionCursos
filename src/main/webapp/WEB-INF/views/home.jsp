<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>
	<c:if test="${cursos.size()>0 }">
		<h2>Ranking Lanzamientos Historico</h2>
		<ol>
			<c:forEach items="${cursos}" var="curso">
				<li>${curso.nomCurso} - ${curso.codCurso}</li>
			</c:forEach>
		</ol>
	</c:if>
	<c:if test="${estadisticas.size()== 0}">
		<h2> No hay cursos </h2>
	</c:if>
</div>

</body>
</html>
