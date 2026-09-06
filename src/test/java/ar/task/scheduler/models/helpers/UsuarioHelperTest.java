package ar.task.scheduler.models.helpers;

import ar.task.scheduler.interfaces.test.Validable;
import ar.task.scheduler.models.Usuario;

public class UsuarioHelperTest implements Validable {

	//VALIDO
	public static final String EMAIL_VALIDO = "prueba@gmail.com";
    public static final String CONTRASENIA_VALIDA = "Contrasenia_1";
    public static final String NOMBRE_VALIDO = "Homero";
    public static final String APELLIDO_VALIDO = "Simpson";
    
    //INVALIDO
    
    public static final String EMAIL_INVALIDO_FORMATO = "email-invalido";
    public static final String EMAIL_CANT_CARACTERES = "mailconmayorcantidaddecaracteresrecomendadosparaelprogramaestablecido@gmail.com";
    public static final String CONTRASENIA_CANT_CARACTERES = "Contrasenia_1Contrasenia_2Contrasenia_3Contrasenia_4";
    public static final String CONTRASENIA_SIN_MAYUSCULA = "contrasenia_1";
    public static final String CONTRASENIA_SIN_NUMERO = "Contrasenia";
    public static final String CONTRASENIA_SIN_ESPECIAL = "Password123";
   
    
    
    public static Usuario crearUsuarioValidoSinContrasenia() {
        return new Usuario(EMAIL_VALIDO, NOMBRE_VALIDO,
                APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioValidoConContrasenia() {
        return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO);
    }
    
    //EMAIL INVALIDO
    public static Usuario crearUsuarioEmailVacio() {
    	return new Usuario(VARIABLE_VACIA,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioEmailNulo() {
    	return new Usuario(VARIABLE_NULL,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioEmailFormatoInvalido() {
    	return new Usuario(EMAIL_INVALIDO_FORMATO,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioEmailCantCaracteresInvalido() {
    	return new Usuario(EMAIL_CANT_CARACTERES,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    // CONTRASEÑA INVALIDA
    public static Usuario crearUsuarioContraseniaVacia() {
    	return new Usuario(EMAIL_VALIDO, VARIABLE_VACIA, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioContraseniaNula() {
    	return new Usuario(EMAIL_VALIDO, VARIABLE_NULL, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioContraseniaCantCaracteresInvalido() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_CANT_CARACTERES, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioContraseniaSinMayuscula() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_SIN_MAYUSCULA, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioContraseniaSinNumero() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_SIN_NUMERO, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioContraseniaSinEspecial() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_SIN_ESPECIAL, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    // NOMBRE INVALIDO
    public static Usuario crearUsuarioNombreVacio() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_VACIA, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioNombreNulo() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_NULL, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioNombreMinCantidadCaracteres() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, STRING_MIN_CANT_CARACTERES, APELLIDO_VALIDO);
    }
    
    public static Usuario crearUsuarioNombreMaxCantidadCaracteres() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, STRING_MAX_CANT_CARACTERES_72, APELLIDO_VALIDO);
    }
    
    // APELLIDO INVALIDO
    public static Usuario crearUsuarioApellidoVacio() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, VARIABLE_VACIA);
    }
    
    public static Usuario crearUsuarioApellidoNulo() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, VARIABLE_NULL);
    }
    
    public static Usuario crearUsuarioApellidoMinCantidadCaracteres() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, STRING_MIN_CANT_CARACTERES);
    }
    
    public static Usuario crearUsuarioApellidoMaxCantidadCaracteres() {
    	return new Usuario(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, STRING_MAX_CANT_CARACTERES_72);
    }
    
    
    
}
