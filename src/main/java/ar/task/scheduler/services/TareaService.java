package ar.task.scheduler.services;

import ar.task.scheduler.models.Tarea;

public interface TareaService extends PlantillaService<Tarea>{
	
	public void agregarResponsableATarea(Tarea tarea, String email );
	
	public void eliminarResponsableDeTarea(Tarea tarea, String email);

}
