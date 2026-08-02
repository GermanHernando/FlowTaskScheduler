package ar.task.scheduler.models.validators;

import java.util.regex.Pattern;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.exceptions.UserPasswordException;

public class UsuarioValidator {

	private static final Pattern REGEX_EMAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	private static final Pattern REGEX_CONTRASENIA_MAYUS = Pattern.compile(".*[A-Z].*");
	private static final Pattern REGEX_CONTRASENIA_MINUS = Pattern.compile(".*[a-z].*");
	private static final Pattern REGEX_CONTRASENIA_NUMBER = Pattern.compile(".*\\d.*");
	private static final Pattern REGEX_CONTRASENIA_CHARACTER_ESP = Pattern.compile(".*[@$!%*?&_-].*");
	private static final String MSJ_ERROR_EMAIL = "El email no puede ser nulo o estar vacio";
	private static final String MSJ_ERROR_EMAIL_ESPACIOS = "El email no puede contener espacios";
	private static final String MSJ_ERROR_VALIDACION_EMAIL = "Introduzca un email valido";
	private static final String MSJ_CONTRASENIA_INVALIDA = "La contrasenia no puede ser nula o vacia";
	private static final String MSJ_ERROR_CONTRASENIA_MAYUS = "La contrasenia debe contener al menos una mayuscula";
	private static final String MSJ_ERROR_CONTRASENIA_MINUS = "La contrasenia debe contener al menos una minuscula";
	private static final String MSJ_ERROR_CONTRASENIA_NUMBER = "La contrasenia debe contener al menos un numero";
	private static final String MSJ_ERROR_CONTRASENIA_CHARACTER_ESP = "La contrasenia debe contener un caracter especial";
	private static final String MSJ_ERROR_CONTRASENIA_SPACES = "La contrasenia no puede contener espacios";
	private static final int MIN_TAMANIO_EMAIL = 8;
	private static final int MAX_TAMANIO_EMAIL = 60;
	private static final int MAX_TAMANIO_CONTRASENIA = 30;
	private static final int MIN_TAMANIO_CONTRASENIA = 8;
	private static final String MSJ_ERROR_NOMBRE = "El nombre no puede ser vacío o contener caracteres especiales";
	private static final String MSJ_ERROR_APELLIDO = "El apellido no puede ser vacío o contener caracteres especiales";
	private static final int MIN_CANT_CHARACTER_NOMBRE_APELLIDO = 4;
	private static final int MAX_CANT_CHARACTER_NOMBRE_APELLIDO = 40;



	public static String emailValidator(String email) throws QuantityCharactersException {
		if (email == null || email.isBlank()) {
			throw new UserEmailException(MSJ_ERROR_EMAIL);
		}
		if (email.contains(" ")) {
			throw new UserEmailException(MSJ_ERROR_EMAIL_ESPACIOS);
		}
		if (email.length() < MIN_TAMANIO_EMAIL || email.length() > MAX_TAMANIO_EMAIL) {
			throw new QuantityCharactersException(MIN_TAMANIO_EMAIL, MAX_TAMANIO_EMAIL);
		}

		if (!validarRegexEmail(email)) {
			throw new UserEmailException(MSJ_ERROR_VALIDACION_EMAIL);
		}
		return email;
	}

	public static String contraseniaValidator(String contrasenia)throws QuantityCharactersException  {
		if (contrasenia == null || contrasenia.isBlank()) {
			throw new UserPasswordException(MSJ_CONTRASENIA_INVALIDA);
		}
		if (contrasenia.contains(" ")) {
			throw new UserPasswordException(MSJ_ERROR_CONTRASENIA_SPACES);
		}
		if (!validarMayusContrasenia(contrasenia)) {
			throw new UserPasswordException(MSJ_ERROR_CONTRASENIA_MAYUS);
		}
		if (!validarMinusContrasenia(contrasenia)) {
			throw new UserPasswordException(MSJ_ERROR_CONTRASENIA_MINUS);
		}
		if (!validarNumberContrasenia(contrasenia)) {
			throw new UserPasswordException(MSJ_ERROR_CONTRASENIA_NUMBER);
		}
		if (!validarEspecialCharacterContrasenia(contrasenia)) {
			throw new UserPasswordException(MSJ_ERROR_CONTRASENIA_CHARACTER_ESP);
		}
		if (contrasenia.length() < MIN_TAMANIO_CONTRASENIA || contrasenia.length() > MAX_TAMANIO_CONTRASENIA) {
			throw new QuantityCharactersException(MIN_TAMANIO_CONTRASENIA, MAX_TAMANIO_CONTRASENIA);
		}
		return contrasenia;
	}
	
	
	public static String nombreValidator(String nombre) throws QuantityCharactersException {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_NOMBRE);
		}
		if (nombre.length() < MIN_CANT_CHARACTER_NOMBRE_APELLIDO
				|| nombre.length() > MAX_CANT_CHARACTER_NOMBRE_APELLIDO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_NOMBRE_APELLIDO,
					MAX_CANT_CHARACTER_NOMBRE_APELLIDO);
		}
		return nombre;
	}

	public static String apellidoValidator(String apellido) throws QuantityCharactersException {
		if (apellido == null || apellido.isBlank()) {
			throw new IllegalArgumentException(MSJ_ERROR_APELLIDO);
		}
		if (apellido.length() < MIN_CANT_CHARACTER_NOMBRE_APELLIDO
				|| apellido.length() > MAX_CANT_CHARACTER_NOMBRE_APELLIDO) {
			throw new QuantityCharactersException(MIN_CANT_CHARACTER_NOMBRE_APELLIDO,
					MAX_CANT_CHARACTER_NOMBRE_APELLIDO);
		}
		return apellido;
	}

	private static boolean validarRegexEmail(String email) {
		return REGEX_EMAIL.matcher(email).matches();
	}

	private static boolean validarMayusContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_MAYUS.matcher(contrasenia).find();
	}

	private static boolean validarMinusContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_MINUS.matcher(contrasenia).find();
	}

	private static boolean validarNumberContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_NUMBER.matcher(contrasenia).find();
	}

	private static boolean validarEspecialCharacterContrasenia(String contrasenia) {
		return REGEX_CONTRASENIA_CHARACTER_ESP.matcher(contrasenia).find();
	}

}
