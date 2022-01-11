package es.uem.ejemplo04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext04.xml");
		
		Persona p1 = context.getBean("persona", Persona.class);
		
		System.out.println(p1);
		
		Cliente c1 = context.getBean("cliente", Cliente.class);
		
		System.out.println(c1);
	}

}
