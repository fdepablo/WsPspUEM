package _04_waitnotify;

public class Consumidor extends Thread{

	public String nombre;
	public Cola cola;
	public int pereza;
	
	public Consumidor(String nombre, Cola cola, int pereza){
		super();
		this.nombre = nombre;
		this.cola = cola;
		this.pereza = pereza;
	}
	
	public void run(){
		for(;;){
			try {
				Thread.sleep(pereza);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String mensaje = cola.getMensaje();
			System.out.println(nombre + " ha consumido el mensaje: " + mensaje);
		}
	}

}
