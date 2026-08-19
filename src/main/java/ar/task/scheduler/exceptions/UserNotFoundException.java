package ar.task.scheduler.exceptions;

public class UserNotFoundException extends ListException {

	private static final long serialVersionUID = 1L;
	private static final String USER_NOT_FOUND_EXEPTION = "Usuario inexistente.";

	public UserNotFoundException() {
		super(USER_NOT_FOUND_EXEPTION);
		
	}

}
