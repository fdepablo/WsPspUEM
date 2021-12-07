package es.europea.hilos.entidad;

import java.util.Date;

public class HiloRunable implements Runnable {

	private int valorNumero;

	public int getValorNumero() {
		return valorNumero;
	}

	public void setValorNumero(int valorNumero) {
		this.valorNumero = valorNumero;
	}

	@Override
	public void run() {
		Date date = new Date();
		double pritime = date.getTime();

		int contador = 2;
		boolean primo = true;

		while ((primo) && (contador != getValorNumero())) {
			if (getValorNumero() % contador == 0) {
				primo = false;
			}
			contador++;
		}

		Date date1 = new Date();
		double ultitime = date1.getTime();
		double tiempofinal = ultitime - pritime;

		System.out.println("El " + Thread.currentThread().getName() + " con numero " + getValorNumero() + " : " + primo
				+ " , Ha tardado: " + tiempofinal);
	}

}
