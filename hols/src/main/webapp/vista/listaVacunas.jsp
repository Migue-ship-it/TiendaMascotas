<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, modelo.Vacuna"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Vacunas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Vacunas registradas</h1>
    <a href="vacuna.jsp" class="btn btn-success mb-3">Agregar vacuna</a>
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Codigo</th>
                    <th>Dosis</th>
                    <th>Enfermedad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Vacuna> lista = (List<Vacuna>) request.getAttribute("listaVacunas");
                if (lista != null && !lista.isEmpty()) {
                        for (Vacuna manpulacionDatos : lista) {
                %>
                    <tr>
                        <td><%= manpulacionDatos.getId() %></td>
                        <td><%= manpulacionDatos.getNombre() %></td>
                        <td><%= manpulacionDatos.getCodigo() %></td>
                        <td><%= manpulacionDatos.getDosis() %></td>
                        <td><%= manpulacionDatos.getEnfermedad() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/VacunaServlet?action=update&id=<%= manpulacionDatos.getId() %>" 
                               class="btn btn-warning btn-sm">Editar</a>
                            <a href="<%= request.getContextPath() %>/VacunaServlet?action=delete&id=<%= manpulacionDatos.getId() %>" 
                               class="btn btn-danger btn-sm">Eliminar</a>
                        </td>
                    </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
