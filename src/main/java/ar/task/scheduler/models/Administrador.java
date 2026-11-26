package ar.task.scheduler.models;

import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.exceptions.UserNotFoundException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ADMINISTRADORES")
public class Administrador extends UserArtifact {

	@ManyToMany(cascade = CascadeType.ALL)
	@CollectionTable(name = "LISTAS_ADMINISTRADORES_Y_USUARIOS", joinColumns = @JoinColumn(name = "ADMIN_ID"))
	@Column(name = "USUARIO_ID")
	private List<Usuario> usuarios;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@CollectionTable(name = "PLANTILLAS_GUARDADAS_ADMIN", joinColumns = @JoinColumn(name = "ADMIN_ID"))
	@Column(name = "PLANTILLA_ID")
	private List<Plantilla> plantillas;

	Administrador() {}

	
	public Administrador(String email, String contrasenia, String nombre, String apellido) {
		super(email, contrasenia, nombre, apellido);
		this.usuarios = new ArrayList<Usuario>();
		this.plantillas = new ArrayList<Plantilla>();
		convertirEnAdmin();
	}
	

	public void agregarUsuario(String email,String contrasenia, String nombre, String apellido) {
		if (buscarUsuario(email) != null) {
			throw new ExistingAddException();
		}
		Usuario user = new Usuario(email, contrasenia, nombre, apellido );
		user.agregarAdmin(this);
		this.usuarios.add(user);
	}

	private Usuario buscarUsuario(String email) {
		return usuarios.stream().filter(usuario -> usuario.mismoEmail(email)).findFirst().orElse(null);
	}

	public void eliminarUsuario(String email) {
		Usuario user = this.buscarUsuario(email);
		if (user == null) {
			throw new UnexistingRemoveException();
		}
		user.eliminarAdmin(this.getId());
		usuarios.remove(user);

	}
	
	public void agregarPlantilla(Plantilla plantilla) {
		if(plantilla!=null) {
			boolean existe = existePlantilla(plantilla);
			if(existe) {
				throw new ExistingAddException();
			}
			this.plantillas.add(plantilla);			
		}
	}
	
	public void agregarPlantilla(String titulo, String descripcion, Categoria categoria) {
		Plantilla p = this.buscarPlantilla(titulo);
		if(p!=null) {
			throw new ExistingAddException();
		}
		this.plantillas.add(new Plantilla(titulo,descripcion,categoria));
	}
	
	private Plantilla buscarPlantilla(String titulo) {
		return plantillas.stream().filter(plantilla -> plantilla.mismoTitulo(titulo)).findFirst().orElse(null);
	}
	
	private boolean existePlantilla(Plantilla plantilla) {
		return plantillas.stream().anyMatch(p -> p.mismoItem(plantilla));
	}
	
	public void eliminarPlantilla(String titulo) {
		Plantilla t = this.buscarPlantilla(titulo);
		if(t==null) {
			throw new UnexistingRemoveException();
		}
		plantillas.remove(t);
	}

	
	public void agregarTareaAUsuario(String usuarioEmail, Tarea tarea) {
		Usuario user = this.buscarUsuario(usuarioEmail);
		if (user == null) {
			throw new UserNotFoundException();
		}
			Plantilla pTarea = this.usarPlantillaTarea(tarea);
			if (pTarea != null) {
				Tarea nuevaTarea = pTarea.generarTareaDesdePlantilla(); 
				user.agregarTarea(nuevaTarea);
				nuevaTarea.agregarResponsable(user);
			} else {
				user.agregarTarea(tarea);
				tarea.agregarResponsable(user);
			}
		
	}

	private Plantilla usarPlantillaTarea(Tarea tarea) {
		Plantilla t = this.buscarPlantilla(tarea.getTitulo());
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
