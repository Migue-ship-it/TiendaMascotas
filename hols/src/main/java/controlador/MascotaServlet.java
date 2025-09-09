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
@WebServlet("/MascotaServlet") // URL de acceso al servlet
public class MascotaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MascotaDAO dao; //objeto de la clase MascotaDAO
    public MascotaServlet() {
        super();
        dao = new MascotaDAO(); // DAO inicializado al crear el servlet
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try { //parámetro "action" de la URL (segun la opcion que se elija en el action "mascotas.jsp"
            if ("delete".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                dao.delete(idmascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list"); // Redirige a la lista de clientes después del action seleccionado
            } else if ("update".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                Mascota mascota = dao.read(idmascota);
                request.setAttribute("mascotas", mascota);
                request.getRequestDispatcher("/vista/mascotas.jsp").forward(request, response);
            } else if ("list".equalsIgnoreCase(action)) {
                List<Mascota> lista = dao.listaMascotas(); //metodo de la clase MascotaDAO
                request.setAttribute("listaMascotas", lista);
                request.getRequestDispatcher("/vista/listaMascotas.jsp").forward(request, response);
            } else {
                // Cargar formulario por defecto
                request.getRequestDispatcher("/vista/mascotas.jsp").forward(request, response);
            }
        } catch (Exception e) { //Manejo de errores en el servlet
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
                Mascota mascota = new Mascota(nombre, tipo, genero, raza, codigo); //guardar en el DAO la informacion asignada en el objeto
                dao.create(mascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                String tipo = request.getParameter("tipo");
                String genero = request.getParameter("genero");
                String raza = request.getParameter("raza");
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                Mascota mascota = new Mascota(idmascota, nombre, tipo, genero, raza, codigo); // Crear objeto basado en un constructor de la clase Mascota con las variables asignadas
                dao.update(mascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list");
            }
        } catch (Exception e) {
            throw new ServletException("Error en el servlet: " + e.getMessage());
        }
    }

}


