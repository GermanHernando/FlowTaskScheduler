package ar.task.scheduler.models.validators;

import java.time.LocalDateTime;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.helpers.validators.QuantityCharacterValidator;
import ar.task.scheduler.models.Categoria;

public class TareaValidator {

	private static final String MSG_ERROR_NULL_EMPTY = "%s no puede ser null o vacio/a";
	private static final String MSG_TITLE = "El Titulo ";
	private static final String MSG_DESCRIPTION = "La Descripción ";
	private static final String MSG_CATEGORY = "La Categoria ";
	private static final String MSG_DATE = "La fecha y hora ";
	private static final int MIN_TEXT = 4;
	private static final int MAX_TEXT_SHORT = 60;
	private static final int MAX_TEXT_LONG = 200;
	private static final String MSG_INVALID_DATE_TIME = "La fecha no puede ser anterior a hoy y ahora";
	
	
	public static String tituloValidator(String titulo)throws QuantityCharactersException {
		if(titulo==null||titulo.isBlank()) {
			throw new IllegalArgumentException(String.format(MSG_TITLE,MSG_ERROR_NULL_EMPTY));
		}
		QuantityCharacterValidator.validadorCantidadCaracteres(titulo, MIN_TEXT, MAX_TEXT_SHORT);
		return titulo;
	}
	
	
	public static String descripcionValidator(String descripcion)throws QuantityCharactersException {
		if(descripcion==null||descripcion.isBlank()) {
			throw new IllegalArgumentException(String.format(MSG_DESCRIPTION,MSG_ERROR_NULL_EMPTY));
		}
		QuantityCharacterValidator.validadorCantidadCaracteres(descripcion, MIN_TEXT, MAX_TEXT_LONG);
		return descripcion;
	}
	
	
	public static Categoria categoriaValidator(Categoria categoria)throws QuantityCharactersException {
		if(categoria==null) {
			throw new IllegalArgumentException(String.format(MSG_CATEGORY,MSG_ERROR_NULL_EMPTY));
		}
		return categoria;
	}
	
	
	public static LocalDateTime fechaValidator(LocalDateTime fecha) {
	    if (fecha == null) {
	        throw new IllegalArgumentException(String.format(MSG_DATE, MSG_ERROR_NULL_EMPTY));
	    }
	    
	    if(fecha.isBefore(LocalDateTime.now())) {
	    	throw new IllegalArgumentException(MSG_INVALID_DATE_TIME);
	    }
	    return fecha;
	}
	
	
	
	
	
	
}
