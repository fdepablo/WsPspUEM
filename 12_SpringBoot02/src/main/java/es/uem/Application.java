package es.uem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.uem.modelo.entidad.Persona;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private Persona persona;
	
	@Autowired
	private ApplicationContext context;
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

	//Este metodo sera llamado automaticamente por spring boot
	//CON LA VENTAJA DE QUE ES DINAMICO
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(persona);
		
		Persona p1 = context.getBean("persona",Persona.class);
		System.out.println(p1);
	}

}
