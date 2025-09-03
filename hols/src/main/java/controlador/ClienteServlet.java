package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import java.io.IOException;
import java.util.List;
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDAO dao;
    public ClienteServlet() {
        super();
        dao = new ClienteDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equalsIgnoreCase(action)) {
                int idCliente = Integer.parseInt(request.getParameter("id"));
                dao.delete(idCliente);
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idCliente = Integer.parseInt(request.getParameter("id"));
                Cliente Cliente = dao.read(idCliente);
                request.setAttribute("Clientes", Cliente);
                request.getRequestDispatcher("/vista/cliente.jsp").forward(request, response);
            } else if ("list".equalsIgnoreCase(action)) {
                List<Cliente> lista = dao.listaClientes();
                request.setAttribute("listaClientes", lista);
                request.getRequestDispatcher("/vista/listaClientes.jsp").forward(request, response);
            } else {
                // Cargar formulario por defecto
                request.getRequestDispatcher("/vista/cliente.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("Error en ClienteServlet (GET): " + e.getMessage(), e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("create".equalsIgnoreCase(action)) {
                int cedula = Integer.parseInt(request.getParameter("cedula"));
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String direccion = request.getParameter("direccion");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                Cliente Cliente = new Cliente(cedula, nombres, apellidos, direccion, telefono, correo);
                dao.create(Cliente);
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idCliente = Integer.parseInt(request.getParameter("id"));
                int cedula = Integer.parseInt(request.getParameter("cedula"));
                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String direccion = request.getParameter("direccion");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                Cliente Cliente = new Cliente(idCliente, cedula, nombres, apellidos, direccion, telefono, correo);
                dao.update(Cliente);
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=list");
            }
        } catch (Exception e) {
            throw new ServletException("Error en el servlet: " + e.getMessage());
        }
    }
}