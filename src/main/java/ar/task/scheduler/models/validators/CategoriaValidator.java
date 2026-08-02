package ar.task.scheduler.models.validators;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.helpers.validators.QuantityCharacterValidator;

public class CategoriaValidator {

	private static final String MSG_ERROR_NULL_EMPTY = "%s no puede ser null o vacio/a";
	private static final String MSG_CATEGORY = "La Categoria ";
	private static final int MIN_TEXT = 4;
	private static final int MAX_TEXT_SHORT = 60;
	
	public static String nombreCategoriaValidator(String categoria)throws QuantityCharactersException {
		if(categoria==null||categoria.isBlank()) {
			throw new IllegalArgumentException(String.format(MSG_CATEGORY,MSG_ERROR_NULL_EMPTY));
		}
		QuantityCharacterValidator.validadorCantidadCaracteres(categoria, MIN_TEXT, MAX_TEXT_SHORT);
		return categoria;
	}
}
