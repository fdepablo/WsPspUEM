package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

	public static final int PUERTO = 2017;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("      Servidor calculadora      ");
		System.out.println("--------------------------------");

		InputStreamReader entrada = null;
		PrintStream salida = null;
		Socket socketAlCliente = null;
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		try (ServerSocket serverSocket = new ServerSocket()) {

			serverSocket.bind(direccion);
			int peticion = 0;
			while (true) {

				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String stringRecibido = bf.readLine();
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido); 
				String[] operadores = stringRecibido.split(",");
				
				int iNumero1 = Integer.parseInt(operadores[0]);
				int iNumero2 = Integer.parseInt(operadores[1]);
				String op = operadores[2];

				int resultado = (int) operacion(iNumero1,iNumero2,op);
				System.out.println("SERVIDOR: El calculo de los numeros es: " + resultado);

				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultado);

				socketAlCliente.close();
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}// FIN DEL PROGRAMA

	private static double operacion(int x,int y,String op) {
		double resultado=0;
		
		switch (op) {
		case "+": {
			resultado=x+y;
			break;
		}
		case "-": {
			resultado=x-y;

					break;
				}
		case "*": {
			resultado=x*y;

			break;
		}
		case "/": {
			resultado=x/y;

			break;
		}}
		
		
		
	
	
	return resultado;
	
	}}