package ar.task.scheduler.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.task.scheduler.models.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{

	public List<Tarea> findByTitulo(String titulo);
	
}
