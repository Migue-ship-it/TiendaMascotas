package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import controlador.Conexion;

public class ClienteDAO {
	private int id;
	private int cedula;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String correo;
	static Connection conexionBD = Conexion.conectarBD();
	static PreparedStatement pst = null; //preparar la transaccion
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "ClienteDAO [id=" + id + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + "]";
	}
	public List<ClienteDAO> listaClientes() {
		List<ClienteDAO> lista = new ArrayList<ClienteDAO>();
	     ClienteDAO m = new ClienteDAO();
		try {
			String script = "select * from tblcliente";
			pst = conexionBD.prepareStatement(script);
			ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
		     m.setId(rs.getInt("id"));
		     m.setCedula(rs.getInt("cedula"));
		     m.setNombres(rs.getString("nombres"));
		     m.setApellidos(rs.getString("apellidos"));
		     m.setDireccion(rs.getString("direccion"));
		     m.setTelefono(rs.getString("telefono"));
		     m.setCorreo(rs.getString("correo"));
		     lista.add(m);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void create(ClienteDAO dao) {
		String script = "INSERT INTO tblcliente(nombre, codigo, dosis, enfermedad) VALUES (?, ?, ?, ?)";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, dao.getCedula());
			pst.setString(2, dao.getNombres());
			pst.setString(3, dao.getApellidos());
			pst.setString(4, dao.getDireccion());
			pst.setString(5, dao.getTelefono());
			pst.setString(6, dao.getCorreo());
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
	public void read(int idcliente) {
		ClienteDAO user = new ClienteDAO();
		String script = "SELECT * FROM tblcliente where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idcliente);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user.setCedula(rs.getInt("cedula"));
				user.setNombres(rs.getString("nombres"));
				user.setApellidos(rs.getString("apellidos"));
				user.setDireccion(rs.getString("direccion"));
				user.setTelefono(rs.getString("telefono"));
				user.setCorreo(rs.getString("correo"));
			}	
		}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
}
	public void update(ClienteDAO dao) {
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