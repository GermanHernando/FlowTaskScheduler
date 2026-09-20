package ar.task.scheduler.services;

import ar.task.scheduler.models.Plantilla;

public interface PlantillaService <T extends Plantilla> extends CRUDService<T>{
	
	public T buscarPorTitulo(String titulo);
	
	public T buscarPorId(Long id);
	

}
