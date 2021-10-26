package _04_waitnotify;

public class Productor extends Thread{

	public String nombre;
	public Cola cola;
	public int pereza;
	
	public Productor(String nombre, Cola cola, int pereza){
		super();
		this.nombre = nombre;
		this.cola = cola;
		this.pereza = pereza;
	}
	
	public void run(){
		int contador = 1;
		for(;;){
			try {
				Thread.sleep(pereza);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String mensaje = nombre + " - " + contador++;//Productor 1 - 1
			cola.addMensaje(mensaje);
		}
	}

}
