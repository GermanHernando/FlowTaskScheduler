package ar.task.scheduler.helpers.validators;

import ar.task.scheduler.exceptions.QuantityCharactersException;

public class QuantityCharacterValidator {

	public static void validadorCantidadCaracteres(String palabra, int min, int max) {
		if(palabra.length()<min || palabra.length()>max) {
			throw new QuantityCharactersException(min, max);
		}
	}
	
	
	public static void validadorCantidadCaracteres(int numero, int min, int max) {
		if(numero<min || numero>max) {
			throw new QuantityCharactersException(min, max);
		}
	}
	
	
	
}
