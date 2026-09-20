package ar.task.scheduler.services;

import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Usuario;
import ar.task.scheduler.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp<T extends Usuario> extends CRUDServiceImp<T, UsuarioRepository<T>> implements UsuarioService<T> {

	public T buscarUsuario(String email) {
		return this.repository().findByEmail(email);
	}

	public void guardar(T usuario) {
		if (usuario != null && this.buscarUsuario(usuario.getEmail()) != null) {
			throw new ExistingAddException();
		}
		this.repository().save(usuario);
	}

	public void eliminar(T usuario) {
		if (usuario != null && this.buscarUsuario(usuario.getEmail()) == null) {
			throw new UnexistingRemoveException();
		}
		this.repository().delete(usuario);
	}



}
