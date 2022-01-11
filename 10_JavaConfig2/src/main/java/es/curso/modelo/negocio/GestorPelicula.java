package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.persistencia.DaoPelicula;

public class GestorPelicula {
	
	private DaoPelicula daoPelicula;
	
	/**
	 * Metodo que insertara una pelicula mediante el daoPelicula. La pelicula
	 * no puede tener el titulo vacio para poder ser insertada
	 * @param p la pelicula a insertar
	 * @return 0 en caso de que hayamos podido insertar la pelicula, 1 en caso
	 * de que el titulo este vacio y 2 en caso de la lista no admita más peliculas
	 */
	public int insertar(Pelicula p) {
		if(p.getTitulo().equals("")) {
			return 1;
		}else {
			boolean insertada = daoPelicula.insertar(p);
			if(insertada) {
				return 0;
			}else {
				return 2;
			}
		}
	}
	
	public List<Pelicula> listar(){
		return daoPelicula.getListaPeliculas();
	}

	public DaoPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DaoPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}	
}
