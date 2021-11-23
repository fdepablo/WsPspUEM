package es.uem.ejemplo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ejemplo01Main {
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext01.xml");
		System.out.println("Contexto Spring arrancado");
		
		Persona p1 = (Persona)context.getBean("persona1");
		p1.setNombre("Steve");
		
		Persona p2 = context.getBean("persona1",Persona.class);
		System.out.println(p2.getNombre());

		p1 = null;
		p2 = null;
		
		Persona p3 = context.getBean("persona1",Persona.class);
		System.out.println(p3.getNombre());
		
		//
		
		Persona p5 = context.getBean("persona3",Persona.class);
		System.out.println(p5);
		imprimirTony();
		
		Persona p6 = context.getBean("persona4",Persona.class);
		System.out.println(p6);
		
		Persona p7 = context.getBean("persona5",Persona.class);
		Persona p8 = context.getBean("persona6",Persona.class);
	}
	
	public static void imprimirTony() {
		Persona tony = context.getBean("persona3", Persona.class);
		System.out.println(tony);
	}

}
