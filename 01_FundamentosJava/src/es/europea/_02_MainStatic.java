package es.europea;

public class _02_MainStatic {
	public static void main(String[] args) {
		Empleado e1 = new Empleado();
		e1.setNombre("Oliver Atom");
		Empleado.numeroEmpleados = 1;
		
		Empleado e2 = new Empleado();
		e2.setNombre("Benji Price");
		Empleado.numeroEmpleados = 2;
		
		_02_MainStatic main = new _02_MainStatic();
		main.imprimir();
		
		Empleado.listaEmpleado = null;
		
		Empleado e3 = e1.devolverEsteEmpleado();
		//Equivalente a lo siguiente
		e1.devolverEsteEmpleado();
		e3 = e1;
		
		e2.setEdad(25);
		e1.setEdad(20);
		
		Empleado eMayor = e2.obtenerEmpleadoMayor(e1);
		System.out.println(eMayor.getNombre());
	}
	
	public void imprimir() {
		System.out.println("Ola k ase!");
	}
}
