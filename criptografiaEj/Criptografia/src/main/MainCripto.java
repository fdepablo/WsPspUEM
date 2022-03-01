package main;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class MainCripto {

	private static Scanner in = new Scanner(System.in);
	
	private static String frase,fraseCifrada;
	private static Cipher cifrador;	
	private static SecretKey paloEspartano;
	private static 	byte[] bytesMensajeCifrado ;

	public static void main(String[] args) {

		int opcion = menuOp();
		selectActionToDo(opcion);
	
	}

	private static int menuOp() {
		System.out.println("--MENU--");
		System.out.println("\n" + "    0.Salir del programa\n" + "    1.Encriptar frase\n"
				+ "    2.Mostrar frase encriptada\n" + "    3.Desencriptar frase\n\n" + "Opcion a ejecutar: ");

		int op = Integer.parseInt(in.nextLine());
		while (op < 0 || op > 3) {
			System.out.println("Debes elegir una opcion entre 0 y 3: ");
			op = Integer.parseInt(in.nextLine());
		}

		return op;
	}

	private static void selectActionToDo(int option) {

		switch (option) {
		case 0:
			System.exit(0);
			break;
		case 1:
			try {
				encriptarFrase();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			mostrarFraseEncriptada();
			break;
		case 3:
			try {
				desencriptarFrase();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}
		int opcion = menuOp();
		selectActionToDo(opcion);

	}

	private static void desencriptarFrase() throws Exception {

		cifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
		byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
		System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));

		
	}

	private static void mostrarFraseEncriptada() {
		System.out.println(" Mensaje Cifrado: " + fraseCifrada);
		
	}

	private static void encriptarFrase() throws Exception {
		System.out.println("Introduzca la frase que quiere encriptar: \n");
		frase = in.nextLine();
		KeyGenerator generador = KeyGenerator.getInstance("DES");
		System.out.println("Paso 1: Se ha obtenido el generador de claves");
		paloEspartano = generador.generateKey();
		System.out.println("Paso 2: Se ha obtenido la clave");
		
		cifrador = Cipher.getInstance("DES");
		System.out.println("Paso 3: Hemos obtenido el cifrador/descifrador");		
		cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);

			// TODO Auto-generated catch block
			
		System.out.println("Paso 4: Hemos configurado el cifrador");
					
		//El cifrador trabaja con bytes, lo convertimos
		byte[] bytesMensajeOriginal = frase.getBytes();
		System.out.println("Paso 5.1: Ciframos el mensaje original");
		//El cifrador devuelve una cadena de bytes
		bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
		String mensajeCifrado = new String(bytesMensajeCifrado);
		fraseCifrada= mensajeCifrado;		
	}
	

}
