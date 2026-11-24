package ar.task.scheduler.models.helpers;

import ar.task.scheduler.models.Administrador;

public class AdministradorHelperTest extends UserArtifactHelperTest {

	public static final String CONTRASENIA_VALIDA = "Contrasenia_1";
	public static final String CONTRASENIA_CANT_CARACTERES = "Contrasenia_1Contrasenia_2Contrasenia_3Contrasenia_4";
    public static final String CONTRASENIA_SIN_MAYUSCULA = "contrasenia_1";
    public static final String CONTRASENIA_SIN_NUMERO = "Contrasenia";
    public static final String CONTRASENIA_SIN_ESPECIAL = "Password123";
    
    

    public static  Administrador crearUserValido() {
        return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO,
                APELLIDO_VALIDO);
    }
    

    //EMAIL INVALIDO
    public static Administrador crearUserEmailVacio() {
    	return new Administrador(VARIABLE_VACIA,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserEmailNulo() {
    	return new Administrador(VARIABLE_NULL,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserEmailFormatoInvalido() {
    	return new Administrador(EMAIL_INVALIDO_FORMATO,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserEmailCantCaracteresInvalido() {
    	return new Administrador(EMAIL_CANT_CARACTERES,CONTRASENIA_VALIDA,NOMBRE_VALIDO,APELLIDO_VALIDO);
    }
    
    // CONTRASEÑA INVALIDA
    public static Administrador crearUserContraseniaVacia() {
    	return new Administrador(EMAIL_VALIDO, VARIABLE_VACIA, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserContraseniaNula() {
    	return new Administrador(EMAIL_VALIDO, VARIABLE_NULL, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserContraseniaCantCaracteresInvalido() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_CANT_CARACTERES, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserContraseniaSinMayuscula() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_SIN_MAYUSCULA, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserContraseniaSinNumero() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_SIN_NUMERO, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserContraseniaSinEspecial() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_SIN_ESPECIAL, NOMBRE_VALIDO, APELLIDO_VALIDO);
    }
    
    // NOMBRE INVALIDO
    public static Administrador crearUserNombreVacio() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_VACIA, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserNombreNulo() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, VARIABLE_NULL, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserNombreMinCantidadCaracteres() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, STRING_MIN_CANT_CARACTERES, APELLIDO_VALIDO);
    }
    
    public static Administrador crearUserNombreMaxCantidadCaracteres() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, STRING_MAX_CANT_CARACTERES, APELLIDO_VALIDO);
    }
    
    // APELLIDO INVALIDO
    public static Administrador crearUserApellidoVacio() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, VARIABLE_VACIA);
    }
    
    public static Administrador crearUserApellidoNulo() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, VARIABLE_NULL);
    }
    
    public static Administrador crearUserApellidoMinCantidadCaracteres() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, STRING_MIN_CANT_CARACTERES);
    }
    
    public static Administrador crearUserApellidoMaxCantidadCaracteres() {
    	return new Administrador(EMAIL_VALIDO, CONTRASENIA_VALIDA, NOMBRE_VALIDO, STRING_MAX_CANT_CARACTERES);
    }
    
	
	
}
