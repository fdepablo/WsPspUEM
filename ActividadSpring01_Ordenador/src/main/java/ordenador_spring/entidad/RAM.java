package ordenador_spring.entidad;

public class RAM {

	private String marca;
	private double precio;

	public RAM() {
	}

	public RAM(String marca, double precio) {
		this.marca = marca;
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "RAM [marca=" + marca + ", precio=" + precio + "]";
	}

}
