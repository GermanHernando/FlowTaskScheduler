package ar.task.scheduler.helpers;

import ar.task.scheduler.interfaces.test.Validable;
import ar.task.scheduler.models.Categoria;

public class CategoriaHelperTest implements Validable {

	
	
	 private static final String CATEGORIA_VALIDA = "Categoria Valida";
	
	 
	 public static Categoria crearCategoriaValida() {
	        return new Categoria(CATEGORIA_VALIDA);
	    }
	 
	    public static Categoria crearCategoriaNombreVacio() {
	    	return new Categoria("");
	    }
	    
	    public static Categoria crearCategoriaNombreNulo() {
	    	return new Categoria(null);
	    }
	    
	    public static Categoria crearCategoriaNombreMinCantidadCaracteres() {
	    	return new Categoria(STRING_MIN_CANT_CARACTERES);
	    }
	    
	    public static Categoria crearCategoriaNombreMaxCantidadCaracteres() {
	    	return new Categoria(STRING_MAX_CANT_CARACTERES);
	    }
	 
}
