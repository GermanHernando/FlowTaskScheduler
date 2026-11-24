package ar.task.scheduler.models.helpers;

import ar.task.scheduler.models.Plantilla;

public class PlantillaHelperTest extends ItemArtifactHelperTest{

	
	// VALIDO
	public static Plantilla crearEntidadValida() {
		return new Plantilla(TITULO_VALIDO, DESCRIPCION_VALIDA, CATEGORIA_VALIDA);
	}

	// TITULO INVALIDO
	public static Plantilla crearPlantillaTituloVacio() {
		return new Plantilla(VARIABLE_VACIA, DESCRIPCION_VALIDA, CATEGORIA_VALIDA);
	}

	public static Plantilla crearPlantillaTituloNulo() {
		return new Plantilla(VARIABLE_NULL, DESCRIPCION_VALIDA, CATEGORIA_VALIDA);
	}

	public static Plantilla crearPlantillaTituloMinCantCaracteres() {
		return new Plantilla(STRING_MIN_CANT_CARACTERES, DESCRIPCION_VALIDA, CATEGORIA_VALIDA);
	}

	public static Plantilla crearPlantillaTituloMaxCantCaracteres() {
		return new Plantilla(STRING_MAX_CANT_CARACTERES, DESCRIPCION_VALIDA, CATEGORIA_VALIDA);
	}

	// DESCRIPCION INVALIDA
	public static Plantilla crearPlantillaDescripcionVacia() {
		return new Plantilla(TITULO_VALIDO, VARIABLE_VACIA, CATEGORIA_VALIDA);
	}

	public static Plantilla crearPlantillaDescripcionNula() {
		return new Plantilla(TITULO_VALIDO, VARIABLE_NULL, CATEGORIA_VALIDA);
	}

	public static Plantilla crearPlantillaDescripcionMinCantCaracteres() {
		return new Plantilla(TITULO_VALIDO, STRING_MIN_CANT_CARACTERES, CATEGORIA_VALIDA);
	}

	public static Plantilla crearPlantillaDescripcionMaxCantCaracteres() {
		return new Plantilla(TITULO_VALIDO, STRING_MAX_CANT_CARACTERES, CATEGORIA_VALIDA);
	}

	// CATEGORIA INVALIDA

	public static Plantilla crearPlantillaCategoriaVacia() {
		return new Plantilla(TITULO_VALIDO, DESCRIPCION_VALIDA, CategoriaHelperTest.crearCategoriaNombreVacio());
	}

	public static Plantilla crearPlantillaCategoriaNula() {
		return new Plantilla(TITULO_VALIDO, DESCRIPCION_VALIDA, CategoriaHelperTest.crearCategoriaNombreNulo());
	}

	public static Plantilla crearPlantillaCategoriaMinCantCaracteres() {
		return new Plantilla(TITULO_VALIDO, DESCRIPCION_VALIDA,
				CategoriaHelperTest.crearCategoriaNombreMinCantidadCaracteres());
	}

	public static Plantilla crearPlantillaCategoriaMaxCantCaracteres() {
		return new Plantilla(TITULO_VALIDO, DESCRIPCION_VALIDA,
				CategoriaHelperTest.crearCategoriaNombreMaxCantidadCaracteres());
	}

}
