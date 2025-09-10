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
@WebServlet("/ClienteServlet") // URL de acceso al servlet
public class ClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDAO dao; //objeto de la clase ClienteDAO
    public ClienteServlet() {
        super();
        dao = new ClienteDAO(); // DAO inicializado al crear el servlet
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
/*Dentro de este metodo (para recuperar, borrar o mostrar información de un servidor, declara una String y le asigna el valor del parámetro recuperado,
en caso de ser equivalente "action", en las acciones "delete" y "update", se obtiene el id del cliente, se llama al objeto dao con los metodos DAO para borrar, crear o mostrar los parametros segun el id declarado
edirige a la lista de clientes o cliente.jsp después del action seleccionado*/
        String action = request.getParameter("action");
        try {  
            if ("delete".equalsIgnoreCase(action)) {
                int idCliente = Integer.parseInt(request.getParameter("id"));
                dao.delete(idCliente);
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=list");
            } else if ("read".equalsIgnoreCase(action)) {
                int idCliente = Integer.parseInt(request.getParameter("id"));
                Cliente Cliente = dao.read(idCliente); 
                request.setAttribute("Clientes", Cliente); //almacenar el objeto Cliente bajo la clave "Clientes" en la solicitud HTTP
                response.sendRedirect(request.getContextPath() + "/ClienteServlet?action=read"); // Envía el objeto a la vista cliente
            } else if ("list".equalsIgnoreCase(action)) {
                List<Cliente> lista = dao.listaClientes();
                request.setAttribute("listaClientes", lista); //almacenar el objeto lista bajo la clave "listaClientes" en el ámbito de la solicitud HTTP
                request.getRequestDispatcher("/vista/listaClientes.jsp").forward(request, response); // Envía el objeto a la vista de la listaclientes
            } else {
                request.getRequestDispatcher("/vista/cliente.jsp").forward(request, response);                 // Cargar formulario por defecto
                // Cargar formulario por defecto
            }
        } catch (Exception e) { //Manejo de errores en el servlet
            throw new ServletException("Error en ClienteServlet (GET): " + e.getMessage(), e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        /*Dentro del metodo doPost (no muestra datos existentes o para crear) declara una String y le asigna el valor del parámetro recuperado, si el valor de la action es igual a la cadena "create",
        se obtienen los parametros de las lineas 55-60 (mismo caso para la condicional con la action update en las lineas 65-71), declara un objeto llamando al constructor de la clase Cliente para guardar la informacion de los parametros
        declara un objeto llamando al constructor de la clase Cliente para guardar la informacion de los parametros de las lineas 51-56, guardar la informacion asignada en el DAO en el objeto */
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

