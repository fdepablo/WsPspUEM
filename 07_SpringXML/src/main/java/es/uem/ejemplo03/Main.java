package es.uem.ejemplo03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext03.xml");
		
		List<Videojuego> listaVideojuegos = context.getBean("listaVideojuegos",List.class);
		
		listaVideojuegos.forEach(v -> System.out.println(v));
		System.out.println("******************************");
		listaVideojuegos.get(3).setNombre("Tomb Raider");
		listaVideojuegos.get(0).setNombre("World of Warcraft");
		listaVideojuegos.forEach(v -> System.out.println(v));
	}

}
