package ar.task.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.TaskNotFoundException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;
import ar.task.scheduler.exceptions.UserNotFoundException;
import ar.task.scheduler.models.Tarea;
import ar.task.scheduler.models.Usuario;
import ar.task.scheduler.repositories.TareaRepository;
import ar.task.scheduler.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository<Usuario>usuarioRepository;
	@Autowired
	private TareaRepository tareaRepository;
	
	
	
	public Usuario buscarUsuario (String email){
		return this.usuarioRepository.findByEmail(email);
	}
	
	public void guardarUsuario(Usuario usuario) {
		if(usuario != null && this.buscarUsuario(usuario.getEmail())!=null) {
			throw new ExistingAddException();
		}
		this.usuarioRepository.save(usuario);			
	}
	
	public void eliminarUsuario(Usuario usuario) {
		if(usuario != null && this.buscarUsuario(usuario.getEmail())==null) {
			throw new UnexistingRemoveException();
		}
		this.usuarioRepository.delete(usuario);
	}
	
	
	
	
	//TODO Verificar con M
	public void agregarTareaAUsuario(String usuarioEmail, Tarea tarea) {
	    Usuario usuario = this.usuarioRepository.findByEmail(usuarioEmail);
	            if(usuario==null) {
	            	throw new UserNotFoundException();
	            }

	            boolean tieneLaTarea = usuario.getTareasUnmodifiableList().stream().anyMatch(t -> t.mismaTarea(tarea));
	            if (!tieneLaTarea) {
	                throw new TaskNotFoundException();
	            }

	    Tarea tareaGuardada = tareaRepository.save(tarea); // primero persistir la tarea
	    usuario.agregarTarea(tareaGuardada);               // asociarla
	    usuarioRepository.save(usuario);                    // persistir la relación
	}

	
	public void eliminarTareaAUsuario(String usuarioEmail,Tarea tarea) {
		 Usuario usuario = this.usuarioRepository.findByEmail(usuarioEmail);
         if(usuario==null) {
         	throw new UserNotFoundException();
         }

         boolean tieneLaTarea = usuario.getTareasUnmodifiableList().stream().anyMatch(t -> t.mismaTarea(tarea));
         if (!tieneLaTarea) {
             throw new TaskNotFoundException();
         }
         
        usuario.eliminarTarea(tarea);               // disasociarla
        tareaRepository.delete(tarea);             // elimino la tarea de la tabla
 	    usuarioRepository.save(usuario);           // persistir la relación
         
	}
	
	
}
