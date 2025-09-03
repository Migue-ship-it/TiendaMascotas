package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controlador.Conexion;
public class VacunaDAO {
	static Connection conexionBD = Conexion.conectarBD();
	PreparedStatement pst = null; //preparar la transaccion
	public List<Vacuna> listaVacunas() {
		List<Vacuna> lista = new ArrayList<Vacuna>();
		try {
			String script = "select * from tblvacunas";
			pst = conexionBD.prepareStatement(script);
			ResultSet rs = pst.executeQuery();
			 while (rs.next()) {
			 Vacuna m = new Vacuna(rs.getInt("id"), rs.getString("nombre"), rs.getInt("codigo"), rs.getInt("dosis"), rs.getString("enfermedad"));
		     lista.add(m);
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void create(Vacuna dao) {
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
	public Vacuna read(int idvacuna) {
		Vacuna user = null;
		String script = "SELECT * FROM tblvacunas where id = ?";
		try {
			pst = conexionBD.prepareStatement(script);
			pst.setInt(1, idvacuna);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				user = new Vacuna(rs.getString("nombre"), rs.getInt("codigo"), rs.getInt("dosis"), rs.getString("enfermedad"));
			}	
		}
		catch (Exception errorconexion) {
			errorconexion.printStackTrace();
		}
		return user;
}
	public void update(Vacuna dao) {
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