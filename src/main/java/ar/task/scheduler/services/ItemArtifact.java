package ar.task.scheduler.services;

import ar.task.scheduler.models.Persistible;

public interface ItemArtifact<T extends Persistible> extends CRUDService<T>{

}
