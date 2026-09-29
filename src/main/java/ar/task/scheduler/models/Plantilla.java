package ar.task.scheduler.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLANTILLAS")
public class Plantilla extends ItemArtifact {

	
	Plantilla() {}

	
	public Plantilla(String titulo, String descripcion, Categoria categoria) {
		super(titulo,descripcion,categoria);
	}

	public Tarea generarTareaDesdePlantilla() {
		return new Tarea(super.getTitulo(),super.getDescripcion(),super.getCategoria(),LocalDateTime.now());
	}

}
