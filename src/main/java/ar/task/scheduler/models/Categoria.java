package ar.task.scheduler.models;

import ar.task.scheduler.models.validators.CategoriaValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIAS")
public class Categoria extends Persistible{
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Categoria() {}
	
	public Categoria(String nombre) {
		this.setNombre(nombre);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = (CategoriaValidator.nombreCategoriaValidator(nombre)).toUpperCase();
	}

	

	
	
}
