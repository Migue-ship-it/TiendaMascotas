<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, modelo.Cliente"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Clientes registrados</h1>
    <a href="clientes.jsp" class="btn btn-success mb-3">Agregar cliente</a>
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Cedula</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Correo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Cliente> lista = (List<Cliente>) request.getAttribute("listaClientes");
                if (lista != null && !lista.isEmpty()) {
                        for (Cliente manpulacionDatos : lista) {
                %>
                    <tr>
                        <td><%= manpulacionDatos.getId() %></td>
                        <td><%= manpulacionDatos.getCedula() %></td>
                        <td><%= manpulacionDatos.getNombres() %></td>
                        <td><%= manpulacionDatos.getApellidos() %></td>
                        <td><%= manpulacionDatos.getDireccion() %></td>
                        <td><%= manpulacionDatos.getTelefono() %></td>
                        <td><%= manpulacionDatos.getCorreo() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/ClienteServlet?action=update&id=<%= manpulacionDatos.getId() %>" 
                               class="btn btn-warning btn-sm">Editar</a>
                            <a href="<%= request.getContextPath() %>/ClienteServlet?action=delete&id=<%= manpulacionDatos.getId() %>" 
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

