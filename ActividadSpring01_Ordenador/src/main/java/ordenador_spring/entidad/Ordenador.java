package ordenador_spring.entidad;

import java.util.ArrayList;
import java.util.List;

public class Ordenador {

	private String marca;
	private double precio;
	private Procesador procesador;
	List<TarjetaGrafica> ListaTarjetaGraficas;
	List<RAM> listaRam;
	List<Periferico> listaPerifericos;

	public Ordenador() {
	}

	public Ordenador(String marca, double precio, Procesador procesador) {
		this.marca = marca;
		this.precio = precio;
		this.procesador = procesador;
		ListaTarjetaGraficas = new ArrayList<TarjetaGrafica>();
		listaRam = new ArrayList<RAM>();
		listaPerifericos = new ArrayList<Periferico>();
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

	public Procesador getProcesador() {
		return procesador;
	}

	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}

	public List<TarjetaGrafica> getListaTarjetaGraficas() {
		return ListaTarjetaGraficas;
	}

	public void setListaTarjetaGraficas(List<TarjetaGrafica> listaTarjetaGraficas) {
		ListaTarjetaGraficas = listaTarjetaGraficas;
	}

	public List<RAM> getListaRam() {
		return listaRam;
	}

	public void setListaRam(List<RAM> listaRam) {
		this.listaRam = listaRam;
	}

	public List<Periferico> getListaPerifericos() {
		return listaPerifericos;
	}

	public void setListaPerifericos(List<Periferico> listaPerifericos) {
		this.listaPerifericos = listaPerifericos;
	}

	@Override
	public String toString() {
		return "Ordenador [marca=" + marca + ", precio=" + precio + ", \nprocesador=" + procesador
				+ ", \nListaTarjetaGraficas=" + ListaTarjetaGraficas + ", \nlistaRam=" + listaRam
				+ ", \nlistaPerifericos=" + listaPerifericos + "]";
	}

	public int calcularPrecio() {
		int precioTotal;
		int precioProcesador = (int) procesador.getPrecio();
		int precioTarjetas = 0;
		int precioRamTarjetas = 0;
		int precioRAM = 0;
		int precioPerifericos = 0;

		for (TarjetaGrafica tarjetaGrafica : ListaTarjetaGraficas) {
			precioTarjetas += tarjetaGrafica.getPrecio();
		}

		for (TarjetaGrafica tarjetaGrafica : ListaTarjetaGraficas) {
			precioRamTarjetas += tarjetaGrafica.getRam().getPrecio();
		}

		for (RAM ram : listaRam) {
			precioRAM += ram.getPrecio();
		}

		for (Periferico periferico : listaPerifericos) {
			precioPerifericos += periferico.getPrecio();
		}

		precioTotal = precioProcesador + precioTarjetas + precioRAM + precioPerifericos + precioRamTarjetas;

		return precioTotal;
	}

	public void addTarjeta(TarjetaGrafica tarjeta) {
		ListaTarjetaGraficas.add(tarjeta);
	}

	public void addPeriferico(Periferico periferico) {
		listaPerifericos.add(periferico);
	}

	public void addRAM(RAM miRam) {
		listaRam.add(miRam);
	}

}