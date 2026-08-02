package ar.task.scheduler.exceptions;

public class QuantityCharactersException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private static final String CANT_CARACTERES_INVALIDA = "La cantidad de caracteres debe ser entre %d y %d";
	
	public QuantityCharactersException(int min, int max) {
		super(String.format(CANT_CARACTERES_INVALIDA, min,max));
	}
	
}
