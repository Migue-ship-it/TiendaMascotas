package modelo;
public class Mascota {
		private int id;
		private String nombre;
		private String tipo;
		private String genero;
		private String raza;
		private int codigo;
		// Constructor sin id (para crear un formulario)
		public Mascota(String nombre, String tipo, String genero, String raza, int codigo) {
			this.nombre = nombre;
			this.tipo = tipo;
			this.genero = genero;
			this.raza = raza;
			this.codigo = codigo;
		}
		// con id (para leer y actualizar un formulario segun su id
		public Mascota(int id, String nombre, String tipo, String genero, String raza, int codigo) {
			this.id = id;
			this.nombre = nombre;
			this.tipo = tipo;
			this.genero = genero;
			this.raza = raza;
			this.codigo = codigo;
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
	}