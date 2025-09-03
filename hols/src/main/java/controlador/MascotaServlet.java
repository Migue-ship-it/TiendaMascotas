package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Mascota;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                dao.delete(idmascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                Mascota mascota = dao.read(idmascota);
                request.setAttribute("mascotas", mascota);
                request.getRequestDispatcher("/vista/mascotas.jsp").forward(request, response);
            } else if ("list".equalsIgnoreCase(action)) {
                List<Mascota> lista = dao.listaMascotas();
                request.setAttribute("listaMascotas", lista);
                request.getRequestDispatcher("/vista/listaMascotas.jsp").forward(request, response);
            } else {
                // Cargar formulario por defecto
                request.getRequestDispatcher("/vista/mascota.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("Error en el servlet (parametros en el url): " + e.getMessage(), e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("create".equalsIgnoreCase(action)) {
                String nombre = request.getParameter("nombre");
                String tipo = request.getParameter("tipo");
                String genero = request.getParameter("genero");
                String raza = request.getParameter("raza");
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Mascota mascota = new Mascota(nombre, tipo, genero, raza, codigo);
                dao.create(mascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String tipo = request.getParameter("tipo");
                String genero = request.getParameter("genero");
                String raza = request.getParameter("raza");
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Mascota mascota = new Mascota(idmascota, nombre, tipo, genero, raza, codigo);
                dao.update(mascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list");
            }
        } catch (Exception e) {
            throw new ServletException("Error en el servlet: " + e.getMessage());
        }
    }
}