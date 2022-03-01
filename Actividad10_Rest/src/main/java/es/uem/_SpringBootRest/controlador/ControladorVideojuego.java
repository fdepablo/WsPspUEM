package es.uem._SpringBootRest.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import es.uem._SpringBootRest.modelo.entidad.Videojuego;

import es.uem._SpringBootRest.modelo.negocio.GestorVideojuego;

@RestController
public class ControladorVideojuego {

	// En este caso, el objeto de tipo ControladorPersona
	// que hemos dado de alta en el contexto de Spring
	// mediante la anotacion @RestController NECESITA un objeto de tipo
	// GestorVideojuego para realizar su trabajo (y que dimos de alta previamente
	// con la anotacion @Service)

	@Autowired
	private GestorVideojuego gestorvideojuego;

	/**
	 * OBTENER VIDEOJUEGO
	 * GET
	 */
	// La URL para acceder a este metodo sería:
	// "http://localhost:8080/personas/ID" y el metodo a usar seria GET
	// ID sería el identificador que queremos buscar
	@GetMapping(path = "videojuegos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id) {
		System.out.println("Buscando persona con id: " + id);
		Videojuego p = gestorvideojuego.obtener(id);
		if (p != null) {
			return new ResponseEntity<Videojuego>(p, HttpStatus.OK);// 200 OK
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);// 404 NOT FOUND
		}
	}

	/** OKKKK
	 * AÑADIR VIDEOJUEGO
	 * POST
	 */
	// La URL para acceder a este metodo sería:
	// "http://localhost:8080/personas" y el metodo a usar seria POST
	// Pasandole la persona sin el ID dentro del body del HTTP request
	@PostMapping(path = "videojuegos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego p) {
		System.out.println("altaPersona: objeto persona: " + p);
		int d = gestorvideojuego.alta(p);
		if (d == 2) {
			System.out.println("El nombre esta repetido");
			return new ResponseEntity<Videojuego>(p, HttpStatus.NOT_ACCEPTABLE); //406 no se puede 
		}else if (d == 3) {
			System.out.println("El nombre esta vacio");
			return new ResponseEntity<Videojuego>(p, HttpStatus.NOT_ACCEPTABLE); //406 nombre vacio
		}else if (d == 4) {
			System.out.println("Se ha creado el Videojuego");
			return new ResponseEntity<Videojuego>(p,HttpStatus.CREATED);// 201 CREADO
		}else if (d == 5) {
			System.out.println("No se ha podido crear este videojuego");
			return new ResponseEntity<Videojuego>(p,HttpStatus.SERVICE_UNAVAILABLE);// 404 NOT FOUND
		}else{
			return null;
		}
		
	}

	/**OKKKK
	 * LISTAR VIDEOJUEGO
	 * GET
	 */
	
	// La URL para acceder a este metodo en caso de querer todas las personas
	// sería:
	// "http://localhost:8080/personas" y el metodo a usar seria GET
	// Si queremos filtrar por nombre entonces deberemos usar:
	// "http://localhost:8080/personas?nombre=NOMBRE_A_FILTRAR"
	@GetMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos(
			@RequestParam(name = "compania", required = false) String compania) {
		List<Videojuego> listaVideojuegos = null;
		// Si no me viene el nombre, devolvemos toda la lista
		if (compania == null) {
			System.out.println("Listando las personas");
			listaVideojuegos = gestorvideojuego.listar();
		} else {
			System.out.println("Listando las personas por compañia: " + compania);
			listaVideojuegos = gestorvideojuego.listarCompania(compania);
		}
		listaVideojuegos.forEach(v -> System.out.println(v));
		return new ResponseEntity<List<Videojuego>>(listaVideojuegos, HttpStatus.OK);
	}

	/**
	 * OKKKK
	 * MODIFICAR VIDEOJUEGO
	 * PUT
	 */
	// La URL para acceder a este metodo sería:
	// "http://localhost:8080/personas/ID" y el metodo a usar seria PUT
	// Pasandole la persona sin el ID dentro del body del HTTP request
	@PutMapping(path = "videojuegos/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(@PathVariable("id") int id, @RequestBody Videojuego p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		boolean pUpdate = gestorvideojuego.modificar(p);
		//Habria que haber hecho lo mismo que en alta
		if (pUpdate) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);// 200 OK
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_MODIFIED);// 304 NOT FOUND
		}
	}
	
	/**
	 * OKKKK
	 * ELIMINAR VIDEOJUEGO
	 * DELETE
	 */
	// La URL para acceder a este metodo sería:
	// "http://localhost:8080/personas/ID" y el metodo a usar seria DELETE
	@DeleteMapping(path = "videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable("id") int id) {
		System.out.println("ID a borrar: " + id);
		boolean p = gestorvideojuego.baja(id);
		if (p) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);// 200 OK
		} else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);// 404 NOT FOUND
		}
	}

}
