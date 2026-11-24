package ar.task.scheduler.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import ar.task.scheduler.models.UserArtifact;

@NoRepositoryBean
public interface UserArtifactRepository <T extends UserArtifact> extends BaseRepository<T>{

	public T findByEmail (String email);
	
}
