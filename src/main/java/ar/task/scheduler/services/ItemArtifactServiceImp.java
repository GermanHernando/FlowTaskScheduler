package ar.task.scheduler.services;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.ItemArtifact;
import ar.task.scheduler.repositories.ItemArtifactRepository;

public abstract class ItemArtifactServiceImp<T extends ItemArtifact>
		extends CRUDServiceImp<T, ItemArtifactRepository<T>> implements ItemArtifactService<T> {

	@Override
	public T buscarPorTitulo(String titulo) {
		return repository().findByTitulo(titulo);
	}

	@Override
	public void guardar(T item) {
		T p = this.buscarPorTitulo(item.getTitulo());
		if (p != null) {
			throw new ExistingAddException();
		}
		this.repository().save(item);
	}

	@Override
	public void eliminar(T item) {
		T p = this.buscarPorTitulo(item.getTitulo());
		if (p == null) {
			throw new UnexistingRemoveException();
		}
		this.repository().delete(item);
	}

}
