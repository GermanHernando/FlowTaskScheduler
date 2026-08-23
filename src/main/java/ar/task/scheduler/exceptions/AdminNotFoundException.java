package ar.task.scheduler.exceptions;

public class AdminNotFoundException extends UserNotFoundException {

	private static final long serialVersionUID = 1L;
	private static final String ADMIN_NOT_FOUND_EXCEPTION = "Administrador inexistente.";

	public AdminNotFoundException() {
		super(ADMIN_NOT_FOUND_EXCEPTION);
	}
	
}
