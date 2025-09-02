<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<linkrel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/js/bootstrap.min.js"></script>
<title>informacion del cliente</title>
</head>
<body>
	<h1>Actualizacion de informacion del cliente</h1>
	<form action="ClienteServlet" method="get">
		<div class="container">
			<label for="id">id del cliente</label>
			<input type="number" name="id" id="id" maxlength="10"><br><br/>
			<label for="cedula">cedula</label>
			<input type="number" name="cedula" id="cedula" maxlength="20"><br><br/>
			<label for="nombres">Nombres completos del cliente</label>
			<input type="text" name="nombres" id="nombres" maxlength="50"><br><br/>
			<label for="apellidos">apellidos</label>
			<input type="text" name="apellidos" id="apellidos" maxlength="50"><br><br/>
			<label for="direccion">direccion</label>
			<input type="text" name="direccion" id="direccion" maxlength="50"><br><br/>
			<label for="telefono">Numero telefonico</label>
			<input type="text" name="telefono" id="telefono" maxlength="30"><br><br/>
			<label for="correo">correo electronico</label>
			<input type="text" name="correo" id="correo" maxlength="80"><br><br/> 
			<input class="button" type="submit" value="Actualizar">
	</form>
</body>
</html>