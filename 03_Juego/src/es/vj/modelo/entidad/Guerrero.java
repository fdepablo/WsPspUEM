package es.vj.modelo.entidad;

public class Guerrero {
	private String nombre;
	private Arma arma;
	
	public Guerrero() {
	}
	
	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public void atacar() {
		System.out.println("ARGGGGGG! La furia de " + nombre);
		arma.usar();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
}
