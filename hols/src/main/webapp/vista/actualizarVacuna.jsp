<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<linkrel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/js/bootstrap.min.js"></script>
<title>informacion de vacunas</title>
</head>
<body>
	<h1>Actualizacion de informacion de la vacuna</h1>
	<form action="VacunaServlet" method="get">
		<div class="container">
		<label for="id">id de la vacuna</label>
		<input type="number" name="id" id="id" maxlength="10"><br><br/>
		<label for="nombre">Nombre de la vacuna</label>
		<input type="text" name="nombre" id="nombre" maxlength="10"><br><br/>
		<label for="codigo">Codigo perteneciente</label>
		<input type="number" name="codigo" id="codigo" maxlength="50"><br><br/>
		<label for="dosis">Dosis</label> 
		<input type="number" name="dosis" id="dosis" maxlength="10"><br><br/>
		<label for="enfermedad">enfermedad de la mascota</label>
		<input type="text" name="enfermedad" id="enfermedad" maxlength="50"><br><br/>
		<input class="button" type="submit" value="Enviar">
		<input class="button" type="reset" value="Limpiar">
	</form>
</body>
</html>