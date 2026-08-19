package ar.task.scheduler.exceptions;

public class TaskNotFoundException extends ListException{

	private static final long serialVersionUID = 1L;
	private static final String TASK_NOT_FOUND_EXCEPTION = "Tarea inexistente.";

	public TaskNotFoundException() {
		super(TASK_NOT_FOUND_EXCEPTION);
	}

}
