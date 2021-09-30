package es.vj.main;

import es.vj.modelo.entidad.Arco;
import es.vj.modelo.entidad.Arma;
import es.vj.modelo.entidad.Espada;
import es.vj.modelo.entidad.Guerrero;

public class Main {
	public static void main(String[] args) {
		Guerrero g1 = new Guerrero();
		g1.setNombre("Conan");
		Arma a1 = new Espada();
		g1.setArma(a1);
		g1.atacar();
		
		Guerrero g2 = new Guerrero();
		g2.setNombre("Legolas");
		Arma a2 = new Arco();
		g2.setArma(a2);
		g2.atacar();
	}
}
