package ar.task.scheduler.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends UserArtifact {

	@ManyToMany(cascade = CascadeType.ALL)
	@CollectionTable(name = "LISTAS_ADMINISTRADORES_Y_USUARIOS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "ADMIN_ID")
	private List<Administrador> administradores;
	@ManyToMany(cascade = CascadeType.ALL)
	@CollectionTable(name = "USUARIOS_TAREAS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "TAREA_ID")
	private List<Tarea> tareas;

	Usuario() {}

	// Guardar usuarios para envio de tareas
	public Usuario(String email, String nombre, String apellido) {
		super(email, nombre, apellido);
		this.tareas = new ArrayList<Tarea>();
		this.administradores = new ArrayList<Administrador>();
		convertirEnEmpleado();
	}
	
	public boolean tieneLaTarea(Tarea tarea) {
	    return this.tareas.stream().anyMatch(t -> tarea.mismaTarea(tarea));
	}
	

	public void agregarTarea(Tarea tarea) {
		if(tarea!=null) {
				this.agregarTarea(tarea.getTitulo(),tarea.getDescripcion(), tarea.getCategoria(), tarea.getFechaAsignada());			
			}
		}
	
	private void agregarTarea(String titulo, String descripcion, Categoria categoria, LocalDateTime fechaAsignada) {
		Tarea tarea = new Tarea(titulo,descripcion,categoria,fechaAsignada);
		boolean existe = this.tieneLaTarea(tarea);
		if (existe) {
			throw new ExistingAddException();
		}
		this.tareas.add(new Tarea(titulo, descripcion, categoria, fechaAsignada));
	}


	public void eliminarTarea(Tarea tarea) {
	    boolean existe = this.tieneLaTarea(tarea);
	    if (!existe) {
	        throw new UnexistingRemoveException();
	    }
	    this.tareas.remove(tarea);
	}
	
	public void agregarAdmin(Administrador admin) {
		if(admin!=null) {
			if (buscarAdminId(admin.getId()) != null) {
				throw new ExistingAddException();
			}
		}
		this.administradores.add(admin);
	}
	
	private Administrador buscarAdminId(Long id) {
		return this.administradores.stream().filter(admin -> admin.mismoId(id)).findFirst().orElse(null);
	}
	
	public void eliminarAdmin(Long id) {
		Administrador admin = this.buscarAdminId(id);
		if (admin == null) {
			throw new UnexistingRemoveException();
		}
		this.administradores.remove(admin);
	}
	



	

}
