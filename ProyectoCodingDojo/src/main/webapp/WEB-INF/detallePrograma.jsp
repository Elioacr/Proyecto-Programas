<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalles del Programa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-8">
                <h1 class="mb-0">${programa.titulo}</h1>
            </div>
            <div class="col-md-4 d-flex justify-content-end">
                <a href="/programas" class="btn btn-link">Volver al panel</a>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-4">
                <p><strong>Agregado por:</strong></p>
                <p>Red de Television:</p>
                <p>Descripción:</p>
            </div>
            <div class="col-md-8">
                <p><strong>${programa.usuario.nombre}</strong></p>
                <p>${programa.red}</p>
                <p>${programa.descripcion}</p>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-12">
                <a href="/editar/programa/${programa.id}" class="btn btn-primary">Editar</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>