package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controlador.Conexion;

public class ProductoDAO {
	private int id;
	private String codigobarras;
	private String nombre;
	private String marca;
	private String precio;
	static Connection conexionBD = Conexion.conectarBD();
	PreparedStatement pst = null; //preparar la transaccion
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigobarras() {
		return codigobarras;
	}
	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "ProductoDAO [id=" + id + ", codigobarras=" + codigobarras + ", nombre=" + nombre + ", marca=" + marca
				+ ", precio=" + precio + "]";
	}
	public List<ProductoDAO> listaMascotas() {
		List<ProductoDAO> lista = new ArrayList<ProductoDAO>();
	     ProductoDAO m = new ProductoDAO();
		try {
			String script = "select * from tblmascota";
			pst = conexionBD.prepareStatement(script);
			ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
		     m.setId(rs.getInt("id"));
		     m.setCodigobarras(rs.getString("codigobarras"));
		     m.setNombre(rs.getString("nombre"));
		     m.setMarca(rs.getString("marca"));
		     m.setPrecio(rs.getString("precio"));
		     lista.add(m);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void create(ProductoDAO dao) {
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
	public void read(int idproducto) {
		ProductoDAO user = new ProductoDAO();
		String script = "SELECT * FROM tblproductos where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idproducto);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user.setCodigobarras(rs.getString("codigobarras"));
				user.setNombre(rs.getString("nombre"));
				user.setMarca(rs.getString("marca"));
				user.setPrecio(rs.getString("precio"));
			}	
		}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
}
	public void update(ProductoDAO dao) {
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