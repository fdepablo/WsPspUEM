package es.europea.hilos.main;

import java.util.Scanner;

import es.europea.hilos.entidad.HiloRunable;

public class Main {
	public static void main(String[] args) {

		Scanner leer = new Scanner(System.in);

		HiloRunable hilo1 = new HiloRunable();
		HiloRunable hilo2 = new HiloRunable();
		HiloRunable hilo3 = new HiloRunable();
		
		Thread t1 = new Thread(hilo1);
		Thread t2 = new Thread(hilo2);
		Thread t3 = new Thread(hilo3);

		System.out.println("Escriba el primer número");
		int num1 = leer.nextInt();
		System.out.println("Escriba el segundo número");
		int num2 = leer.nextInt();
		System.out.println("Escriba el tercer número");
		int num3 = leer.nextInt();
		
		hilo1.setValorNumero(num1);
		hilo2.setValorNumero(num2);
		hilo3.setValorNumero(num3);
		
		t1.setName("hilo1");
		t2.setName("hilo2");
		t3.setName("hilo3");
		
		//Arrancamos los hilos
		t1.start();
		t2.start();
		t3.start();
	}

}
