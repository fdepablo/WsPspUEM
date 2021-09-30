package es.europea.modelo.entidad;

public class Tiburon extends Pez{

	@Override
	public void comer(Object o) {
		if(o instanceof Persona) {
			System.out.println("AHHHHH! Que viene el tiburon!!!");
			System.out.println("Soy un tiburon y me voy a zampar a la persona "
					+ ((Persona)o).getNombre());
		}else {
			System.out.println("Los tiburones comemos personas :( :( :( \uD83D");
		}
	}

	
}
