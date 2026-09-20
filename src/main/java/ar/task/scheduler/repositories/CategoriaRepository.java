package ar.task.scheduler.repositories;

import org.springframework.stereotype.Repository;

import ar.task.scheduler.models.Categoria;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria> {

	public Categoria findByNombre(String nombre);
}
