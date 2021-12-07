package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Socket_Cliente_Calcular {

	// IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {

		MyIcon icon = new MyIcon();
			
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);
		try {
			socketCliente = new Socket();
			socketCliente.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto " + PUERTO);

			entrada = new InputStreamReader(socketCliente.getInputStream());// entrada de datos del servidor (from)
			salida = new PrintStream(socketCliente.getOutputStream());// salida de datos al servidor(to)

			String num1 = JOptionPane.showInputDialog("Introduzca primer numero");
			String num2 = JOptionPane.showInputDialog("Introduzca segundo numero");
			String signo = null;

			String[] options = { "Sumar", "Restar", "Multiplicar", "Dividir", "Salir" };
			int seleccion = JOptionPane.showOptionDialog(null, "Por favor seleccione la operacion a realizar ",
					"Calculadora", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options, options[0]);
			if (seleccion == 0) {
				signo="+";

			}
			if (seleccion == 1) {
				signo="-";
			}

			if (seleccion == 2) {
				signo="*";
			}

			if (seleccion == 3) {
				signo="/";
			}
			if (seleccion == 4) {
				System.exit(0);
			}

	
			String operandos = num1 +","+ num2 + ","+signo;
			salida.println(operandos);

			
			BufferedReader bf = new BufferedReader(entrada);
			
			String resultado = bf.readLine();

			JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
			String[] arrayResultado = resultado.split(":");

//			System.out.println("CLIENTE: El resultado de la suma es: " + arrayResultado[1]);// 7
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		} finally {// ES MUYYY IMPORTANTE QUE EN LOS SOCKETS SIEMPRE SE CIERREN LAS CONEXIONES
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
