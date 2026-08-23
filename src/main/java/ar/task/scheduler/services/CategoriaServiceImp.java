package ar.task.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	
	
}
