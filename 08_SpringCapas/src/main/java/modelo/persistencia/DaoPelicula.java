package modelo.persistencia;

import java.util.List;

import modelo.entidad.Pelicula;

public class DaoPelicula {
	private List<Pelicula> listaPeliculas;
	private Integer maxNumeroPeliculas;
	
	/**
	 * Metodo que añade una pelicula a una lista de peliculas en memoria
	 * siempre y cuando no hayamos llegado el numero maximo de peliculas
	 * @param p Pelicula que vamos a dar de alta
	 * @return <b>true</b> en caso de que hemos podido añadir la pelcula, <b>false</b>
	 * en caso de que la lista haya llegado a su numero maximo
	 */
	public boolean addPelicula(Pelicula p) {
		if(listaPeliculas.size() < maxNumeroPeliculas) {
			listaPeliculas.add(p);
			return true;
		}
		return false;
	}

	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public Integer getMaxNumeroPeliculas() {
		return maxNumeroPeliculas;
	}

	public void setMaxNumeroPeliculas(Integer maxNumeroPeliculas) {
		this.maxNumeroPeliculas = maxNumeroPeliculas;
	}	
}
