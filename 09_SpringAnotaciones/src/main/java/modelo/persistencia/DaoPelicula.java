package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import modelo.entidad.Pelicula;

@Repository
public class DaoPelicula {
	@Autowired
	@Qualifier("listaPeliculas")
	private List<Pelicula> listaPeliculas;
	@Value("3")
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
}
