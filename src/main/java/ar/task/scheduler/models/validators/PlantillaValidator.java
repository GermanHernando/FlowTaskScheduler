package ar.task.scheduler.models.validators;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.helpers.validators.QuantityCharacterValidator;
import ar.task.scheduler.models.Categoria;

public class PlantillaValidator {

	protected static final String MSG_ERROR_NULL_EMPTY = "%s no puede ser null o vacio/a";
	private static final String MSG_TITLE = "El Titulo ";
	private static final String MSG_DESCRIPTION = "La Descripción ";
	private static final String MSG_CATEGORY = "La Categoria ";
	private static final int MIN_TEXT = 4;
	private static final int MAX_TEXT_SHORT = 60;
	private static final int MAX_TEXT_LONG = 200;

	public static String tituloValidator(String titulo) throws QuantityCharactersException {
		if (titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException(String.format(MSG_TITLE, MSG_ERROR_NULL_EMPTY));
		}
		QuantityCharacterValidator.validadorCantidadCaracteres(titulo, MIN_TEXT, MAX_TEXT_SHORT);
		return titulo;
	}

	public static String descripcionValidator(String descripcion) throws QuantityCharactersException {
		if (descripcion == null || descripcion.isBlank()) {
			throw new IllegalArgumentException(String.format(MSG_DESCRIPTION, MSG_ERROR_NULL_EMPTY));
		}
		QuantityCharacterValidator.validadorCantidadCaracteres(descripcion, MIN_TEXT, MAX_TEXT_LONG);
		return descripcion;
	}

	public static Categoria categoriaValidator(Categoria categoria) {
		if (categoria == null) {
			throw new IllegalArgumentException(String.format(MSG_CATEGORY, MSG_ERROR_NULL_EMPTY));
		}
		return categoria;
	}

}
