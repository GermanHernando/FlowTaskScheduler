package ar.task.scheduler.enums;

public enum Permiso {
ADMINISTRADOR,
EMPLEADO;

public String securityName() {
	return "ROLE_"+ name();
}
	
}
