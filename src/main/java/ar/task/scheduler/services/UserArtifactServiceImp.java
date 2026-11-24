package ar.task.scheduler.services;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.UserArtifact;
import ar.task.scheduler.repositories.UserArtifactRepository;

public abstract class UserArtifactServiceImp<T extends UserArtifact> extends CRUDServiceImp<T, UserArtifactRepository<T>>
		implements UserArtifactService<T> {

	
	@Override
	public T buscarPorEmail(String email) {
		return repository().findByEmail(email);
	}

	@Override
	public void guardar(T user) {
		T p = this.buscarPorEmail(user.getEmail());
		if (p != null) {
			throw new ExistingAddException();
		}
		this.repository().save(user);
	}

	@Override
	public void eliminar(T user) {
		T p = this.buscarPorEmail(user.getEmail());
		if (p == null) {
			throw new UnexistingRemoveException();
		}
		this.repository().delete(user);
	}

	
	

}
