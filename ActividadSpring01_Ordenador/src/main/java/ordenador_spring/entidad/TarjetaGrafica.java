package ordenador_spring.entidad;

public class TarjetaGrafica {

	private String marca;
	private double precio;
	private String modelo;
	private RAM ram;

	public TarjetaGrafica() {
	}

	public TarjetaGrafica(String marca, double precio, String modelo, RAM ram) {
		this.marca = marca;
		this.precio = precio;
		this.modelo = modelo;
		this.ram = ram;
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public RAM getRam() {
		return ram;
	}

	public void setRam(RAM ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "TarjetaGrafica [marca=" + marca + ", precio=" + precio + ", modelo=" + modelo + ", ram=" + ram + "]";
	}

}
