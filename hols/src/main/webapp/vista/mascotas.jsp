<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mascota</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
  <h1 class="mb-4">Agregar mascota</h1>
  <form action="MascotaServlet?action=create" method="get">
    <div class="my-3">
      <label for="nombre" class="form-label">Nombre de la mascota</label>
      <input type="text" class="form-control" name="nombre" id="nombre" maxlength="50" required>
    </div>
    <div class="my-3">
      <label for="tipo" class="form-label">Tipo de mascota</label>
      <input type="text" class="form-control" name="tipo" id="tipo" maxlength="50" required>
    </div>
    <div class="my-3">
      <label for="genero" class="form-label">Género</label>
      <input type="text" class="form-control" name="genero" id="genero" maxlength="30" required>
    </div>
    <div class="my-3">
      <label for="raza" class="form-label">Raza</label>
      <input type="text" class="form-control" name="raza" id="raza" maxlength="50" required>
    </div>
    <div class="my-3">
      <label for="codigo" class="form-label">Código perteneciente</label>
      <input type="number" class="form-control" name="codigo" id="codigo" maxlength="10" required>
    </div>
     <a href="MascotaServlet?action=list">Listado de mascotas</a><br><br>
    <button type="submit" class="btn btn-primary">Enviar</button>
    <button type="reset" class="btn btn-secondary">Limpiar</button>
  </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
