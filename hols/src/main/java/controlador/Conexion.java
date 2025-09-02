package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection conectarBD() { // metodo con el objeto connection
		Connection connection = null; // cierre de la conexion por defecto
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_tiendamascotas", "root", "2556229"); // url de conexion definiendo los parametros de conexion para conectar con la BD
			} catch (ClassNotFoundException e) {
				System.out.println("error en el driver: "+e);
			} catch (SQLException noconexion) {
			System.out.println("Error: " + noconexion.getMessage());// muestra del error a la BD
		}
		return connection; // retorna la conexion estando o no abierta en la BD
	}
public static void main(String[] args) {
    Connection conn = Conexion.conectarBD();
    if (conn != null) {
        System.out.println("Conexión exitosa!");
    } else {
        System.out.println("Conexión fallida.");
    }
}
}