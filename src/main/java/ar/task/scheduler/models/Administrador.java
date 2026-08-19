package ar.task.scheduler.models;

import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "ADMINISTRADORES")
public class Administrador extends Usuario {

	@ElementCollection(targetClass = Tarea.class)
    @CollectionTable(name = "LISTAS_ADMINISTRADORES_Y_USUARIOS",joinColumns = @JoinColumn(name = "ADMIN_ID"))
	@Column(name = "USUARIO_ID")
	private List<Usuario>usuarios;
	@ElementCollection(targetClass = Tarea.class)
    @CollectionTable(name = "TAREAS_GUARDADAS_ADMIN",joinColumns = @JoinColumn(name = "ADMIN_ID"))
	@Column(name = "TAREA_ID")
	private List<Tarea>plantillasTareas;
	
	Administrador() {}
	
	//Para guardar en lista administradores de Usuario
	public Administrador(String email, String nombre, String apellido) {
		super(email, nombre, apellido);
	}
	
	 public Administrador(String email, String contrasenia, String nombre, String apellido) {
		super(email,contrasenia,nombre,apellido);
		this.usuarios = new ArrayList<Usuario>();
		this.plantillasTareas = new ArrayList<Tarea>();
		super.convertirEnAdmin();
	}
	
	public void agregarUsuario(String email,String nombre, String apellido) {
		if(buscarUsuario(email)!=null) {
			throw new ExistingAddException();
		}
		Usuario user = new Usuario(email,nombre,apellido);
		user.agregarAdmin();
		this.usuarios.add(user);			
	}
	
	private Usuario buscarUsuario(String email) {
	    return usuarios.stream()
	            .filter(usuario -> usuario.mismoEmail(email))
	            .findFirst()
	            .orElse(null);
	}


	public void eliminarUsuario(String email) {
		Usuario user = this.buscarUsuario(email);
		if (user==null) {
			throw new UnexistingRemoveException();
		}
		user.eliminarAdmin();
		usuarios.remove(user);
		
	}

	
	public void agregarPlantillaTarea(String titulo, String descripcion, Categoria categoria) {
		Tarea t = this.buscarPlantillaTarea(titulo);
		if(t!=null) {
			throw new ExistingAddException();
		}
		this.plantillasTareas.add(new Tarea(titulo,descripcion,categoria));
	}

	private Tarea buscarPlantillaTarea(String titulo) {	
		return plantillasTareas.stream()
				.filter(tarea -> tarea.mismoTitulo(titulo))
				.findFirst()
				.orElse(null);
	}
	
	public void eliminarPlantillaTarea(String titulo) {
		Tarea t = this.buscarPlantillaTarea(titulo);
		if(t!=null) {
			throw new UnexistingRemoveException();
		}
		plantillasTareas.remove(t);
	}
	
	
	public void agreagarTareaAUsuario(Usuario usuario, Tarea tarea) {
		Usuario user = this.buscarUsuario(usuario.getEmail());
		if(user!=null) {
			user.agregarTarea(tarea);
			tarea.agregarResponsable(user);
		}
	}
	
	
	
	
	

	
	
	
	

	
	
	
	
	
}
