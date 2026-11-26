package ar.task.scheduler.models.helpers;

import ar.task.scheduler.interfaces.test.Validable;

public abstract class UserArtifactHelperTest implements Validable {

	// VALIDO
	public static final String EMAIL_VALIDO = "prueba@gmail.com";
	public static final String CONTRASENIA_VALIDA = "Contrasenia_1";
	public static final String NOMBRE_VALIDO = "Homero";
	public static final String APELLIDO_VALIDO = "Simpson";

	// INVALIDO
	public static final String EMAIL_INVALIDO_FORMATO = "email-invalido";
	public static final String EMAIL_CANT_CARACTERES = "mailconmayorcantidaddecaracteresrecomendadosparaelprogramaestablecido@gmail.com";
	public static final String CONTRASENIA_CANT_CARACTERES = "Contrasenia_1Contrasenia_2Contrasenia_3Contrasenia_4";
	public static final String CONTRASENIA_SIN_MAYUSCULA = "contrasenia_1";
	public static final String CONTRASENIA_SIN_NUMERO = "Contrasenia";
	public static final String CONTRASENIA_SIN_ESPECIAL = "Password123";

	

	

}
