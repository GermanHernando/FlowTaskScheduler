package ar.task.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Usuario;
import ar.task.scheduler.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp<T extends Usuario> implements UsuarioService<T> {

	@Autowired
	protected UsuarioRepository<T> usuarioRepository;

	public T buscarUsuario(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	public void guardarUsuario(T usuario) {
		if (usuario != null && this.buscarUsuario(usuario.getEmail()) != null) {
			throw new ExistingAddException();
		}
		this.usuarioRepository.save(usuario);
	}

	public void eliminarUsuario(T usuario) {
		if (usuario != null && this.buscarUsuario(usuario.getEmail()) == null) {
			throw new UnexistingRemoveException();
		}
		this.usuarioRepository.delete(usuario);
	}



}
