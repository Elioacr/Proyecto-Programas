<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Nueva programa </title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	</head>
		<body>
		<div class="container">
			<div class="row">
				<h1 class="col-12"> Agregar un nuevo programa </h1>
			</div>
				<form:form action="/agregar/programa" method="POST" modelAttribute="programa">
					<div class="row">
						<div class="col-4">
							<form:label class="form-label" path="titulo">
								Título:
							</form:label>							
						</div>
						<div class="col-8">
							<form:input class="form-control mb-4" path="titulo" type="text" name="titulo"/>
							<div>
								<form:errors class="alert alert-danger" path="titulo"/>
							</div>
						</div>				
					</div>
					<div class="row">
						<div class="col-4">
							<form:label class="form-label" path="red">
								Red:
							</form:label>							
						</div>
						<div class="col-8">
							<form:input class="form-control mb-4" path="red" type="text" name="red"/>
							<div>
								<form:errors class="alert alert-danger" path="red"/>
							</div>
						</div>				
					</div>
					<div class="row">
						<div class="col-4">
							<form:label class="form-label" path="descripcion">
								Descripción:
							</form:label>
						</div>
						<div class="col-8">
							<form:textarea class="form-control mb-4" path="descripcion" name="descripcion"/>
							<div>
								<form:errors class="alert alert-danger" path="descripcion"/>
							</div>
							<div class="text-right">
	    						<a href="/programas" class="btn btn-secondary me-2">Cancelar</a>
								<button class="btn btn-primary">
									Enviar
								</button>
							</div>
						</div>				
					</div>
				</form:form>
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	</body>
</html>