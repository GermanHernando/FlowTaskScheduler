package ar.task.scheduler.services;

import ar.task.scheduler.models.Usuario;

public interface UsuarioService <T extends Usuario> {

	public T buscarUsuario(String email);
	
	public void guardarUsuario(T usuario);
	
	public void eliminarUsuario(T usuario);
	
}
