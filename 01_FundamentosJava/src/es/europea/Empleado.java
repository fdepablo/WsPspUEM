package es.europea;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private int id;
	private String nombre;
	private int edad;
	//El ciclo de vida de los atributos NO ESTATICOS esta ligado al propio objeto
	//El ciclo de vida de los atributos ESTATICOS esta ligado al ciclo de vida
	//de la clase, que es todo el programa. Podeis entenderlo como atributos
	//que su valor es compartido por todos los objetos.
	//Las variables o metodos no estaticos se accede a traves del objeto
	//Las variables o metodos estaticos se accede a traves de la clase
	
	//Dentro de un metodo estatico solo puedo acceder a metodos estaticos
	//Dentro de un metodo dinamico (o no estico) puedo acceder tanto a metodos
	//estaticos como dinamicos
	public static int numeroEmpleados;
	public static List<Empleado> listaEmpleado;
	
	//inicializamos la lista de empleados en un bloque estatico, que se ejecuta
	//antes de inicializar el main
	
	static {
		listaEmpleado = new ArrayList<Empleado>();
		Empleado e1 = new Empleado();
		e1.setNombre("Asterix");
		
		Empleado e2 = new Empleado();
		e2.setNombre("Obelix");
		
		listaEmpleado.add(e1);
		listaEmpleado.add(e2);
		//El this esta asociado al objeto y por ende no se puede poner
		//dentro de un bloque estico
		//this.id = 0;
	}
	
	public Empleado() {
		numeroEmpleados++;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
		
	//La palabra reservada "this" es una referencia al propio objeto
	public Empleado devolverEsteEmpleado() {
		System.out.println("hola soy " + nombre + " y te devuelvo a mi mismo :) :) :)");
		return this;
	}

	public Empleado obtenerEmpleadoMayor(Empleado e) {
		if(this.edad > e.edad) {
			return this;
		}else {
			return e;
		}
	}
	
}
