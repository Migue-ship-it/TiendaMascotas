<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, modelo.MascotaDAO"%>
<html>
<head>
    <title>Listado de mascotas</title>
</head>
<body>
        <h1>Informacion de mascotas registradas</h1>
        <h1 class="mb-4">Agregar mascota</h1>    
        <div align="center">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nombre de la mascota</th>
                <th>tipo</th>
                <th>genero</th>
                <th>raza</th>
                <th>codigo</th>
            </tr>
            <c:forEach items="${tblmascota}">
                <tr>
                    <td><c:out value="${tblmascota.id}" /></td>
                    <td><c:out value="${tblmascota.nombre}" /></td>
                    <td><c:out value="${tblmascota.tipo}" /></td>
                    <td><c:out value="${tblmascota.genero}" /></td>
                    <td><c:out value="${tblmascota.raza}" /></td>
                    <td><c:out value="${tblmascota.codigo}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/MascotaServlet?action=update&id=<c:out value='${tblmascota.id}' />">Update</a>
                        <a href="${pageContext.request.contextPath}/MascotaServlet?action=delete&id=<c:out value='${tblmascota.id}' />">Delete</a>                      
                    </td>
                </tr>
                </c:forEach>
        </table>
    </div> 
    <a href="mascotas.jsp">nueva mascota</a>
</body>
</html>