package ar.task.scheduler.repositories;

import org.springframework.stereotype.Repository;

import ar.task.scheduler.models.Tarea;

@Repository("tareaRepository")
public interface TareaRepository extends ItemArtifactRepository<Tarea>{

	
	
}
