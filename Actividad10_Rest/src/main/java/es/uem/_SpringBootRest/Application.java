package es.uem._SpringBootRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Servicio Rest -> Cargando el contexto de Spring...");

		// Mediante el metodo "run" arrancaremos el contexto de Spring
		// y daremos de alta todos los objetos que hayamos configurado
		// en nuestra aplicacion así como sus dependecias con otros
		// objetos.
		SpringApplication.run(Application.class, args);
		
		System.out.println("Servicio Rest -> Contexto de Spring cargado!");
	}

}
