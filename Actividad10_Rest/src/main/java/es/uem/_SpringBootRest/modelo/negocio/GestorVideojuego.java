package es.uem._SpringBootRest.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uem._SpringBootRest.modelo.entidad.Videojuego;
import es.uem._SpringBootRest.modelo.persistencia.DaoVideojuego;

@Service
public class GestorVideojuego {

	@Autowired
	private DaoVideojuego daoVideojuego;

	public int alta(Videojuego p) {

		if (comprobarNombre(p)) {
			return 3;
		} else if (comprobarNombreRepetido(p)) {
			return 2;//si es true es que no esta repetido
		}else {
			boolean respuestaAlta = daoVideojuego.alta(p);
			if (respuestaAlta) {
				return 4;
			} else {
				return 5;
			}

		}
	}

	public boolean baja(int id) {
		boolean respuestaBaja = daoVideojuego.baja(id);
		boolean solucion = false;
		if (respuestaBaja) {
			solucion = true;
		} else if (!respuestaBaja) {
			solucion = false;
		}
		return solucion;
	}

	//Tambien deberiamos de haber comprobado que no se repitan nombre
	public boolean modificar(Videojuego p) {
		boolean respuestaModificar = daoVideojuego.modificar(p);
		boolean solucion = false;
		if (respuestaModificar) {
			solucion = true;
		} else if (!respuestaModificar) {
			solucion = false;
		}
		return solucion;
	}

	public Videojuego obtener(int id) {
		Videojuego v = daoVideojuego.obtener(id);
		return v;
	}

	public List<Videojuego> listar() {
		List<Videojuego> listaVideojugos = daoVideojuego.listar();
		return listaVideojugos;
	}

	public List<Videojuego> listarCompania(String c) {
		List<Videojuego> listaVideojugos = daoVideojuego.listarCompania(c);
		return listaVideojugos;
	}

	

	private boolean comprobarNombreRepetido(Videojuego p) {
		// Crear select para saber si hay otra compañia que tenga un juego
		Videojuego v = daoVideojuego.comprobarNombre(p.getNombre());
		if (v != null) {
			return true;
		} else {
			return false;
		}

	}

	// Comprueba que el nombre no este vacio
	private boolean comprobarNombre(Videojuego p) {
		if (p.getNombre().equals("")) {
			return true;
		}
		return false;
	}

}
