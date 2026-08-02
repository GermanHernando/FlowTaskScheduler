package ar.task.scheduler.models;

import ar.task.scheduler.interfaces.Persistible;
import ar.task.scheduler.models.validators.CategoriaValidator;

public class Categoria implements Persistible{
	
	private Long id;
	private String nombre;
	
	public Categoria(String nombre) {
		this.setNombre(nombre);
	}

	public Long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = (CategoriaValidator.nombreCategoriaValidator(nombre)).toUpperCase();
	}

	

	
	
}
