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
/*Dentro de este metodo (para recuperar, borrar o mostrar información de un servidor), declara una String y le asigna el valor del parámetro recuperado,
en caso de ser equivalente "action", en las acciones "delete" y "update", se obtiene el id de la mascota, se llama al objeto dao con los metodos DAO para borrar, crear o mostrar los parametros segun el id declarado
Este se redirige a la lista de mascotas o mascotas.jsp después del action seleccionado*/
        String action = request.getParameter("action");
        try { //parámetro "action" de la URL (segun la opcion que se elija en el action "mascotas.jsp"
            if ("delete".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                dao.delete(idmascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=list"); // Redirige a la lista de clientes después del action seleccionado
            } else if ("read".equalsIgnoreCase(action)) {
                int idmascota = Integer.parseInt(request.getParameter("id"));
                Mascota mascota = dao.read(idmascota);
                request.setAttribute("mascotas", mascota);
                response.sendRedirect(request.getContextPath() + "/MascotaServlet?action=read");
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
        /*Dentro del metodo doPost (no muestra datos existentes o para crear) declara una String y le asigna el valor del parámetro recuperado, si el valor de la action es igual a la cadena "create",
        se obtienen los parametros de las lineas 57-61 (mismo caso para la condicional con la action update en las lineas 65-74), declara un objeto llamando al constructor de la clase Mascota para guardar la informacion de los parametros
        declara un objeto llamando al constructor de la clase Mascota para guardar la informacion de los parametros de las lineas 66-71, guardar la informacion asignada en el DAO en el objeto */
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




