package ar.task.scheduler.repositories;

import org.springframework.stereotype.Repository;

import ar.task.scheduler.models.Plantilla;

@Repository
public interface PlantillaRepository <T extends Plantilla> extends BaseRepository<T>{

	public T findByTitulo(String titulo);
	
	
}
