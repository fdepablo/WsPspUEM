package es.uem.ejemplo02;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ejemplo2Main {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext02.xml");
		
		Cliente c1 = context.getBean("cliente1", Cliente.class);
		System.out.println(c1);
		
		Direccion d1 = context.getBean("direccion1", Direccion.class);
		System.out.println(d1);
		
		Cliente c2 = context.getBean("cliente2",Cliente.class);
		System.out.println(c2);
		
		Cliente c3 = context.getBean("cliente3", Cliente.class);
		System.out.println(c3);
		
		List<Cliente> listaClientes = context.getBean("listaClientes", List.class);
		listaClientes.add(c3);
		listaClientes.add(c1);
		
		Integer contador = context.getBean("contador",Integer.class);
		System.out.println(contador);
		
		Cliente c4 = context.getBean("cliente4", Cliente.class);
		System.out.println(c4);
	}

}
