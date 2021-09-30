package es.europea.modelo.entidad;

public class Leon extends Animal{

	@Override
	public void comer(Object o) {
		if(o instanceof Animal) {
			if(o != this) {
				Animal a = (Animal)o;
				System.out.println("Soy el leon " + nombre + " y me voy a comer "
						+ "al animal de tipo " + o.getClass().getSimpleName() +
						" que se llama " + a.getNombre());
			}else {
				System.out.println("No me pienso comer a mi mismo :/ :/");
			}
		}else {
			System.out.println("Solo como animales :)");
		}
	}

}
