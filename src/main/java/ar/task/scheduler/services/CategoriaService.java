package ar.task.scheduler.services;

import ar.task.scheduler.models.Categoria;

public interface CategoriaService  {

	public Categoria buscarNombreCategoria(String nombre);
	
	public void agregarCategoria(String nombre);
	
	public void eliminarCategoria(String nombre);
	
	
}
