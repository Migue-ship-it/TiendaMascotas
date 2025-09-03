package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controlador.Conexion;
public class ProductoDAO {
static Connection conexionBD = Conexion.conectarBD();
PreparedStatement pst = null; //preparar la transaccion

	public List<Producto> listaProductos() {
		List<Producto> lista = new ArrayList<Producto>();
		try {
			String script = "select * from tblproductos";
			pst = conexionBD.prepareStatement(script);
			ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
		    Producto p = new Producto (rs.getInt("id"), rs.getString("codigobarras"),rs.getString("nombre"), rs.getString("marca"), rs.getString("precio"));
		     lista.add(p);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void create(Producto dao) {
		String script = "INSERT INTO tblproductos(codigobarras, nombre, marca, precio) VALUES (?, ?, ?, ?)";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setString(1, dao.getCodigobarras());
			pst.setString(2, dao.getNombre());
			pst.setString(3, dao.getMarca());
			pst.setString(4, dao.getPrecio());
			pst.executeUpdate();
		} catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
	}
	public void delete(int idproducto) {
		String script = "delete from tblproductos where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idproducto);
				pst.executeUpdate();
		} catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
	}
	public Producto read(int idproducto) {
		Producto user = null;
		String script = "SELECT * FROM tblproductos where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idproducto);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user = new Producto(rs.getString("codigobarras"), rs.getString("nombre"), rs.getString("marca"), rs.getString("precio"));
			}	
		}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
		return user;
}
	public void update(Producto dao) {
		String script = "UPDATE tblproductos set codigobarras = ?, nombre = ?, marca = ?, precio = ?, where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setString(1, dao.getCodigobarras());
			pst.setString(2, dao.getNombre());
			pst.setString(3, dao.getMarca());
			pst.setString(4, dao.getPrecio());
			pst.setInt(5, dao.getId());
			pst.executeUpdate();
			}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
}
}