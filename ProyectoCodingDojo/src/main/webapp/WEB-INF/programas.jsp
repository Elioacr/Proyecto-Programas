<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Programas </title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<div class="row"><br>
				<h1 class="col-6"> Bienvenid@s, ${nombre_usuario}</h1>
				<a class="col-2" href="/logout"> cerrar sesión </a>
			</div>
			<p>Programas</p>
			<div class="row">
				<table class="table table-striped">
					<tr>
						<th> Programa </th>
						<th> Red </th>
					</tr>
					<c:forEach var="programa" items="${programas}">
						<tr>
							<td><a href="/programas/${programa.id}">${programa.titulo}</a></td>
							<td> ${programa.red} </td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<a href="/programas/nuevo" class="btn btn-primary">
    				Agregar un Programa
			</a>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>