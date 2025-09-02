package controlador;

import javax.swing.JOptionPane;

public class test {
	public static void main(String[] args) {
		Conexion test = new Conexion(); // llamada a la clase Conexion
		if (test.conectarBD() != null) { // llamada del metodo de la clase Conexion
			JOptionPane.showMessageDialog(null, "Conectado a la BD");
		} else {
			JOptionPane.showMessageDialog(null, "No conectado a la BD");
		}
	}

}
