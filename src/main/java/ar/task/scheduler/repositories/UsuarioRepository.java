package ar.task.scheduler.repositories;

import org.springframework.stereotype.Repository;

import ar.task.scheduler.models.Usuario;

@Repository
public interface UsuarioRepository <T extends Usuario> extends BaseRepository<T>{

	
	public T findByEmail (String email);
	
	
}
