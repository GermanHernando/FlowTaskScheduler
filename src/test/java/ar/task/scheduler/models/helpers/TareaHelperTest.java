package ar.task.scheduler.models.helpers;

import java.time.LocalDateTime;

import ar.task.scheduler.models.Tarea;

public class TareaHelperTest extends PlantillaHelperTest   {

	
	private static final LocalDateTime FECHA_VALIDA = LocalDateTime.of(2026, 9, 12, 22, 42, 42);
	private static final LocalDateTime FECHA_ANTERIOR_INVALIDA = LocalDateTime.MIN;
	
	
	
	//VALIDO
	public static Tarea crearEntidadValida() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA,FECHA_VALIDA);
	}
	
	
	//INVALIDO
	
	// TITULO INVALIDO
		public static Tarea crearTareaTituloVacio() {
			return new Tarea(VARIABLE_VACIA, DESCRIPCION_VALIDA, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		public static Tarea crearTareaTituloNulo() {
			return new Tarea(VARIABLE_NULL, DESCRIPCION_VALIDA, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		public static Tarea crearTareaTituloMinCantCaracteres() {
			return new Tarea(STRING_MIN_CANT_CARACTERES, DESCRIPCION_VALIDA, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		public static Tarea crearTareaTituloMaxCantCaracteres() {
			return new Tarea(STRING_MAX_CANT_CARACTERES, DESCRIPCION_VALIDA, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		// DESCRIPCION INVALIDA
		public static Tarea crearTareaDescripcionVacia() {
			return new Tarea(TITULO_VALIDO, VARIABLE_VACIA, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		public static Tarea crearTareaDescripcionNula() {
			return new Tarea(TITULO_VALIDO, VARIABLE_NULL, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		public static Tarea crearTareaDescripcionMinCantCaracteres() {
			return new Tarea(TITULO_VALIDO, STRING_MIN_CANT_CARACTERES, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		public static Tarea crearTareaDescripcionMaxCantCaracteres() {
			return new Tarea(TITULO_VALIDO, STRING_MAX_CANT_CARACTERES, CATEGORIA_VALIDA,FECHA_VALIDA);
		}

		// CATEGORIA INVALIDA

		public static Tarea crearTareaCategoriaVacia() {
			return new Tarea(TITULO_VALIDO, DESCRIPCION_VALIDA, CategoriaHelperTest.crearCategoriaNombreVacio(),FECHA_VALIDA);
		}

		public static Tarea crearTareaCategoriaNula() {
			return new Tarea(TITULO_VALIDO, DESCRIPCION_VALIDA, CategoriaHelperTest.crearCategoriaNombreNulo(),FECHA_VALIDA);
		}

		public static Tarea crearTareaCategoriaMinCantCaracteres() {
			return new Tarea(TITULO_VALIDO, DESCRIPCION_VALIDA,
					CategoriaHelperTest.crearCategoriaNombreMinCantidadCaracteres(),FECHA_VALIDA);
		}

		public static Tarea crearTareaCategoriaMaxCantCaracteres() {
			return new Tarea(TITULO_VALIDO, DESCRIPCION_VALIDA,
					CategoriaHelperTest.crearCategoriaNombreMaxCantidadCaracteres(),FECHA_VALIDA);
		}
	
	
	//FECHA INVALIDA
	public static Tarea crearTareaFechaNula() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA,null);
	}
	
	public static Tarea crearTareaFechaAnterior() {
		return new Tarea(TITULO_VALIDO,DESCRIPCION_VALIDA,CATEGORIA_VALIDA,FECHA_ANTERIOR_INVALIDA);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
