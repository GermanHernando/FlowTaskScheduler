package ar.task.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;

import ar.task.scheduler.models.Persistible;
import ar.task.scheduler.repositories.BaseRepository;

public abstract class CRUDServiceImp <T extends Persistible, R extends BaseRepository<T>> implements CRUDService<T>{

	@Autowired
	private R repository;
	
	protected R repository() {
		return this.repository;
	}
	
	@Override
	public void guardar(T entidad) {
		this.repository.save(entidad);
	}
	
	@Override
	public void eliminar(T entidad) {
		this.repository.delete(entidad);
	}
	
	
	
}
