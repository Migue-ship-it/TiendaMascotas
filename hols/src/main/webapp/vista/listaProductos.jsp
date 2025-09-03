<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, modelo.Producto"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">Productos registrados</h1>
    <a href="producto.jsp" class="btn btn-success mb-3">Agregar producto</a>
    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Codigo de barras</th>
                    <th>Nombre</th>
                    <th>Marca</th>
                    <th>Precio $</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Producto> lista = (List<Producto>) request.getAttribute("listaProductos");
                if (lista != null && !lista.isEmpty()) {
                        for (Producto manpulacionDatos : lista) {
                %>
                    <tr>
                        <td><%= manpulacionDatos.getId() %></td>
                        <td><%= manpulacionDatos.getCodigobarras() %></td>
                        <td><%= manpulacionDatos.getNombre() %></td>
                        <td><%= manpulacionDatos.getMarca() %></td>
                        <td><%= manpulacionDatos.getPrecio() %></td>
                        <td>
                            <a href="<%= request.getContextPath() %>/ProductoServlet?action=update&id=<%= manpulacionDatos.getId() %>" 
                               class="btn btn-warning btn-sm">Editar</a>
                            <a href="<%= request.getContextPath() %>/ProductoServlet?action=delete&id=<%= manpulacionDatos.getId() %>" 
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
