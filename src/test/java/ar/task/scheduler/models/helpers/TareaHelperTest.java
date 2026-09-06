package ar.task.scheduler.models.helpers;

import java.time.LocalDateTime;

import ar.task.scheduler.interfaces.test.Validable;
import ar.task.scheduler.models.Categoria;
import ar.task.scheduler.models.Tarea;

public class TareaHelperTest implements Validable {

	private static final String TITULO_VALIDO= "Tarea Valida";
	private static final String DESCRIPCION_VALIDA = "Esta es una descripción de tarea válida";
	private static final Categoria CATEGORIA_VALIDA = CategoriaHelperTest.crearCategoriaValida();
	private static final LocalDateTime FECHA_VALIDA = LocalDateTime.now().plusDays(1);
	private static final LocalDateTime FECHA_ANTERIOR_INVALIDA = LocalDateTime.MIN;
	
	
	
	//VALIDO
	public static Tarea crearTareaValidaSinFecha() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaValidaConFecha() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA,FECHA_VALIDA);
	}
	
	
	//INVALIDO
	
	//TITULO INVALIDO
	public static Tarea crearTareaTituloVacio() {
		return new Tarea(VARIABLE_VACIA,DESCRIPCION_VALIDA,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaTituloNulo() {
		return new Tarea(VARIABLE_NULL,DESCRIPCION_VALIDA,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaTituloMinCantCaracteres() {
		return new Tarea(STRING_MIN_CANT_CARACTERES,DESCRIPCION_VALIDA,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaTituloMaxCantCaracteres() {
		return new Tarea(STRING_MAX_CANT_CARACTERES_72,DESCRIPCION_VALIDA,CATEGORIA_VALIDA);
	}
	
	//DESCRIPCION INVALIDA
	public static Tarea crearTareaDescripcionVacia() {
		return new Tarea(TITULO_VALIDO,VARIABLE_VACIA,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaDescripcionNula() {
		return new Tarea(TITULO_VALIDO,VARIABLE_NULL,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaDescripcionMinCantCaracteres() {
		return new Tarea(TITULO_VALIDO,STRING_MIN_CANT_CARACTERES,CATEGORIA_VALIDA);
	}
	
	public static Tarea crearTareaDescripcionMaxCantCaracteres() {
		return new Tarea(TITULO_VALIDO,STRING_MAX_CANT_CARACTERES_216,CATEGORIA_VALIDA);
	}
	
	
	//CATEGORIA INVALIDA
	
	public static Tarea crearTareaCategoriaVacia() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CategoriaHelperTest.crearCategoriaNombreVacio());
	}
	
	public static Tarea crearTareaCategoriaNula() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CategoriaHelperTest.crearCategoriaNombreNulo());
	}
	
	public static Tarea crearTareaCategoriaMinCantCaracteres() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CategoriaHelperTest.crearCategoriaNombreMinCantidadCaracteres());
	}
	
	public static Tarea crearTareaCategoriaMaxCantCaracteres() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CategoriaHelperTest.crearCategoriaNombreMaxCantidadCaracteres());
	}
	
	
	//FECHA INVALIDA
	
	public static Tarea crearTareaFechaNula() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA,null);
	}
	
	public static Tarea crearTareaFechaAnterior() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA,FECHA_ANTERIOR_INVALIDA);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
