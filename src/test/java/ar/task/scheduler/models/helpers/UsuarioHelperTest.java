package ar.task.scheduler.models.helpers;

import ar.task.scheduler.models.Usuario;

public class UsuarioHelperTest extends UserArtifactHelperTest {


	public static Usuario crearUserValido() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	// EMAIL INVALIDO
	public static Usuario crearUserEmailVacio() {
		return new Usuario(VARIABLE_VACIA, CONTRASENIA_VALIDA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserEmailNulo() {
		return new Usuario(VARIABLE_NULL, CONTRASENIA_VALIDA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserEmailFormatoInvalido() {
		return new Usuario(EMAIL_INVALIDO_FORMATO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserEmailCantCaracteresInvalido() {
		return new Usuario(EMAIL_CANT_CARACTERES, CONTRASENIA_VALIDA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	// CONTRASEÑA INVALIDA
	public static Usuario crearUserContraseniaVacia() {
		return new Usuario(EMAIL_VALIDO, VARIABLE_VACIA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserContraseniaNula() {
		return new Usuario(EMAIL_VALIDO, VARIABLE_NULL, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserContraseniaCantCaracteresInvalido() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_CANT_CARACTERES, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserContraseniaSinMayuscula() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_SIN_MAYUSCULA, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserContraseniaSinNumero() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_SIN_NUMERO, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	public static Usuario crearUserContraseniaSinEspecial() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_SIN_ESPECIAL, NOMBRE_VALIDO, APELLIDO_VALIDO);
	}

	// NOMBRE INVALIDO
	public static Usuario crearUserNombreVacio() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_VACIA, APELLIDO_VALIDO);
	}

	public static Usuario crearUserNombreNulo() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_NULL, APELLIDO_VALIDO);
	}

	public static Usuario crearUserNombreMinCantidadCaracteres() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, STRING_MIN_CANT_CARACTERES, APELLIDO_VALIDO);
	}

	public static Usuario crearUserNombreMaxCantidadCaracteres() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, STRING_MAX_CANT_CARACTERES, APELLIDO_VALIDO);
	}

	// APELLIDO INVALIDO
	public static Usuario crearUserApellidoVacio() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, VARIABLE_VACIA);
	}

	public static Usuario crearUserApellidoNulo() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, VARIABLE_NULL);
	}

	public static Usuario crearUserApellidoMinCantidadCaracteres() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, STRING_MIN_CANT_CARACTERES);
	}

	public static Usuario crearUserApellidoMaxCantidadCaracteres() {
		return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, STRING_MAX_CANT_CARACTERES);
	}
	
	
}
