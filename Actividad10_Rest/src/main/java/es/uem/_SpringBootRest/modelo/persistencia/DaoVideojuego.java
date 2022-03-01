package es.uem._SpringBootRest.modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.uem._SpringBootRest.modelo.entidad.Videojuego;

@Repository
public class DaoVideojuego {

	private Connection conexion;
	PreparedStatement ps;
	String cadenaConexion = "jdbc:mysql://localhost:3306/bbddv";
	String user = "root";
	String pass = "";
	int contador = 0;

	// Abrir la conexión y la base de datos se llama bbdd y esta en phpmyadmin
	public boolean abrirConexion() {
		try {
			conexion = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Cerrar la conexión
	public boolean cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// Dar de alta a un Vidiojuego en nuestra base de datos
	// CAMBIAR LA BASE DE DATOS
	public boolean alta(Videojuego p) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "insert into videojuegos (id,nombre,compania,nota) " + " values(?,?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			ps = conexion.prepareStatement(query);
			ps.setInt(1, contador++);
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getCompania());
			ps.setString(4, p.getNota());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return alta;
	}

	// Damos de baja a un videojuego por id
	public boolean baja(int id) {
		if (!abrirConexion()) {
			return false;
		}

		boolean borrado = true;
		String query = "delete from videojuegos where id = ?";
		try {
			ps = conexion.prepareStatement(query);
			// sustituimos la primera interrgante por la id
			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			System.out.println("baja -> No se ha podido dar de baja al videojuego con" + " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
	}

	// Modificamos el videojuego por id
	public boolean modificar(Videojuego p) {
		if (!abrirConexion()) {
			return false;
		}
		boolean modificado = true;
		String query = "update videojuegos set nombre=?, compania=?, nota=? WHERE ID=?";
		try {
			ps = conexion.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getCompania());
			ps.setString(3, p.getNota());
			ps.setInt(4, p.getId());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar el " + " videojuego " + p);
			modificado = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return modificado;
	}

	// Obtener un Videojuego por id
	public Videojuego obtener(int id) {
		if (!abrirConexion()) {
			return null;
		}
		Videojuego videojuego = null;

		String query = "select id,nombre,compania,nota from videojuegos " + "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				videojuego = new Videojuego();
				videojuego.setId(rs.getInt(1));
				videojuego.setNombre(rs.getString(2));
				videojuego.setCompania(rs.getString(3));
				videojuego.setNota(rs.getString(4));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el videojuego " + "con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return videojuego;
	}

	// Listar TODOS los videojugos
	public List<Videojuego> listar() {
		if (!abrirConexion()) {
			return null;
		}
		List<Videojuego> listavideojuegos = new ArrayList<>();

		String query = "select * from videojuegos";
		try {
			ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Videojuego videojuego = new Videojuego();
				videojuego = new Videojuego();
				videojuego.setId(rs.getInt(1));
				videojuego.setNombre(rs.getString(2));
				videojuego.setCompania(rs.getString(3));
				videojuego.setNota(rs.getString(4));

				listavideojuegos.add(videojuego);
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener los videojuegos");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listavideojuegos;
	}

	// Listar videojugos a partir de un compañia
	public List<Videojuego> listarCompania(String c) {
		if (!abrirConexion()) {
			return null;
		}
		List<Videojuego> listavideojuegos = new ArrayList<>();

		String query = "select id,nombre,compania,nota from videojuegos " + "where compania = ?";
		try {
			ps = conexion.prepareStatement(query);
			ps.setString(1, c);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Videojuego videojuego = new Videojuego();
				videojuego = new Videojuego();
				videojuego.setId(rs.getInt(1));
				videojuego.setNombre(rs.getString(2));
				videojuego.setCompania(rs.getString(3));
				videojuego.setNota(rs.getString(4));

				listavideojuegos.add(videojuego);
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener los " + "videojuegos con nombre: " + c);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listavideojuegos;
	}

	
	public Videojuego comprobarNombre(String nombre) {
		if (!abrirConexion()) {
			return null;
		}
		Videojuego videojuego = null;

		String query = "select id, nombre from videojuegos where nombre= ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, nombre);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				videojuego = new Videojuego();
				videojuego.setId(rs.getInt(1));
				videojuego.setNombre(rs.getString(2));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener el videojuego " + "con nombre " + nombre);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return videojuego;
	}
	
}
