package modelo.negocio;

import java.util.List;

import modelo.entidad.Pelicula;
import modelo.persistencia.DaoPelicula;

public class GestorPelicula {
	private DaoPelicula daoPelicula;
	
	/**
	 * Metodo que añade una pelicula. el titulo debe no debe ser vacio
	 * @param p la pelicula que vamos a dar de alta
	 * @return 0 en caso de que la pelicula se haya dado de alta, 1 en caso de
	 * que el titulo este vacio y 2 en caso de que la lista haya adquirido
	 * su capacidad maximo
	 */
	public int addPelicula(Pelicula p) {
		if("".equals(p.getTitulo())) {
			return 1;
		}else {
			boolean correcto = daoPelicula.addPelicula(p);
			if(correcto) {
				return 0;
			}else {
				return 2;
			}
		}
	}
	/**
	 * Metodo que devuelve el listado con todas las peliculas
	 * @return la lista de peliculas
	 */
	public List<Pelicula> obtenerListado(){
		return daoPelicula.getListaPeliculas();
	}

	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	
}
