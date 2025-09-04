package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@WebServlet("/PDFServlet")
public class PDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PDFServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/pdf"); // Indicar al navegador que el contenido será un archivo PDF
        response.setHeader("Content-Disposition", "inline; filename=mascotas.pdf"); //se mostrara directamente el pdf llamado mascotas.pdf en una ventana
        try  { //se crea el parametro del documento pdf
	        	Document document = new Document();
	            PdfWriter.getInstance(document, response.getOutputStream()); //genera el PDF y lo muestra directamente al navegador 
	            document.open();
	    	    String sql = "SELECT nombre, tipo, genero, raza, codigo FROM tblmascota";
	            Statement stmt = Conexion.conectarBD().createStatement(); //crea yprepara la sentencia SQL
	            ResultSet rs = stmt.executeQuery(sql); //envia los resultados asignados de la sentencia
	            document.add(new Paragraph("Lista de mascotas. " + "\n\n"));//parrafo inicial del pdf
		        PdfPTable table = new PdfPTable(5); //5 columnas
	            table.addCell("Nombre");
	            table.addCell("Tipo");
	            table.addCell("Género");
	            table.addCell("Raza");
	            table.addCell("Código");
	            while (rs.next()) {
	            //Crear una tabla con los parametros de tblmascota
		         table.addCell(rs.getString("nombre"));
		         table.addCell(rs.getString("tipo"));
		         table.addCell(rs.getString("genero"));
		         table.addCell(rs.getString("raza"));
		         table.addCell(rs.getString("codigo"));
				}
		        document.add(table);
	            document.close();
	            rs.close();
	            stmt.close();
	          //Cerrar documento, resultset y statement al final el procedimiento de la informacion asignada al pdf
			} catch (Exception e) {
				throw new ServletException(e);
			}
	} // El método POST se redirige al GET, para usar ambos métodos HTTP
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

