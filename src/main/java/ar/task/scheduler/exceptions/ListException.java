package ar.task.scheduler.exceptions;

public abstract class ListException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ListException(String message) {
		super(message);
	}
	
}
