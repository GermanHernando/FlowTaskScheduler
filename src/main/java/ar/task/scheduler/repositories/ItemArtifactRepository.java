package ar.task.scheduler.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import ar.task.scheduler.models.ItemArtifact;

@NoRepositoryBean
public interface ItemArtifactRepository <T extends ItemArtifact>extends BaseRepository<T>{

	public T findByTitulo(String titulo);
	
}
