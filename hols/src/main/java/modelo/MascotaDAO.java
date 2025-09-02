package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controlador.Conexion;

public class MascotaDAO {
	private int id;
	private String nombre;
	private String tipo;
	private String genero;
	private String raza;
	private int codigo;
	private MascotaDAO user;
	static Connection conexionBD = Conexion.conectarBD();
	static PreparedStatement pst = null; //preparar la transaccion
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
		@Override
	public String toString() {
		return "MascotaDAO [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", genero=" + genero + ", raza="
		+ raza + ", codigo=" + codigo + "]";
	}
		public static List<MascotaDAO> listaMascotas() {
			List<MascotaDAO> lista = new ArrayList<MascotaDAO>();
		     MascotaDAO m = new MascotaDAO();
			try {
				String script = "select * from tblmascota";
				pst = conexionBD.prepareStatement(script);
				ResultSet rs = pst.executeQuery();
				 while (rs.next()) {
			     m.setId(rs.getInt("id"));
			     m.setNombre(rs.getString("nombre"));
			     m.setTipo(rs.getString("tipo"));
			     m.setGenero(rs.getString("genero"));
			     m.setRaza(rs.getString("raza"));
			     m.setCodigo(rs.getInt("codigo"));
			     lista.add(m);
			        }
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lista;
		}
		public void create(MascotaDAO dao) {
			String script = "INSERT INTO tblmascota(nombre, tipo, genero, raza, codigo) VALUES (?, ?, ?, ?, ?)";
			try {
				pst = conexionBD.prepareStatement(script);
				pst.setString(1, dao.getNombre());
				pst.setString(2, dao.getTipo());
				pst.setString(3, dao.getGenero());
				pst.setString(4, dao.getRaza());
				pst.setInt(5, dao.getCodigo());
				pst.executeUpdate();
			} catch (Exception errorconexion) {
				errorconexion.printStackTrace();
			}
		}
		public void delete(int idmascota) {
			String script = "delete from tblmascota where id = ?";
			try {
				pst = conexionBD.prepareStatement(script);
				pst.setInt(1, idmascota);
					pst.executeUpdate();
			} catch (Exception errorconexion) {
				errorconexion.printStackTrace();
			}
		}
		public MascotaDAO read(int idmascota) {
			String script = "SELECT * FROM tblmascota where id = ?";
			try {
				pst = conexionBD.prepareStatement(script);
				pst.setInt(1, idmascota);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					user.setNombre(rs.getString("nombre"));
					user.setTipo(rs.getString("tipo"));
					user.setGenero(rs.getString("genero"));
					user.setRaza(rs.getString("raza"));
					user.setCodigo(rs.getInt("codigo"));
				}	
			}
			catch (Exception errorconexion) {
				errorconexion.printStackTrace();
			}
			return user;
	}
		public void update(MascotaDAO dao) {
			String script = "UPDATE tblmascota set nombre = ?, tipo = ?, genero = ?, raza = ?, codigo = ? where idmascota = ?";
			try {
				pst = conexionBD.prepareStatement(script);
				pst.setString(1, dao.getNombre());
				pst.setString(2, dao.getTipo());
				pst.setString(3, dao.getGenero());
				pst.setString(4, dao.getRaza());
				pst.setInt(5, dao.getCodigo());
				pst.setInt(6, dao.getId());
				pst.executeUpdate();
				}
			catch (Exception errorconexion) {
				errorconexion.printStackTrace();
			}
	}
	}