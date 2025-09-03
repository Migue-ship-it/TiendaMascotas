package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;
import modelo.ProductoDAO;
import java.io.IOException;
import java.util.List;
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductoDAO dao;
    public ProductoServlet() {
        super();
        dao = new ProductoDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equalsIgnoreCase(action)) {
                int idProducto = Integer.parseInt(request.getParameter("id"));
                dao.delete(idProducto);
                response.sendRedirect(request.getContextPath() + "/ProductoServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idProducto = Integer.parseInt(request.getParameter("id"));
                Producto Producto = dao.read(idProducto);
                request.setAttribute("Productos", Producto);
                request.getRequestDispatcher("/vista/producto.jsp").forward(request, response);
            } else if ("list".equalsIgnoreCase(action)) {
                List<Producto> lista = dao.listaProductos();
                request.setAttribute("listaProductos", lista);
                request.getRequestDispatcher("/vista/listaProductos.jsp").forward(request, response);
            } else {
                // Cargar formulario por defecto
                request.getRequestDispatcher("/vista/producto.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("Error en ProductoServlet (GET): " + e.getMessage(), e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("create".equalsIgnoreCase(action)) {
                String codigodebarras = request.getParameter("codigobarras");
                String nombres = request.getParameter("nombre");
                String marca = request.getParameter("marca");
                String $ = request.getParameter("precio");
                Producto Producto = new Producto(codigodebarras, nombres, marca, $);
                dao.create(Producto);
                response.sendRedirect(request.getContextPath() + "/ProductoServlet?action=list");
            } else if ("update".equalsIgnoreCase(action)) {
                int idProducto = Integer.parseInt(request.getParameter("id"));
                String codigodebarras = request.getParameter("codigobarras");
                String nombres = request.getParameter("nombre");
                String marca = request.getParameter("marca");
                String $ = request.getParameter("precio");
                Producto Producto = new Producto(idProducto, codigodebarras, nombres, marca, $);
                dao.update(Producto);
                response.sendRedirect(request.getContextPath() + "/ProductoServlet?action=list");
            }
        } catch (Exception e) {
            throw new ServletException("Error en el servlet: " + e.getMessage());
        }
    }
}