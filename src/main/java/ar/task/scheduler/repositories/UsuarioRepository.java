package ar.task.scheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.task.scheduler.models.Usuario;

@Repository
public interface UsuarioRepository <T extends Usuario>extends JpaRepository<T, Long>{

	
	public Usuario findByEmail (String email);
	
	
	
}
