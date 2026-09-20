package ar.task.scheduler.services;

import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Plantilla;
import ar.task.scheduler.repositories.PlantillaRepository;

@Service
public class PlantillaServiceImp <T extends Plantilla> extends CRUDServiceImp<T, PlantillaRepository<T>> implements PlantillaService<T> {

	@Override
	public T buscarPorTitulo(String titulo) { 
		return repository().findByTitulo(titulo);
	}
	
	
	@Override
	public void guardar(T plantilla) {
		T p = this.buscarPorTitulo(plantilla.getTitulo());
		if (p != null) {
			throw new ExistingAddException();
		}
		this.repository().save(plantilla);
	}


	@Override
	public void eliminar(T plantilla) {
		T p = this.buscarPorTitulo(plantilla.getTitulo());
		if (p == null) {
			throw new UnexistingRemoveException();
		}
		this.repository().delete(plantilla);
	}
	
}





