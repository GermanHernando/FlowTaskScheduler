package ar.task.scheduler.exceptions;


public class UnexistingRemoveException extends ListException {

	private static final long serialVersionUID = 1L;
	private static final String MSG_ERROR_UNEXISTING_USER= "No se puede eliminar porque no existe"; 	

	public UnexistingRemoveException() {
		super(MSG_ERROR_UNEXISTING_USER);
		
	}

}
