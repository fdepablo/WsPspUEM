package modelo.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pelicula {
	private int id;
	//Podemos dar valores por defecto a los atributos
	@Value("")
	private String titulo;
	private String genero;
	//Mediante la anotacion @Autowired sobre el atributo, le decimos a spring
		//que busque un objeto dentro del contexto que le puede inyectar.
		//Podriamos ponerlo principalmente en constructores o en atibutos
		//Por defecto es byType y si hay varios objetos del mismo
		//tipo haria un autowired byName, si no hubiera ninguno, arrojaría
		//una excepción
	@Autowired
	//Si queremos hacerlo por id utilizaremos la etiqueta @Qualifier, 
		//ademas de @Autowire
	@Qualifier("directorBean")
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
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", director=" + director + "]";
	}	
}
