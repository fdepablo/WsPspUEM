package es.curso.cfg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.curso.modelo.entidad.Director;
import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;
import es.curso.modelo.persistencia.DaoPelicula;

//En este ejemplo de aqui vamos a dar todos los objetos de alta dentro de la
//propia clase de configuracion. 

//Hemos quitado todas las anotaciones de las clases.

//Hemos creado los setters y getters en las otras clases para poder acceder a ellos
@Configuration
public class ConfiguracionSpring {
	
	//Cuando arrancamos una aplicacion mediante una clase anotada con @Configuration,
	//podemos dar de alta todos los bean que queramos dentro de dicha clase.
	
	//La manera básica de proceder sería mediante metodos anotados con @Bean
	//Spring recorrera todos los metodos de la clase, y aquellos metodos con 
	//dicha anotacion, lo ejecutará y el objeto devuelto lo dara de alta en el 
	//contexto. El id que le asignara será el nombre del método.
	
	//Por supuesto podemos seguir mezclando el dar de alta objetos mediante 
	//anotaciones con dar de alta objetos dentro de la clase de configuracion
	//Incluso podriamos dar de alta objetos tambien en el XML.
	
	/*
	 * Vamos a dar de alta un objeto de tipo director y de scope prototipado
	 * Para establecer el scope usaremos la etiqueta @Scope
	 * Podemos cambiar el id por defecto que le da spring al bean con el 
	 * atributo value de la anotacion @Bean
	 * 
	 * <bean id="director" class="Director" scope="prototype"/>
	 */
	@Bean
	@Scope("prototype")
	public Director director() {
		Director director = new Director();
		director.setId(1);
		return director;
	}
	
	@Bean(value="directorBean")
	@Scope("prototype")
	//<bean id="directorBean" class="Director" scope="prototype"/>
	public Director otroDirector() {
		Director director = new Director();
		director.setId(2);
		return director;
	}
	
	//En nuestro esquema la pelicula tiene una dependencia con director
	//Por lo que queremos que la pelicula ya venga inyectada con el objeto
	//director correspondiente.
	
	//Podemos hacer dos cosas:
	//1. Dentro del mismo metodo, crear el objeto director e inyectarselo
	//(esto seria equivalente a un "innerBean"
	//2. Diciendole al contexto de Spring que nos pase un objeto Director
	//que este dado de alta en el contexto. Para ello simplemente tenemos
	//que pasarle un parametro de entrada al metodo del tipo de dato que 
	//queramos, es decir, hara un Autowired, que por defecto es byType y 
	//si hay varios objetos del mismo tipo haria un autowired byName.
	//si no hubiera ninguno, arrojaría una excepción
	
	////Si queremos hacerlo por id utilizaremos la etiqueta @Qualifier, 
	
	//<bean id="pelicula" class="Pelicula" scope="prototype">
	//	<propertie name="director" ref="directorBean"/>
	//</bean>
	@Bean
	@Scope("prototype")
	public Pelicula pelicula(@Qualifier("directorBean") Director director) {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("");
		pelicula.setDirector(director);
		//pelicula.setDirector(new Director);//inner bean
		return pelicula;
	}
	

	//<bean id="daoPelicula" class="DaoPelicula" scope="singleton">
	//	<propertie name="listaPelicula">
	//		<bean class="ArrayList">
	//		</bean>
	//  </propertie>
	//  <propertie name="numeroMaximoPeliculas" value="3"/>
	//</bean>
	@Bean
	public DaoPelicula daoPelicula() {
		DaoPelicula daoPelicula = new DaoPelicula();
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		daoPelicula.setListaPeliculas(listaPelicula);
		daoPelicula.setNumeroMaximoPelicula(3);
		return daoPelicula;
	}
	
	//Aqui inyectamos el daoPelicula que hemos dado de alta en el metodo
	//de arriba
	@Bean
	public GestorPelicula gestorPelicula(DaoPelicula daoPelicula) {
		GestorPelicula gestorPelicula = new GestorPelicula();
		gestorPelicula.setDaoPelicula(daoPelicula);
		return gestorPelicula;
	}
}
