package ar.task.scheduler.services;

import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Usuario;

@Service
public  class UsuarioServiceImp extends UserArtifactServiceImp<Usuario> implements UsuarioService{


	public void guardar(Usuario usuario) {
		if (usuario != null && this.buscarPorEmail(usuario.getEmail()) != null) {
			throw new ExistingAddException();
		}
		this.repository().save(usuario);
	}

	public void eliminar(Usuario usuario) {
		if (usuario != null && this.buscarPorEmail(usuario.getEmail()) == null) {
			throw new UnexistingRemoveException();
		}
		this.repository().delete(usuario);
	}

	



}
