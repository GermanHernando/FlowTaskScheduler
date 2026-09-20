package ar.task.scheduler.services;

import ar.task.scheduler.models.Categoria;

public interface CategoriaService extends CRUDService<Categoria>  {

	public Categoria buscarNombreCategoria(String nombre);
	
	
	
	
}
