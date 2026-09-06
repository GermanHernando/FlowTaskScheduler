package ar.task.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Categoria;
import ar.task.scheduler.repositories.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public Categoria buscarNombreCategoria(String nombre) {
		return this.categoriaRepository.findByNombre(nombre);
	}

	public void agregarCategoria(String nombre) {
		if(this.buscarNombreCategoria(nombre)!=null) {
			throw new ExistingAddException();
		}
		this.categoriaRepository.save(new Categoria(nombre));			
	}
	
	public void eliminarCategoria(String nombre) {
		Categoria categoria = this.buscarNombreCategoria(nombre);
		if(categoria==null) {
			throw new UnexistingRemoveException();
		}
		this.categoriaRepository.delete(categoria);
	}
	
	
}
