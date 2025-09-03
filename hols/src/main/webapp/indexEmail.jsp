<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enviar Correo</title>
</head>
<body>
<div class="my-3">
<h2>Enviar Correo</h2>
<form action="${pageContext.request.contextPath}/CorreoServlet" method="post">
        Para: <input type="text" name="to"><br><br>
        Asunto: <input type="text" name="subject"><br><br>
        Mensaje:<br><textarea name="message" rows="5" cols="40"></textarea><br><br>
        <input type="submit" value="Enviar">
    </form>
    <a href="index.jsp">Index de la pagina web (clientes, mascotas, vacunas, productos)</a><br></br>
    <a href = "PDFServlet" target = "_self">Descargar PDF de informacion de mascotas</a><br></br>
     </div>
</body>
</html>