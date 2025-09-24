package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Vacuna;
import modelo.VacunaDAO;
import java.io.IOException;
import java.util.List;
@WebServlet("/VacunaServlet") // URL de acceso al servlet
public class VacunaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VacunaDAO dao; //objeto de la clase VacunaDAO
    public VacunaServlet() {
        super();
        dao = new VacunaDAO(); // DAO inicializado al crear el servlet
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
/*Dentro de este metodo (para recuperar, borrar o mostrar información de un servidor, declara una String y le asigna el valor del parámetro recuperado,
en caso de ser equivalente "action", en las acciones "delete" y "update", se obtiene el id del la vacuna, se llama al objeto dao con los metodos DAO para borrar, crear o mostrar los parametros segun el id declarado
Este se redirige a la lista de vacunas o vacuna.jsp después del action seleccionado*/
        String action = request.getParameter("action");
        try { //parámetro "action" de la URL (segun la opcion que se elija en el action "vacuna.jsp"
            if ("delete".equalsIgnoreCase(action)) {
                int idVacuna = Integer.parseInt(request.getParameter("id"));
                dao.delete(idVacuna);
                response.sendRedirect(request.getContextPath() + "/VacunaServlet?action=list");
            } else if ("read".equalsIgnoreCase(action)) {
                int idVacuna = Integer.parseInt(request.getParameter("id"));
                Vacuna Vacuna = dao.read(idVacuna);
                request.setAttribute("Vacunas", Vacuna); // Envía el objeto a la vista
                response.sendRedirect(request.getContextPath() + "/VacunaServlet?action=read");
            } else if ("list".equalsIgnoreCase(action)) {
                List<Vacuna> lista = dao.listaVacunas();
                request.setAttribute("listaVacunas", lista);
                request.getRequestDispatcher("/vista/listaVacunas.jsp").forward(request, response);
            } else {
                // Cargar formulario por defecto
                request.getRequestDispatcher("/vista/vacuna.jsp").forward(request, response);
            }
        } catch (Exception e) { //Manejo de errores en el servlet
            throw new ServletException("Error en VacunaServlet (GET): " + e.getMessage(), e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         /*Dentro del metodo doPost (no muestra datos existentes o para crear) declara una String y le asigna el valor del parámetro recuperado, si el valor de la action es igual a la cadena "create",
        se obtienen los parametros de las lineas 57-61 (mismo caso para la condicional con la action update en las lineas 64-72), declara un objeto llamando al constructor de la clase Vacuna para guardar la informacion de los parametros
        declara un objeto llamando al constructor de la clase Vacuna para guardar la informacion de los parametros de las lineas 65-69, guardar la informacion asignada en el DAO en el objeto */
        String action = request.getParameter("action");
        try {
            if ("create".equalsIgnoreCase(action)) {
                String nombre = request.getParameter("nombre");
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                int dosis = Integer.parseInt(request.getParameter("dosis"));
                String enfermedad = request.getParameter("enfermedad");
                Vacuna Vacuna = new Vacuna(nombre, codigo, dosis, enfermedad); 
                dao.create(Vacuna); // guardar en el DAO la informacion asignada en el objeto
                response.sendRedirect(request.getContextPath() + "/VacunaServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idVacuna = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                int dosis = Integer.parseInt(request.getParameter("dosis"));
                String enfermedad = request.getParameter("enfermedad");
                Vacuna Vacuna = new Vacuna(idVacuna, nombre, codigo, dosis, enfermedad); // Crear objeto basado en un constructor de la clase Vacuna con las variables asignadas
                dao.update(Vacuna);
                response.sendRedirect(request.getContextPath() + "/VacunaServlet?action=list");
            }
        } catch (Exception e) {
            throw new ServletException("Error en el servlet: " + e.getMessage());
        }
    }
}
