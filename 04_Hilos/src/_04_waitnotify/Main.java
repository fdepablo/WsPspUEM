package _04_waitnotify;

public class Main {
	public static void main(String[] args) {
		Cola cola = new Cola();
		
		Productor p1 = new Productor("Producto 1",cola,5000);
		Productor p2 = new Productor("Producto 2",cola,3000);
		Productor p3 = new Productor("Producto 3",cola,2000);
		Productor p4 = new Productor("Producto 4",cola,100);
		
		Consumidor c1 = new Consumidor("Consumidor 1",cola,500);
		Consumidor c2 = new Consumidor("Consumidor 2",cola,800);
		Consumidor c3 = new Consumidor("Consumidor 3",cola,250);
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		c1.start();
		c2.start();
		c3.start();
	}
}
