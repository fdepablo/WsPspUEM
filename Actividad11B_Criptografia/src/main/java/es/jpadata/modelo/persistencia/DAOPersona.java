package es.jpadata.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import es.jpadata.modelo.entidad.User;

@Repository
public interface DAOPersona extends JpaRepository<User, Integer>{
	
	public User findByEmail(String email);
	
}
