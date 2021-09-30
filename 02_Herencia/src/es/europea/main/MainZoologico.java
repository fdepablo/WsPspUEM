package es.europea.main;

import java.util.ArrayList;
import java.util.List;

import es.europea.modelo.entidad.Animal;
import es.europea.modelo.entidad.Leon;
import es.europea.modelo.entidad.Persona;
import es.europea.modelo.entidad.Pez;
import es.europea.modelo.entidad.Placton;
import es.europea.modelo.entidad.Tiburon;
import es.europea.modelo.entidad.Trucha;

public class MainZoologico {
	public static void main(String[] args) {
		Trucha t = new Trucha();
		t.setNombre("Juanita");
		t.setEdad(2);
		t.setPeso(2);
		t.setNumeroAletas(2);
		
		Tiburon tiburon = new Tiburon();
		tiburon.setNombre("Machote");
		tiburon.setPeso(400);
		tiburon.setEdad(7);
		tiburon.setNumeroAletas(6);
		
		Leon leon = new Leon();
		leon.setNombre("Leoncio");
		leon.setEdad(6);
		leon.setPeso(350);
		
		List<Animal> listaAnimales = new ArrayList<Animal>();
		
		listaAnimales.add(t);
		listaAnimales.add(tiburon);
		listaAnimales.add(leon);
		
		Placton placton = new Placton();
		placton.setTipo("Acuifero");
		
		for(Animal a : listaAnimales) {
			a.comer(placton);
		}
		
		System.out.println("*****************************************");
		
		Persona persona = new Persona();
		persona.setNombre("Steve Mcqueen");
		
		for(Animal a : listaAnimales) {
			a.comer(persona);
		}
		
		System.out.println("*****************************************");
		
		Leon l = leon;
				
		for(Animal a : listaAnimales) {
			a.comer(l);
		}
	}
}
