<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
<linkrel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/5.3.7/js/bootstrap.min.js"></script>
<title>informacion acerca del producto</title>
</head>
<body>
	<h1>Actualizacion de informacion del producto</h1>
	<form action="ProductoServlet" method="get">
		<div class="container">
		<label for="id">id del producto</label>
			 <input type="number" name="id" id="id" maxlength="10"><br><br/>
			<label for="codigobarras">Codigo de barras</label>
			<input type="text" name="codigobarras" id="codigobarras" maxlength="50"><br><br/>
			<label for="nombre">Nombre del producto</label>
			<input type="text" name="nombre" id="nombre" maxlength="50"><br><br/>
			<label for="marca">marca</label> 
			<input type="text" name="marca" id="marca" maxlength="100"><br><br/>
			<label for="precio">precio $</label>
			<input type="text" name="precio" id="precio" maxlength="10"><br><br/>
			<input class="button" type="submit" value="Enviar">
			<input class="button" type="reset" value="Limpiar">
	</form>
</body>
</html>