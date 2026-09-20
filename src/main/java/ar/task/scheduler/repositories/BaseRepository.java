package ar.task.scheduler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.task.scheduler.models.Persistible;

public interface BaseRepository <T extends Persistible> extends JpaRepository<T, Long>{

}
