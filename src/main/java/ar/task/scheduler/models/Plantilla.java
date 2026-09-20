package ar.task.scheduler.models;

import java.time.LocalDateTime;

import ar.task.scheduler.models.validators.PlantillaValidator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLANTILLAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Plantilla extends Persistible {

	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATEGORIA_ID")
	private Categoria categoria;

	Plantilla() {
	}

	// Admin guarda estas tareas como plantillas
	public Plantilla(String titulo, String descripcion, Categoria categoria) {
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setCategoria(categoria);
	}

	public void setTitulo(String titulo) {
		this.titulo = PlantillaValidator.tituloValidator(titulo);
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = PlantillaValidator.descripcionValidator(descripcion);
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = PlantillaValidator.categoriaValidator(categoria);
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public boolean mismoTitulo(String titulo) {
		return this.titulo.equals(titulo);
	}

	public boolean mismaCategoria(Categoria categoria) {
		return this.categoria.equals(categoria);
	}

	public boolean mismaPlantilla(Plantilla plantilla) {
		return this.mismoTitulo(plantilla.getTitulo()) && this.mismaCategoria(plantilla.getCategoria());
	}
	
	
	public Tarea generarTareaDesdePlantilla() {
		return new Tarea(this.titulo,this.descripcion,this.categoria,LocalDateTime.now());
	}

}
