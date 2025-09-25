<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List, modelo.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
  <h1 class="mb-4">Actualizar Cliente</h1>
  <form action = "${pageContext.request.contextPath}/ClienteServlet?action=update" method="post">
  <div class="my-3">
  <label for="cedula" class="form-label">Cedula del Cliente</label>
      <input type="text" class="form-control" name="cedula" id="cedula" maxlength="20" value="${Clientes.getCedula()}" required>
  </div>
  <div class="my-3">
      <label for="nombres" class="form-label">Nombres del Cliente</label>
      <input type="text" class="form-control" name="nombres" id="nombres" maxlength="50" value="${Clientes.getNombres()}" required>
    </div>
    <div class="my-3">
      <label for="apellidos" class="form-label">apellidos</label>
      <input type="text" class="form-control" name="apellidos" id="apellidos" maxlength="50" value="${Clientes.getApellidos()}" required>
    </div>
    <div class="my-3">
      <label for="direccion" class="form-label">direccion</label>
       <input type="text" class="form-control" name="direccion" id="direccion" maxlength="50" value="${Clientes.getDireccion()}" required>
    </div>
    <div class="my-3">
      <label for="telefono" class="form-label">Numero telefonico</label>
       <input type="text" class="form-control" name="telefono" id="telefono" maxlength="30" value="${Clientes.getTelefono()}" required>
    </div>
    <div class="my-3">
      <label for="correo" class="form-label">Correo electronico</label>
       <input type="text" class="form-control" name="correo" id="correo" maxlength="80" value="${Clientes.getCorreo()}" required>
    </div>
     <a href="${pageContext.request.contextPath}/ClienteServlet?action=list">Listado de Clientes</a><br><br>
    <button type="submit" class="btn btn-primary">Enviar</button>
    <button type="reset" class="btn btn-secondary">Limpiar</button>
  </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
