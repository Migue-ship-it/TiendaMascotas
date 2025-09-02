package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import controlador.Conexion;

public class VacunaDAO {
	private int id;
	private String nombre;
	private int codigo;
	private int dosis;
	private String enfermedad;
	static Connection conexionBD = Conexion.conectarBD();
	PreparedStatement pst = null; //preparar la transaccion
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDosis() {
		return dosis;
	}
	public void setDosis(int dosis) {
		this.dosis = dosis;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	@Override
	public String toString() {
		return "VacunaDAO [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", dosis=" + dosis
				+ ", enfermedad=" + enfermedad + "]";
	}
	public List<VacunaDAO> listaMascotas() {
		List<VacunaDAO> lista = new ArrayList<VacunaDAO>();
	     VacunaDAO m = new VacunaDAO();
		try {
			String script = "select * from tblvacunas";
			pst = conexionBD.prepareStatement(script);
			ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
		     m.setId(rs.getInt("id"));
		     m.setNombre(rs.getString("nombre"));
		     m.setCodigo(rs.getInt("codigo"));
		     m.setDosis(rs.getInt("dosis"));
		     m.setEnfermedad(rs.getString("enfermedad"));
		     lista.add(m);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void create(VacunaDAO dao) {
		String script = "INSERT INTO tblvacunas(nombre, codigo, dosis, enfermedad) VALUES (?, ?, ?, ?)";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setString(1, dao.getNombre());
			pst.setInt(2, dao.getCodigo());
			pst.setInt(3, dao.getDosis());
			pst.setString(4, dao.getEnfermedad());
			pst.executeUpdate();
		} catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
	}
	public void delete(int idvacuna) {
		String script = "delete from tblvacunas where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idvacuna);
				pst.executeUpdate();
		} catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
	}
	public void read(int idvacuna) {
		VacunaDAO user = new VacunaDAO();
		String script = "SELECT * FROM tblvacunas where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idvacuna);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user.setNombre(rs.getString("nombre"));
				user.setCodigo(rs.getInt("codigo"));
				user.setDosis(rs.getInt("dosis"));
				user.setEnfermedad(rs.getString("enfermedad"));
			}	
		}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
}
	public void update(VacunaDAO dao) {
		String script = "UPDATE tblvacunas set nombre = ?, codigo = ?, dosis = ?, enfermedad = ?, where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setString(1, dao.getNombre());
			pst.setInt(2, dao.getCodigo());
			pst.setInt(3, dao.getDosis());
			pst.setString(4, dao.getEnfermedad());
			pst.setInt(5, dao.getId());
			pst.executeUpdate();
			}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
}
}