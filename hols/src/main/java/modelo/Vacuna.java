package modelo;
public class Vacuna {
	private int id;
	private String nombre;
	private int codigo;
	private int dosis;
	private String enfermedad;
	public Vacuna(int id, String nombre, int codigo, int dosis, String enfermedad) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.dosis = dosis;
		this.enfermedad = enfermedad;
	}
	public Vacuna(String nombre, int codigo, int dosis, String enfermedad) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.dosis = dosis;
		this.enfermedad = enfermedad;
	}
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
}