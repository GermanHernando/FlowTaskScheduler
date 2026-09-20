package ar.task.scheduler.services;

public interface CRUDService <T> {

	T buscarPorId(Long id);

	void guardar(T entidad);

	void eliminar(T entidad);

	

}
