package ar.task.scheduler.models.helpers;

import ar.task.scheduler.interfaces.test.Validable;

public abstract class UserArtifactHelperTest implements Validable {

	//VALIDO
	public static final String EMAIL_VALIDO = "prueba@gmail.com";
  
    public static final String NOMBRE_VALIDO = "Homero";
    public static final String APELLIDO_VALIDO = "Simpson";
    
    //INVALIDO
    public static final String EMAIL_INVALIDO_FORMATO = "email-invalido";
    public static final String EMAIL_CANT_CARACTERES = "mailconmayorcantidaddecaracteresrecomendadosparaelprogramaestablecido@gmail.com";
    
   
    
    
}
