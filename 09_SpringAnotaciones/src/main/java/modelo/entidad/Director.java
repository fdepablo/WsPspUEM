package modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "directorBean")
//<bean id="directorBean" class="modelo.entidad.Director" scope="singleton"/>
@Scope("prototype")
//<bean id="directorBean" class="modelo.entidad.Director" scope="prototype"/>
public class Director {
	private int id;
	private String nombre;
	
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
