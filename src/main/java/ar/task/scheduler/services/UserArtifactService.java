package ar.task.scheduler.services;

import ar.task.scheduler.models.UserArtifact;

public interface UserArtifactService <T extends UserArtifact> extends CRUDService<T> {

	public T buscarPorEmail(String email);
	
	
}
