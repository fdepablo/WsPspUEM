package es.europea;

//Las clases estan compuestas por atibutos y metodos
//El valor de los atributos en un instante de tiempo dado se le llama
//"estado" de un objeto
//Los metodos representan la funcionalidad de lo que puede hacer el objeto

//Este tipo de objeto va a representar una entidad en nuestra aplicacion
//Normalmente las entidades en java siguien una convencion de JavaBean
//esta convencion nos dice que los atributos tienen que ser private
//y metodos modificadores y accesores public
public class Persona {
	//Los atributos tienen 4 tipos de visibilidad en Java
	//En orden de restricción (de mas a menos):
	//1. private -> El atributo solo es visible en la clase
	//2. (Default) -> El atributo es visible en la clase y en el paquete
	//3. protected -> El atributo es visible en la case, en el paquete y en 
	//				las clases heredadas
	//4. public -> El atributo es visible en el proyecto
	
	private String nombre;
	private int edad;
	private double peso;
	private Direccion direccion;
	
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
}
