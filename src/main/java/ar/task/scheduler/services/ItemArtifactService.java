package ar.task.scheduler.services;

import ar.task.scheduler.models.ItemArtifact;

public interface ItemArtifactService<T extends ItemArtifact> extends CRUDService<T> {

	public T buscarPorTitulo(String titulo);

	

}
