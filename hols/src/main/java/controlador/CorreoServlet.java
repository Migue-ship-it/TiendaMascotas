package controlador;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Properties;
@WebServlet("/CorreoServlet")
public class CorreoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
/*En este servlet se declaran 3 variables: to, subject y messageText, buscando un parámetro con sus nombres respectivos en la solicitud.
En las lineas 23-25, se usa la clase Properties para asignar la configuración SMTP (servidor local sin autenticación de 2 pasos ni contraseñas de aplicacion)
y un puerto SMTP sin SSL (protocolo de seguridad, evitando asi la autenticacion de 2 pasos, o contraseñas de aplicacion), luego en la linea 26, 
se inicializa un Session objeto de la API JavaMail utilizando los parámetros de configuración proporcionados en el props para enviar o recibir correos electrónicos.
Se asigna un try/catch para el proceso de creacion y envio del mensaje del remitente */
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miguelmartinez2864@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);
            response.getWriter().println("Correo enviado correctamente.");
        } catch (MessagingException e) { //Actualmente el mensaje al ejecutar el envio del correo indica un error en los props
            throw new RuntimeException(e);
        }
    }
}
