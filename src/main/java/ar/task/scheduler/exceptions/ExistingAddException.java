package ar.task.scheduler.exceptions;


public class ExistingAddException extends ListException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_ERROR_EXISTING_USER = "No se puede agregar porque ya existe";
	
	
	public ExistingAddException() {
		super(MSG_ERROR_EXISTING_USER);
	}

	
	
}
