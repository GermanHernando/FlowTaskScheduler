package ar.task.scheduler.services;

import ar.task.scheduler.models.Usuario;

public interface UsuarioService <T extends Usuario> extends CRUDService<T> {

	public T buscarUsuario(String email);
	

	
}
