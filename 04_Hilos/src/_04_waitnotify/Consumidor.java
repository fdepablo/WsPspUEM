package _04_waitnotify;

public class Consumidor extends Thread{

	public String nombre;
	public Cola cola;
	
	public Consumidor(String nombre, Cola cola){
		super();
		this.nombre = nombre;
		this.cola = cola;
	}
	
	public void run(){
		for(int i = 1;i <= 10;i++){
			String mensaje = cola.getMensaje();
			System.out.println(nombre + " ha consumido el mensaje: " + mensaje);
		}
	}

}
