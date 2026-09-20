package ar.task.scheduler.services;

import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Categoria;
import ar.task.scheduler.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImp extends CRUDServiceImp<Categoria, CategoriaRepository> implements CategoriaService{

	
	public Categoria buscarNombreCategoria(String nombre) {
		return this.repository().findByNombre(nombre);
	}

	@Override
	public void guardar(Categoria entidad) {
		if(this.buscarNombreCategoria(entidad.getNombre())!=null) {
			throw new ExistingAddException();
		}
		this.repository().save(entidad);			
	}
	
	@Override
	public void eliminar(Categoria entidad) {
		Categoria categoria = this.buscarNombreCategoria(entidad.getNombre());
		if(categoria==null) {
			throw new UnexistingRemoveException();
		}
		this.repository().delete(categoria);
	}

	

	
	
}
