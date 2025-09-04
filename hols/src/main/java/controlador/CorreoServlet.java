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
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");
        // Configuración SMTP (servidor local sin autenticación de 2 pasos ni contraseñas de aplicacion)
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost"); // tu servidor SMTP
        props.put("mail.smtp.port", "587"); // puerto típico sin SSL
        Session session = Session.getInstance(props);
        try { //proceso de creacion y envio del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("miguelmartinez2864@gmail.com")); // remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);
            response.getWriter().println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
	

}
