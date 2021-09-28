package es.europea;

import java.util.LinkedList;
import java.util.List;

//Una clase es una estructura de codigo que tiene atributos y metodos y sirve
//como molde para crear objetos

//Un instacia concreta de una clase
public class _01_MainFundamentos {

	/*
	 * El ciclo de vida de un programa en java es desde que arranca y ejecuta
	 * el metodo main, hasta que acaba el metodo main (en un programa monohilo)
	 */
	public static void main(String[] args) {
		// El ciclo de vida de un objeto es desde que nace con la palabra
		//reservada "new" hasta que muere cuando no haya ninguna referencia
		//apuntadole ya que el garbage colleector lo eliminaria
		//System.gc();
		Persona p1 = new Persona();
		System.out.println("He creado un objeto :) :)");
		Persona p2 = p1;
		
		p1.setNombre("Tony Stark");
		p1.setEdad(45);
		p1.setPeso(85);
		
		p2.setEdad(55);
		
		System.out.println(p1.getEdad());
		System.out.println(p2.getEdad());
		
		Persona p3 = p2;
		p3.setNombre("Ironman");
		
		System.out.println(p1.getNombre());
		System.out.println(p2.getNombre());
		
		int i = 5;
		int j = i;
		
		p3 = new Persona();
		p3.setNombre("Steve Rogers");
		System.out.println(p2.getNombre());
		
		p3 = null;
		
		{
			//El ciclo de vida de una referencia o de una variable
			//es desde que se declara hasta el final del bloque donde
			//esta definida
			Persona p4 = new Persona();
			p4.setNombre("Thor");
		}
		//Este fragmento de aqui da error
		//System.out.println(p4.getNombre());
		Persona p4 = null;
		
		Persona p6 = crearPersona("Peter Parker");
		System.out.println(p6.getNombre());
		
		modificarPersona(p6, "Hulk");
		System.out.println(p6.getNombre());
		System.out.println(p6);
		
		int cp = 01234;
		cp = 0xAAFF56;
		cp = 0b101;
		System.out.println(cp);
		
		Persona p7 = new Persona();
		p7.setNombre("Harry Potter");
		Direccion d1 = new Direccion();
		p7.setDireccion(d1);
		p7.getDireccion().setNombreVia("Howards");
		
		System.out.println(p7.getDireccion().getNombreVia());
		d1.setNombreVia("Paris");
		
		System.out.println(p7.getDireccion().getNombreVia());
		
		List<Persona> listaPersona = new LinkedList<Persona>();
		
		listaPersona.add(p7);
		listaPersona.get(0).getDireccion().setNombreVia("Roma");
		System.out.println(p7.getDireccion().getNombreVia());
		System.out.println(d1.getNombreVia());
		
		p7 = new Persona();
		p7.setNombre("Dumbeldor");
		d1 = new Direccion();
		d1.setNombreVia("Tokio");
		p7.setDireccion(d1);
		
		listaPersona.add(p7);
		
		Persona p8 = listaPersona.get(0);
		p8.setNombre("Ernion Güesley");
		
		Persona p9 = new Persona();
		listaPersona.add(p9);
		p9.setNombre("Ron");		
		
		
		System.out.println(listaPersona.get(2).getNombre());
	}
	
	public static Persona crearPersona(String nombre) {
		Persona p5 = new Persona();
		p5.setNombre(nombre);
		return p5;
	}
	
	public static void modificarPersona(Persona p, String nombre) {
		p.setNombre(nombre);
	}

}
