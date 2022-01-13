package es.uem.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.uem.modelo.entidad.Persona;

@Configuration
public class Configuracion {

	@Bean
	public Persona personaConfiguracion() {
		Persona p = new Persona();
		p.setNombre("Peter");
		return p;
	}
}
