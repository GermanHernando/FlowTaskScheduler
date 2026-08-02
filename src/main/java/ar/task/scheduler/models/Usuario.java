package ar.task.scheduler.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.task.scheduler.enums.Permiso;
import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.exceptions.UserPasswordException;
import ar.task.scheduler.interfaces.Persistible;
import ar.task.scheduler.models.validators.UsuarioValidator;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Persistible {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	@CollectionTable(name = "TAREAS_USUARIOS", joinColumns = @JoinColumn(name = "USUARIO_ID"))
	@Column(name = "TAREA_ID")
	private List<Tarea> tareas;

	 Usuario() {}
	
	//Para guardar usuarios para envio de tareas
	public Usuario(String email, String nombre, String apellido) {
		this.setEmail(email);
		this.setNombre(nombre);
		this.setApellido(apellido);
	}

	//Para usuarios Admin
	public Usuario(String email, String contrasenia, String nombre, String apellido) {
		this(email,nombre,apellido);
		this.setContrasenia(contrasenia);
		this.permisos = new ArrayList<Permiso>();
		this.permisos.add(Permiso.EMPLEADO);
		this.tareas = new ArrayList<Tarea>();
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
	
	public Long getId() {
		return id;
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
	
	
	
	public void agregarTarea(String titulo,String descripcion, Categoria categoria) {
		if(buscarTarea(titulo)!=null) {
			throw new ExistingAddException();
		}
		this.tareas.add(new Tarea(titulo,descripcion,categoria));			
	}
	
	
	private Tarea buscarTarea(String titulo) {
	    return tareas.stream()
	            .filter(tarea -> tarea.mismoTitulo(titulo))
	            .findFirst()
	            .orElse(null);
	}


	public void eliminarTarea(String titulo) {
		Tarea user = this.buscarTarea(titulo);
		if (user==null) {
			throw new UnexistingRemoveException();
		}
		tareas.remove(user);
	}
	
	

	public List<GrantedAuthority> coleccionAutorizaciones() {
		List<GrantedAuthority> credenciales = new ArrayList<GrantedAuthority>();
		for (Permiso permiso : this.permisos) {
			credenciales.add(new SimpleGrantedAuthority(permiso.securityName()));
		}
		return credenciales;
	}


	

}
