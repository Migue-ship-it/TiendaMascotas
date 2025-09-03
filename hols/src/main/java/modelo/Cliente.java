package modelo;

public class Cliente {
	private int id;
	private int cedula;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String correo;
	// Constructor sin id (para crear un formulario)
	public Cliente(int cedula, String nombres, String apellidos, String direccion, String telefono, String correo) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	// con id (para leer y actualizar un formulario segun su id
	public Cliente(int id, int cedula, String nombres, String apellidos, String direccion, String telefono,
			String correo) {
		this.id = id;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
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
}
