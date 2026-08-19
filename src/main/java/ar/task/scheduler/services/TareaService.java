package ar.task.scheduler.services;

import java.util.List;

import ar.task.scheduler.models.Tarea;

public interface TareaService {
	
	public List<Tarea> buscarTarea(String titulo);
	
	public void guardarTarea(Tarea tarea);
	
	public void eliminarTarea(Tarea tarea);

}
