package ar.task.scheduler.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.enums.EstadoTarea;
import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.validators.TareaValidator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAREAS")
public class Tarea extends Plantilla {


	@Column(name = "FECHA_ASIGNADA")
	private LocalDateTime fechaAsignada;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ESTADO_ID")
	private EstadoTarea estado;
	@ManyToMany(cascade = CascadeType.ALL)
	@CollectionTable(name = "USUARIOS_TAREAS", joinColumns = @JoinColumn(name = "TAREA_ID"))
	@Column(name = "USUARIO_ID")
	private List<Usuario> responsables;

	Tarea() {
	}

	public Tarea(String titulo, String descripcion, Categoria categoria, LocalDateTime fechaAsignada) {
		super(titulo, descripcion, categoria);
		this.setFechaAsignada(fechaAsignada);
		this.estado = EstadoTarea.PENDIENTE;
		this.responsables = new ArrayList<Usuario>();
	}

	public void setFechaAsignada(LocalDateTime fechaAsignada) {
		this.fechaAsignada = TareaValidator.fechaValidator(fechaAsignada);
	}

	
	public LocalDateTime getFechaAsignada() {
		return fechaAsignada;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void cambiarEstado() {
		this.estado = estado == EstadoTarea.PENDIENTE ? EstadoTarea.COMPLETADA : EstadoTarea.PENDIENTE;
	}

	public void completar() {
		this.estado = EstadoTarea.COMPLETADA;
	}

	public boolean estaVencida() {
		return this.fechaAsignada.toLocalDate().isBefore(LocalDate.now());
	}

	public boolean mismaFecha(LocalDateTime fechaNueva) {
		return this.fechaAsignada.isEqual(fechaNueva);
	}

	public boolean mismaTarea(Tarea tarea) {
		return mismaPlantilla(tarea) && this.mismaFecha(tarea.getFechaAsignada());
	}

	public Plantilla generarPlantilla() {
		return new Plantilla(getTitulo(), getDescripcion(), getCategoria());
	}

	public void agregarResponsable(Usuario responsable) {
		if (responsable != null) {
			Usuario user = this.buscarResponsable(responsable.getEmail());
			if (user != null) {
				throw new ExistingAddException();
			}
			this.responsables.add(new Usuario(responsable.getEmail(), responsable.getNombre(), responsable.getApellido()));
		}
	}

	private Usuario buscarResponsable(String email) {
		return responsables.stream().filter(usuario -> usuario.mismoEmail(email)).findFirst().orElse(null);
	}

	public void eliminarResponsable(Usuario responsable) {
		if (responsable != null) {
			Usuario user = this.buscarResponsable(responsable.getEmail());
			if (user == null) {
				throw new UnexistingRemoveException();
			}
			responsables.remove(user);

		}

	}
	
	public boolean existeResponsable(String email) {
		return this.buscarResponsable(email)!=null; 
		
	}

}
