package ar.task.scheduler.services;

import ar.task.scheduler.models.Usuario;

public interface UsuarioService {

	public Usuario buscarUsuario(String email);
	
	public void guardarUsuario(Usuario admin);
	
	public void eliminarUsuario(Usuario admin);
	
}
