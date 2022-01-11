package ordenador_spring.entidad;

public class Periferico {

	private double precio;
	private String tipo;
	private String marca;

	public Periferico() {
	}

	public Periferico(double precio, String tipo, String marca) {
		this.precio = precio;
		this.tipo = tipo;
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Periferico [precio=" + precio + ", tipo=" + tipo + ", marca=" + marca + "]";
	}

}
