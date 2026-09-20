package ar.task.scheduler.services;

import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.TaskSearchException;
import ar.task.scheduler.exceptions.UserNotFoundException;
import ar.task.scheduler.models.Tarea;
import ar.task.scheduler.models.Usuario;
import ar.task.scheduler.repositories.UsuarioRepository;

@Service
public class TareaServiceImp extends PlantillaServiceImp<Tarea> implements TareaService {

	private UsuarioRepository<Usuario> usuarioRepository;

	private boolean tareaTieneElResponsable(Tarea tarea, String email) {
		Tarea t = this.buscarPorId(tarea.getId());
		boolean laTiene = false;
		if (t != null) {
			laTiene = t.existeResponsable(email);
		}
		return laTiene;
	}

	@Override
	public void agregarResponsableATarea(Tarea tarea, String email) {
		if (tareaTieneElResponsable(tarea, email)) {
			throw new ExistingAddException();
		}
		Usuario u = usuarioRepository.findByEmail(email);
		if (u == null) {
			throw new UserNotFoundException();
		}
		tarea.agregarResponsable(u);
		repository().save(tarea);
	}

	@Override
	public void eliminarResponsableDeTarea(Tarea tarea, String email) {
		Tarea t = this.buscarPorId(tarea.getId());
		if (t == null) {
			throw new TaskSearchException(false);
		}
		Usuario u = usuarioRepository.findByEmail(email);
		t.eliminarResponsable(u);
		repository().save(t);
	}

	

	

}
