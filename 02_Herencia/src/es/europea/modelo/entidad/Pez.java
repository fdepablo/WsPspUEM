package es.europea.modelo.entidad;

public abstract class Pez extends Animal{

	private int numeroAletas;
	
	@Override
	public void comer(Object o) {
		if(o instanceof Placton) {
			Placton p = (Placton)o;
			System.out.println("Me llamo " + nombre + " y voy a comer un "
					+ "delicios placton del tipo " + p.getTipo());
		}else {
			System.out.println("PUAJJJJJJJ! No me gusta eso :( " + o.getClass().getSimpleName());
		}
	}

	public int getNumeroAletas() {
		return numeroAletas;
	}

	public void setNumeroAletas(int numeroAletas) {
		this.numeroAletas = numeroAletas;
	}
	
	

}
