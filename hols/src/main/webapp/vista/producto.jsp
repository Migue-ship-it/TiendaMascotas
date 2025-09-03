<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
  <h1 class="mb-4">Agregar Producto</h1>
  <form action="${pageContext.request.contextPath}/ProductoServlet?action=create" method="post">
  <div class="my-3">
      <label for="codigobarras" class="form-label">Codigo de barras del producto</label>
      <input type="text" class="form-control" name="codigobarras" id="codigobarras" maxlength="50" required>
    </div>
    <div class="my-3">
      <label for="nombre" class="form-label">Nombre del producto</label>
      <input type="text" class="form-control" name="nombre" id="nombre" maxlength="50" required>
    </div>
    <div class="my-3">
      <label for="marca" class="form-label">marca</label>
      <input type="text" class="form-control" name="marca" id="marca" maxlength="100" required>
    </div>
    <div class="my-3">
      <label for="precio" class="form-label">precio</label>
       <input type="text" class="form-control" name="precio" id="precio" maxlength="10" required>
    </div>
     <a href="${pageContext.request.contextPath}/ProductoServlet?action=list">Listado de Productos</a><br><br>
    <button type="submit" class="btn btn-primary">Enviar</button>
    <button type="reset" class="btn btn-secondary">Limpiar</button>
  </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>