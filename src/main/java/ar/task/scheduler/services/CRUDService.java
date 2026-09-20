package ar.task.scheduler.services;

public interface CRUDService <T> {

	void guardar(T entidad);

	void eliminar(T entidad);
	

}
