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
		/* En este codigo se refleja el proceso para el envio y seguridad de los mensajes mediante Properties, 
		para almacenar el servidor SMTP donde se dara la comunicacion a internet para el envio de correos. 
		Tambien el proceso y creacion del mensaje, todo esto mediante la API JavaMail.*/
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String messageText = request.getParameter("message");
        // Configuración SMTP (servidor local sin autenticación de 2 pasos ni contraseñas de aplicacion)
        Properties props = new Properties();
        props.put("mail.smtp.host", "localhost"); //host o direccion del servidor SMTP (local)
        props.put("mail.smtp.port", "587"); // puerto asignado mediante una contaseña de autenticacion en el Gmail del remitente
        props.put("mail.smtp.ssl.enable", "true"); //habilita el uso del SSL y protege la comunicacion SMTP
        props.put("mail.smtp.auth", "true"); //para enviar correos se autenticara mediante 2 pasos (contar con un dispositivo movil)
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
