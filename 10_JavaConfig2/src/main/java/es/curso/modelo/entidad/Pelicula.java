package es.curso.modelo.entidad;

public class Pelicula {
	private int id;
	private String titulo;
	private String genero;

	private Director director;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	
	/*
	 * Esta anotacion funciona en tiempo de compilacion y es una anotacion del tipo "check", es
	 * decir, lo que hace es comprobar en tiempo de ejecución que efectivamente el metodo EXISTE
	 * en la clase padre y que lo vamos a sobrescribir
	 */
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", director=" + director + "]";
	}	
}
