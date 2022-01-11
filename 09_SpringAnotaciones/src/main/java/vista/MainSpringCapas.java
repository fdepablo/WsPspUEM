package vista;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidad.Director;
import modelo.entidad.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainSpringCapas {

	private GestorPelicula gestorPelicula;
	private Scanner sc;
	private Pelicula p;
	private Director d;
	private static MainSpringCapas msc;
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		/*
		List<Pelicula> listaPelicula = new ArrayList<Pelicula>();
		Integer maxNumeroPeliculas = 3;
		
		DaoPelicula daoPelicula = new DaoPelicula();
		daoPelicula.setListaPeliculas(listaPelicula);
		daoPelicula.setMaxNumeroPeliculas(maxNumeroPeliculas);
		
		msc = new MainSpringCapas();
		
		msc.gestorPelicula = new GestorPelicula();
		msc.gestorPelicula.setDaoPelicula(daoPelicula);
		
		msc.sc = new Scanner(System.in);
		*/
		
		msc = new MainSpringCapas();
		msc.sc = new Scanner(System.in);
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		msc.gestorPelicula = context.getBean("gestorPelicula", GestorPelicula.class);
		msc.arrancar();
	}
	
	public void arrancar() {
		
		boolean continuar = true;
		
		do {
			System.out.println("Introduzca los valores de la pelicula (Titulo, genero, director)");
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String director = sc.nextLine();
			
			p = context.getBean("pelicula", Pelicula.class);
			//d = new Director();
			
			p.setTitulo(titulo);
			p.setGenero(genero);
			//d.setNombre(director);
			p.getDirector().setNombre(director);
			//p.setDirector(d);
			
			int resultado = gestorPelicula.addPelicula(p);
			switch (resultado) {
			case 0:
				System.out.println("Pelicula introducida");
				break;
			case 1:
				System.out.println("titulo vacio");
				break;
				
			case 2:
				System.out.println("La lista esta llena");
				break;
			}
			
			List<Pelicula> listaPeliculas = gestorPelicula.obtenerListado();
			listaPeliculas.forEach(v -> System.out.println(v));
			System.out.println("Desea continuar? s/n");
			String seguir = sc.nextLine();
			if("n".equals(seguir)) {
				continuar = false;
			}
		}while(continuar);
		
		System.out.println("Hasta luego lucas");
	}

}
