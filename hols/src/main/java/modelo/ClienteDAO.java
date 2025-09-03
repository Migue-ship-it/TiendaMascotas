package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controlador.Conexion;
public class ClienteDAO {
	static Connection conexionBD = Conexion.conectarBD();
	static PreparedStatement pst = null; //preparar la transaccion
	public List<Cliente> listaClientes() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			String script = "select * from tblcliente";
			pst = conexionBD.prepareStatement(script);
			ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
			Cliente c = new Cliente(rs.getInt("id"), rs.getInt("cedula"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"));
		     lista.add(c);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void create(Cliente cliente) {
		String script = "INSERT INTO tblcliente(cedula, nombres, apellidos, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, cliente.getCedula());
			pst.setString(2, cliente.getNombres());
			pst.setString(3, cliente.getApellidos());
			pst.setString(4, cliente.getDireccion());
			pst.setString(5, cliente.getTelefono());
			pst.setString(6, cliente.getCorreo());
			pst.executeUpdate();
		} catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
	}
	public void delete(int idcliente) {
		String script = "delete from tblcliente where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idcliente);
				pst.executeUpdate();
		} catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
	}
	public Cliente read(int idcliente) {
		Cliente user = null;
		String script = "SELECT * FROM tblcliente where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idcliente);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user = new Cliente(rs.getInt("cedula"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("correo"));
			}	
		}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
		return user;
}
	public void update(Cliente dao) {
		String script = "UPDATE tblcliente set cedula = ?, nombres = ?,  apellidos = ?, direccion = ?, telefono = ?, correo = ?, where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, dao.getCedula());
			pst.setString(2, dao.getNombres());
			pst.setString(3, dao.getApellidos());
			pst.setString(4, dao.getDireccion());
			pst.setString(5, dao.getTelefono());
			pst.setString(6, dao.getCorreo());
			pst.setInt(7, dao.getId());
			pst.executeUpdate();
			}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
}
}