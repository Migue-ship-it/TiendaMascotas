package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import controlador.Conexion;
public class MascotaDAO {
    private static Connection conexionBD = Conexion.conectarBD();
    private static PreparedStatement pst = null;
    public List<Mascota> listaMascotas() {
        List<Mascota> lista = new ArrayList<>();
        try {
            String script = "SELECT * FROM tblmascota";
            pst = conexionBD.prepareStatement(script);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mascota m = new Mascota(rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo"), rs.getString("genero"), 
                rs.getString("raza"), rs.getInt("codigo"));
                lista.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void create(Mascota mascota) {
        String script = "INSERT INTO tblmascota(nombre, tipo, genero, raza, codigo) VALUES (?, ?, ?, ?, ?)";
        try {
            pst = conexionBD.prepareStatement(script);
            pst.setString(1, mascota.getNombre());
            pst.setString(2, mascota.getTipo());
            pst.setString(3, mascota.getGenero());
            pst.setString(4, mascota.getRaza());
            pst.setInt(5, mascota.getCodigo());
            pst.executeUpdate();
        } catch (Exception errorconexion) {
            errorconexion.printStackTrace();
        }
    }
    public void delete(int idmascota) {
        String script = "DELETE FROM tblmascota WHERE id = ?";
        try {
            pst = conexionBD.prepareStatement(script);
            pst.setInt(1, idmascota);
            pst.executeUpdate();
        } catch (Exception errorconexion) {
            errorconexion.printStackTrace();
        }
    }
    public Mascota read(int idmascota) {
        Mascota mascota = null;
        String script = "SELECT * FROM tblmascota WHERE id = ?";
        try {
            pst = conexionBD.prepareStatement(script);
            pst.setInt(1, idmascota);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                mascota = new Mascota(rs.getInt("id"), rs.getString("nombre"), rs.getString("tipo"), rs.getString("genero"), rs.getString("raza"), rs.getInt("codigo"));
            }
        } catch (Exception errorconexion) {
            errorconexion.printStackTrace();
        }
        return mascota;
    }
    public void update(Mascota mascota) {
        String script = "UPDATE tblmascota SET nombre=?, tipo=?, genero=?, raza=?, codigo=? WHERE id=?";
        try {
            pst = conexionBD.prepareStatement(script);
            pst.setString(1, mascota.getNombre());
            pst.setString(2, mascota.getTipo());
            pst.setString(3, mascota.getGenero());
            pst.setString(4, mascota.getRaza());
            pst.setInt(5, mascota.getCodigo());
            pst.setInt(6, mascota.getId());
            pst.executeUpdate();
        } catch (Exception errorconexion) {
            errorconexion.printStackTrace();
        }
    }
}