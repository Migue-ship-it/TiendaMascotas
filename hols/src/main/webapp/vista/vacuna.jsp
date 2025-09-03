<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vacuna</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
  <h1 class="mb-4">Agregar Vacuna</h1>
  <form action="${pageContext.request.contextPath}/VacunaServlet?action=create" method="post">
    <div class="my-3">
      <label for="nombre" class="form-label">Nombre de la vacuna</label>
      <input type="text" class="form-control" name="nombre" id="nombre" maxlength="50" required>
    </div>
    <div class="my-3">
      <label for="codigo" class="form-label">codigo</label>
      <input type="number" class="form-control" name="codigo" id="codigo" maxlength="10" required>
    </div>
    <div class="my-3">
      <label for="dosis" class="form-label">dosis</label>
       <input type="number" class="form-control" name="dosis" id="dosis" maxlength="10" required>
    </div>
    <div class="my-3">
      <label for="enfermedad" class="form-label">enfermedad</label>
       <input type="text" class="form-control" name="enfermedad" id="enfermedad" maxlength="50" required>
    </div>
     <a href="${pageContext.request.contextPath}/VacunaServlet?action=list">Listado de Vacunas</a><br><br>
    <button type="submit" class="btn btn-primary">Enviar</button>
    <button type="reset" class="btn btn-secondary">Limpiar</button>
  </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>