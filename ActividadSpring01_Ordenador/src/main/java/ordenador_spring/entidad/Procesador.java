package ordenador_spring.entidad;

public class Procesador {

	private int numeroNucleos;
	private double hz;
	private int hilos;
	private double precio;
	private String marca;

	public Procesador() {
	}

	public Procesador(int numeroNucleos, double hz, int hilos, double precio, String marca) {
		this.numeroNucleos = numeroNucleos;
		this.hz = hz;
		this.hilos = hilos;
		this.precio = precio;
		this.marca = marca;
	}

	public int getNumeroNucleos() {
		return numeroNucleos;
	}

	public void setNumeroNucleos(int numeroNucleos) {
		this.numeroNucleos = numeroNucleos;
	}

	public double getHz() {
		return hz;
	}

	public void setHz(double hz) {
		this.hz = hz;
	}

	public int getHilos() {
		return hilos;
	}

	public void setHilos(int hilos) {
		this.hilos = hilos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Procesador [numeroNucleos=" + numeroNucleos + ", hz=" + hz + ", hilos=" + hilos + ", precio=" + precio
				+ ", marca=" + marca + "]";
	}

}
