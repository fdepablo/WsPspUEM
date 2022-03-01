package es.jpadata;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.jpadata.modelo.entidad.User;
import es.jpadata.modelo.persistencia.DAOPersona;

@SpringBootApplication
public class SpringJpaData2Application implements CommandLineRunner {
	@Autowired
	private User user;
	@Autowired
	private DAOPersona dp;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringJpaData2Application.class, args);

		System.out.println("Main acaba");
	}

	@Override
	public void run(String... args) throws Exception {

		// Introducimos un usuario con su contraseña ya transformada en hash code
		user.setId(0);
		user.setEmail("pepe@gmail.com");
		user.setPassword(hashear("123456"));

		dp.save(user);
		dp.findById(0);

		iniciarSesion();

	}

	private void iniciarSesion() {

		Scanner in = new Scanner(System.in);
		System.out.println("--------------INICIAR SESION--------------");
		System.out.println("Introduzca su email: ");
		String email = in.next();
		System.out.println("Introduzca la contraseña: ");
		String pwd = in.next();
		User u = null;
		try {
			u = dp.findByEmail(email);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (u != null) {
			confirmCorrectPwd(u.getPassword(), pwd);
		} else {
			System.out.println("No existe usuario con el email " + email);
		}

	}

	private void confirmCorrectPwd(String userPass, String pwd) {

		//Comprobamos que el hash guardado en bbdd sea igual hash
		//del password que nos llega
		if (userPass.equals(hashear(pwd))) {
			System.out.println("Tu constraseña es CORRECTA!");

		} else {
			System.out.println("Tu constraseña es INCORRECTA!");
		}

	}

	public String hashear(String pwd) {

		byte[] pwd1 = pwd.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(pwd1);
		byte[] bit = md.digest();
		String hash = Base64.getEncoder().encodeToString(bit);
		return hash;
	}

}
