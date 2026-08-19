package ar.task.scheduler.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.enums.EstadoTarea;
import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.validators.TareaValidator;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TAREAS")
public class Tarea extends Persistible{

	@Column(name = "TITULO")
	private String titulo;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "CATEGORIA_ID")
	private Categoria categoria;
	@Column(name = "FECHA_ASIGNADA")
	private LocalDateTime fechaAsignada;
	@Column(name = "ESTADO_ID")
	private EstadoTarea estado;
	@ElementCollection(targetClass = Tarea.class)
	@CollectionTable(name = "USUARIOS_TAREAS", joinColumns = @JoinColumn(name = "TAREA_ID"))
	@Column(name = "USUARIO_ID")
	private List<Usuario>responsables;
	
	Tarea() {}
	
	//Admin guarda estas tareas
	public Tarea(String titulo, String descripcion, Categoria categoria) {
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setCategoria(categoria);
	}
	
	
	public Tarea(String titulo, String descripcion, Categoria categoria, LocalDateTime fechaAsignada) {
		this(titulo, descripcion, categoria);
		this.setFechaAsignada(fechaAsignada);
		this.estado = EstadoTarea.PENDIENTE;
		this.responsables = new ArrayList<Usuario>();
	}
	
	
	public void setTitulo(String titulo) {
		this.titulo = TareaValidator.tituloValidator(titulo);
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = TareaValidator.descripcionValidator(descripcion);
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = TareaValidator.categoriaValidator(categoria);
	}
	
	public void setFechaAsignada(LocalDateTime fechaAsignada) {
		this.fechaAsignada = TareaValidator.fechaValidator(fechaAsignada);
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
	
	public LocalDateTime getFechaAsignada() {
		return fechaAsignada;
	}

	public EstadoTarea getEstado() {
		return estado;
	}
	
	public void cambiarEstado() {
		this.estado = estado == EstadoTarea.PENDIENTE? EstadoTarea.COMPLETADA:EstadoTarea.PENDIENTE;
	}
	
	public void completar() {
		this.estado = EstadoTarea.COMPLETADA;
	}
	
	public boolean estaVencida() {
		return this.fechaAsignada.toLocalDate().isBefore(LocalDate.now());
	}
	
	public boolean mismoTitulo(String titulo) {
		return this.titulo.equals(titulo);
	}

	public boolean mismaCategoria(Categoria categoria) {
		return this.categoria.equals(categoria);
	}
	
	public boolean mismaFecha(LocalDateTime fechaNueva) {
		return this.fechaAsignada.isEqual(fechaNueva);
	}
	

	public boolean mismaTarea(Tarea tarea) {
		return this.mismoTitulo(tarea.getTitulo())
				&& this.mismaCategoria(tarea.getCategoria()) 
				&& this.mismaFecha(tarea.getFechaAsignada());
	}
	
	public void agregarResponsable(Usuario responsable) {
		if(responsable!=null) {
			Usuario user = this.buscarResponsable(responsable.getEmail());
			if(user!=null) {
				throw new ExistingAddException();
			}
			this.responsables.add(new Usuario(responsable.getEmail(),responsable.getNombre(),responsable.getApellido()));			
		}
	}
	
	private Usuario buscarResponsable(String email) {
	    return responsables.stream()
	            .filter(usuario -> usuario.mismoEmail(email))
	            .findFirst()
	            .orElse(null);
	}


	public void eliminarResponsable(Usuario responsable) {
		if(responsable!=null) {
			Usuario user = this.buscarResponsable(responsable.getEmail());
			if (user==null) {
				throw new UnexistingRemoveException();
			}
			responsables.remove(user);
			
		}
		
	}
	
	
	
}
