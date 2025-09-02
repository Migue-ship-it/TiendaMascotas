<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<linkrel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/js/bootstrap.min.js"></script>
<title>informacion de la mascota</title>
</head>
<body>
	<h1>Actualizacion de informacion de la mascota</h1>
	<form action="MascotaServlet" method="get">
		<div class="container">
			<label for="id">id de la mascota</label>
			<input type="number" name="id" id="id" maxlength="10"><br><br/> 
			<label for="nombre">Nombre de la mascota</label>
			<input class="bloque" type="number" name="id" id="id" maxlength="10"><br><br/> 
			<label for="tipo">Tipo de mascota</label> 
			<input type="text" name="tipo" id="tipo" maxlength="50"><br><br/> 
			<label for="genero">Genero</label> 
			<input type="text" name="genero" id="genero" maxlength="30"><br><br/> 
			<label for="raza">Raza</label> 
			<input type="text" name="raza" id="raza" maxlength="50"><br><br/> 
			<label for="codigo">Codigo perteneciente</label> 
			<input type="number" name="codigo" id="codigo" maxlength="10"><br><br/> 
			<input class="button" type="submit" value="Actualizar">
	</form>
</body>
</html>