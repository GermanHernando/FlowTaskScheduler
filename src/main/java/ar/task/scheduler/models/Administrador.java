package ar.task.scheduler.models;

import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.exceptions.UserNotFoundException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMINISTRADORES")
public class Administrador extends Usuario {

	@ManyToMany(cascade = CascadeType.ALL)
	@CollectionTable(name = "LISTAS_ADMINISTRADORES_Y_USUARIOS", joinColumns = @JoinColumn(name = "ADMIN_ID"))
	@Column(name = "USUARIO_ID")
	private List<Usuario> usuarios;
	@ElementCollection(targetClass = Tarea.class)
	@CollectionTable(name = "TAREAS_GUARDADAS_ADMIN", joinColumns = @JoinColumn(name = "ADMIN_ID"))
	@Column(name = "TAREA_ID")
	private List<Tarea> plantillasTareas;

	Administrador() {
	}

	// Para guardar en lista administradores de Usuario
	public Administrador(String email, String nombre, String apellido) {
		super(email, nombre, apellido);
	}

	public Administrador(String email, String contrasenia, String nombre, String apellido) {
		super(email, contrasenia, nombre, apellido);
		this.usuarios = new ArrayList<Usuario>();
		this.plantillasTareas = new ArrayList<Tarea>();
		super.convertirEnAdmin();
	}

	public void agregarUsuario(String email, String nombre, String apellido) {
		if (buscarUsuario(email) != null) {
			throw new ExistingAddException();
		}
		//TODO Reveer para eliminar según relación en DB (hacer después de los Tests)
		//Usuario user = new Usuario(email, nombre, apellido);
		//user.agregarAdmin();
		this.usuarios.add(new Usuario(email, nombre, apellido));
	}

	private Usuario buscarUsuario(String email) {
		return usuarios.stream().filter(usuario -> usuario.mismoEmail(email)).findFirst().orElse(null);
	}

	public void eliminarUsuario(String email) {
		Usuario user = this.buscarUsuario(email);
		if (user == null) {
			throw new UnexistingRemoveException();
		}
		//user.eliminarAdmin();
		usuarios.remove(user);

	}
	
	public void agregarPlantillaTarea(Tarea tarea) {
		if(tarea!=null) {
			boolean existe = existePlantillaTarea(tarea);
			if(existe) {
				throw new ExistingAddException();
			}
			this.plantillasTareas.add(tarea.generarPlantilla());			
		}
	}
	
	public void agregarPlantillaTarea(String titulo, String descripcion, Categoria categoria) {
		Tarea t = this.buscarPlantillaTarea(titulo);
		if(t!=null) {
			throw new ExistingAddException();
		}
		this.plantillasTareas.add(new Tarea(titulo,descripcion,categoria));
	}
	
	private Tarea buscarPlantillaTarea(String titulo) {
		return plantillasTareas.stream().filter(tarea -> tarea.mismoTitulo(titulo)).findFirst().orElse(null);
	}
	
	private boolean existePlantillaTarea(Tarea tarea) {
		return plantillasTareas.stream().anyMatch(t -> tarea.mismaPlantilla(tarea));
	}
	
	public void eliminarPlantillaTarea(String titulo) {
		Tarea t = this.buscarPlantillaTarea(titulo);
		if(t==null) {
			throw new UnexistingRemoveException();
		}
		plantillasTareas.remove(t);
	}

	public void agregarTareaAUsuario(String usuarioEmail, Tarea tarea) {
		Usuario user = this.buscarUsuario(usuarioEmail);
		if (user == null) {
			throw new UserNotFoundException();
		}
			Tarea plantillaTarea = this.usarPlantillaTarea(tarea);
			if (plantillaTarea != null) {
				user.agregarTarea(plantillaTarea);
			} else {
				user.agregarTarea(tarea);
			}
			tarea.agregarResponsable(user);
		
	}

	private Tarea usarPlantillaTarea(Tarea tarea) {
		Tarea t = this.buscarPlantillaTarea(tarea.getTitulo());
		return t != null ? t : null;
	}

	public void eliminarTareaAUsuario(String usuarioEmail, Tarea tarea) {
		Usuario user = this.buscarUsuario(usuarioEmail);
		if (user == null) {
			throw new UserNotFoundException();
		}
			user.eliminarTarea(tarea);
			tarea.eliminarResponsable(user);
	}
	
	

}
