package ar.task.scheduler.exceptions;

public class TaskSearchException extends ListException{

	private static final long serialVersionUID = 1L;
	private static final String TASK_FOUND_EXCEPTION = "Tarea existente.";
	private static final String TASK_NOT_FOUND_EXCEPTION = "Tarea inexistente.";

	
	public TaskSearchException(boolean tieneTarea) {
		super(existeTarea(tieneTarea));
	}
	
	
	private static String existeTarea(boolean existe) {
		return existe?TASK_FOUND_EXCEPTION:TASK_NOT_FOUND_EXCEPTION;
	}
}
