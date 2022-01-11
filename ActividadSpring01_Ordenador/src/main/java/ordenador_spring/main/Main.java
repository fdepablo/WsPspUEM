package ordenador_spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ordenador_spring.entidad.Ordenador;

public class Main {

	public static ApplicationContext context;

	public static void main(String[] args) {

		context = new ClassPathXmlApplicationContext("applicatonContext01.xml");
		System.out.println("Contexto Spring arrancado WEY!");
//		System.out.println();
//
//		Procesador cpu = context.getBean("procesador1", Procesador.class);
//		Periferico peri = context.getBean("periferico1", Periferico.class);
//		RAM ram1 = context.getBean("ram1", RAM.class);
//		RAM ram2 = context.getBean("ram2", RAM.class);
//		List<TarjetaGrafica> listaTarjetas = context.getBean("listaTarjetas", List.class);
//		for (TarjetaGrafica o : listaTarjetas) {
//			System.out.println(o);
//		}
//		List<Periferico> listaPerifericos = context.getBean("listaPerifericos", List.class);
//		for (Periferico p : listaPerifericos) {
//			System.out.println(p);
//		}

		Ordenador pc = context.getBean("ordenador1", Ordenador.class);
		System.out.println(pc);
	}

}
