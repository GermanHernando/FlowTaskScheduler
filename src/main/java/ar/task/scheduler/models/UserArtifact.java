package ar.task.scheduler.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.task.scheduler.enums.Permiso;
import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.exceptions.UserPasswordException;
import ar.task.scheduler.models.validators.UserArtifactValidator;
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
@Table(name = "USERS_ARTIFACTS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserArtifact extends Persistible {

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

	UserArtifact() {}

// TODO HACER USUARIO-DTO
//	public UserArtifact(String email, String nombre, String apellido) {
//		this.setEmail(email);
//		this.setNombre(nombre);
//		this.setApellido(apellido);
//	}

	public UserArtifact(String email, String contrasenia, String nombre, String apellido) {
		this.setEmail(email);
		this.setContrasenia(contrasenia);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.permisos = new ArrayList<Permiso>();
	}

	protected void convertirEnEmpleado() {
		this.permisos.add(Permiso.EMPLEADO);
	}

	protected void convertirEnAdmin() {
		this.permisos.add(Permiso.ADMINISTRADOR);
	}

	public void setEmail(String email) throws QuantityCharactersException, UserEmailException {
		this.email = UserArtifactValidator.emailValidator(email).toLowerCase().trim();
	}

	public void setContrasenia(String contrasenia) throws QuantityCharactersException, UserPasswordException {
		this.contrasenia = UserArtifactValidator.contraseniaValidator(contrasenia);
	}

	public void setNombre(String nombre) throws QuantityCharactersException {
		this.nombre = UserArtifactValidator.nombreValidator(nombre);
	}

	public void setApellido(String apellido) throws QuantityCharactersException {
		this.apellido = UserArtifactValidator.apellidoValidator(apellido);
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

	protected List<Permiso> getPermisos() {
		return this.permisos;
	}

	public List<GrantedAuthority> coleccionAutorizaciones() {
		List<GrantedAuthority> credenciales = new ArrayList<GrantedAuthority>();
		for (Permiso permiso : this.permisos) {
			credenciales.add(new SimpleGrantedAuthority(permiso.securityName()));
		}
		return credenciales;
	}

}
