package es.uem.ejemplo04;
public class Pedido {
	private int id;
	private long importe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getImporte() {
		return importe;
	}
	public void setImporte(long importe) {
		this.importe = importe;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", importe=" + importe + "]";
	}
	
	
}