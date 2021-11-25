package es.uem.ejemplo03;

public class Videojuego {
	private String nombre;
	private int nota;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", nota=" + nota + "]";
	}
	
}
