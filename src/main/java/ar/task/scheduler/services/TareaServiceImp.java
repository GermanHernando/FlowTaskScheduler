package ar.task.scheduler.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.models.Tarea;
import ar.task.scheduler.repositories.TareaRepository;

@Service
public class TareaServiceImp implements TareaService{

	@Autowired
	private TareaRepository tareaRepository;
	
	@Override
	public List<Tarea> buscarTarea(String titulo) {
		return tareaRepository.findByTitulo(titulo);
	}

	@Override
	public void guardarTarea(Tarea tarea) {
		List<Tarea> listaTareas = this.buscarTarea(tarea.getTitulo());
		if(!listaTareas.isEmpty() && esTareaExistente(listaTareas, tarea)) {
			throw new ExistingAddException();
		}
		this.tareaRepository.save(tarea);
	}
	
	private boolean esTareaExistente(List<Tarea> listaTareas, Tarea tarea) {
	    return listaTareas.stream().anyMatch(t -> t.mismaTarea(tarea));
	}

	@Override
	public void eliminarTarea(Tarea tarea) {
		if(tarea!=null && buscarTarea(tarea.getTitulo())==null) {
			throw new UnexistingRemoveException();
		}
		this.tareaRepository.delete(tarea);
	}

}
