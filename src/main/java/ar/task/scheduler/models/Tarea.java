package ar.task.scheduler.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.enums.EstadoTarea;
import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.interfaces.Persistible;
import ar.task.scheduler.models.validators.TareaValidator;

public class Tarea implements Persistible{

	private Long id;
	private String titulo;
	private String descripcion;
	private Categoria categoria;
	private LocalDateTime fechaAsignada;
	private EstadoTarea estado;
	private List<Usuario>responsables;
	
	Tarea() {}
	
	//Admin guardar tareas
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

	public Long getId() {
		return id;
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
	
	public boolean mismoTitulo(String titulo) {
		return this.titulo.equals(titulo);
	}
	
	
	public void cambiarEstado() {
		this.estado = estado == EstadoTarea.PENDIENTE? EstadoTarea.COMPLETADA:EstadoTarea.PENDIENTE;
	}
	
	public void completar() {
		this.estado = EstadoTarea.COMPLETADA;
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
