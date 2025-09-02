package controlador;

import javax.swing.JOptionPane;

public class test {
	public static void main(String[] args) {
		if (Conexion.conectarBD() != null) { // llamada del metodo de la clase Conexion
			JOptionPane.showMessageDialog(null, "Conectado a la BD");
		} else {
			JOptionPane.showMessageDialog(null, "No conectado a la BD");
		}
	}

}
