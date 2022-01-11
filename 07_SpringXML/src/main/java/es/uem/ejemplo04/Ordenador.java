package es.uem.ejemplo04;
public class Ordenador {
	private int id;
	private String marca;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "Ordenador [id=" + id + ", marca=" + marca + "]";
	}	
}