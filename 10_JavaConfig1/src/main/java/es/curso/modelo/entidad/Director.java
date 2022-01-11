package es.curso.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//<bean id="director" class="es.curso.modelo.entidad.Director"></bean>
@Component(value="directorBean")
//<bean id="directorBean" class="es.curso.modelo.entidad.Director"></bean>
@Scope("prototype")
//<bean id="directorBean" class="es.curso.modelo.entidad.Director" scope="prototype">
//</bean>
public class Director{
	private int id;
	private String nombre;
	
	public Director() {
		this.id = 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", nombre=" + nombre + "]";
	}	
}
