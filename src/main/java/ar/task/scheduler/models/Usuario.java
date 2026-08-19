package ar.task.scheduler.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.task.scheduler.enums.Permiso;
import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.exceptions.UserPasswordException;
import ar.task.scheduler.models.validators.UsuarioValidator;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Persistible {

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;
	@Column(name = "CONTRASENIA")
	private String contrasenia;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "APELLIDO")
	private String apellido;
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection(targetClass = Permiso.class)
	@CollectionTable(name = "PERMISOS_USUARIOS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "PERMISO_ID")
	private List<Permiso> permisos;
	@ElementCollection(targetClass = Tarea.class)
	@CollectionTable(name = "LISTAS_ADMINISTRADORES_Y_USUARIOS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "ADMIN_ID")
	private List<Administrador> administradores;
	@ElementCollection(targetClass = Tarea.class)
	@CollectionTable(name = "USUARIOS_TAREAS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "TAREA_ID")
	private List<Tarea> tareas;

	Usuario() {
	}

	// Guardar usuarios para envio de tareas
	public Usuario(String email, String nombre, String apellido) {
		this.setEmail(email);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.permisos = new ArrayList<Permiso>();
		this.permisos.add(Permiso.EMPLEADO);
		this.tareas = new ArrayList<Tarea>();
		this.administradores = new ArrayList<Administrador>();
	}

	// Para construir usuarios Admin
	public Usuario(String email, String contrasenia, String nombre, String apellido) {
		this(email, nombre, apellido);
		this.setContrasenia(contrasenia);
	}

	protected void convertirEnAdmin() {
		this.permisos.add(Permiso.ADMINISTRADOR);
	}

	public void setEmail(String email) throws QuantityCharactersException, UserEmailException {
		this.email = UsuarioValidator.emailValidator(email).toLowerCase().trim();
	}

	public void setContrasenia(String contrasenia) throws QuantityCharactersException, UserPasswordException {
		this.contrasenia = UsuarioValidator.contraseniaValidator(contrasenia);
	}

	public void setNombre(String nombre) throws QuantityCharactersException {
		this.nombre = UsuarioValidator.nombreValidator(nombre);
	}

	public void setApellido(String apellido) throws QuantityCharactersException {
		this.apellido = UsuarioValidator.apellidoValidator(apellido);
	}

	public boolean tieneEmail() {
		return this.email != null && !this.email.isBlank();
	}

	public boolean mismoEmail(String email2) {
		return this.email.equals(email2);
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public List<Tarea> getTareasUnmodifiableList() {
	    return Collections.unmodifiableList(this.tareas);
	}
	
	public void agregarTarea(Tarea tarea) {
		if(tarea!=null) {
			if(tarea.getFechaAsignada()!=null) {
				this.agregarTarea(tarea.getTitulo(),tarea.getDescripcion(), tarea.getCategoria(), tarea.getFechaAsignada());			
			}else {
				this.agregarTarea(tarea.getTitulo(),tarea.getDescripcion(), tarea.getCategoria(), LocalDateTime.now());
			}
		}
	}

	public void agregarTarea(String titulo, String descripcion, Categoria categoria, LocalDateTime fechaAsignada) {
		Tarea tarea = buscarTarea(titulo);
		if (tarea!= null && tarea.mismaFecha(fechaAsignada) && tarea.mismaCategoria(categoria)) {
			throw new ExistingAddException();
		}
		this.tareas.add(new Tarea(titulo, descripcion, categoria, fechaAsignada));
	}

	private Tarea buscarTarea(String titulo) {
		return tareas.stream().filter(tarea -> tarea.mismoTitulo(titulo)).findFirst().orElse(null);
	}

	public void eliminarTarea(Tarea tarea) {
	    boolean existe = this.tareas.stream().anyMatch(t -> t.mismaTarea(tarea));
	    if (!existe) {
	        throw new UnexistingRemoveException();
	    }
	    this.tareas.removeIf(t -> t.mismaTarea(tarea));
	}
	
	public void agregarAdmin() {
		if (buscarAdminId() != null) {
			throw new ExistingAddException();
		}
		this.administradores.add(new Administrador(this.email,this.nombre,this.apellido));
	}
	

	private Administrador buscarAdminId() {
		return administradores.stream().filter(admin -> admin.mismoId(getId())).findFirst().orElse(null);
	}
	
	
	public void eliminarAdmin() {
		Administrador admin = this.buscarAdminId();
		if (admin == null) {
			throw new UnexistingRemoveException();
		}
		administradores.remove(admin);
	}
	

	public List<GrantedAuthority> coleccionAutorizaciones() {
		List<GrantedAuthority> credenciales = new ArrayList<GrantedAuthority>();
		for (Permiso permiso : this.permisos) {
			credenciales.add(new SimpleGrantedAuthority(permiso.securityName()));
		}
		return credenciales;
	}

	

}
