package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.MascotaDAO;
import java.io.IOException;
import java.util.List;
@WebServlet("/MascotaServlet")
public class MascotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MascotaDAO dao;
    public MascotaServlet() {
        super();
        dao = new MascotaDAO();
    }
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
	int idmascota = Integer.parseInt(request.getParameter("id"));
	try {
		if (action.equalsIgnoreCase("create")) {
			dao.create(dao);
			request.getRequestDispatcher("mascotas.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("delete")) {
			dao.delete(idmascota);
			request.getRequestDispatcher("listaMascotas.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("read")) {
			dao.read(idmascota);
			request.getRequestDispatcher("listaMascotas.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("update")) {
			MascotaDAO lecturamascota = dao.read(idmascota);
			request.setAttribute("mascota", lecturamascota);
			request.getRequestDispatcher("listaMascotas.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("list")) {
			List<MascotaDAO> lista = MascotaDAO.listaMascotas();
	        request.setAttribute("listaMascotas", lista);
	        request.getRequestDispatcher("listaMascotas.jsp").forward(request, response);
		}
		else {
	    request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	} catch (Exception e) {
		throw new ServletException(e);
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}