package modelo;
public class Producto {
		private int id;
		private String codigobarras;
		private String nombre;
		private String marca;
		private String precio;
		public Producto(int id, String codigobarras, String nombre, String marca, String precio) {
			this.id = id;
			this.codigobarras = codigobarras;
			this.nombre = nombre;
			this.marca = marca;
			this.precio = precio;
		}
		public Producto(String codigobarras, String nombre, String marca, String precio) {
			this.codigobarras = codigobarras;
			this.nombre = nombre;
			this.marca = marca;
			this.precio = precio;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCodigobarras() {
			return codigobarras;
		}
		public void setCodigobarras(String codigobarras) {
			this.codigobarras = codigobarras;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getMarca() {
			return marca;
		}
		public void setMarca(String marca) {
			this.marca = marca;
		}
		public String getPrecio() {
			return precio;
		}
		public void setPrecio(String precio) {
			this.precio = precio;
		}
		@Override
		public String toString() {
			return "ProductoDAO [id=" + id + ", codigobarras=" + codigobarras + ", nombre=" + nombre + ", marca=" + marca
					+ ", precio=" + precio + "]";
		}
}