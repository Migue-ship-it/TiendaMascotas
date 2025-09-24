package controlador;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Properties;
import jakarta.mail.PasswordAuthentication;
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
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "localhost"); //host o direccion del servidor SMTP (local)
        props.put("mail.smtp.port", "487"); // puerto TLS
        props.put("mail.smtp.ssl.enable", "true"); //habilita el uso del SSL y protege la comunicacion SMTP
        props.put("mail.smtp.auth", "true"); //para enviar correos se autenticara mediante 2 pasos (contar con un dispositivo movil)
        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication() {
        		return new PasswordAuthentication(to, "tfeu tlxn mzqy unzi");
        	}
        });
        try { //proceso de creacion y envio del mensaje
            Message message = new MimeMessage(session);
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");
            message.setFrom(new InternetAddress("miguelmartinez2864@gmail.com")); // remitente
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject, "UTF-8");
            message.setText(messageText, "UTF-8");
			message.setSentDate(new Date());
            Transport.send(message);
            response.getWriter().println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
