package ar.task.scheduler.models;

import java.util.ArrayList;
import java.util.List;

import ar.task.scheduler.exceptions.ExistingAddException;
import ar.task.scheduler.exceptions.UnexistingRemoveException;

public class Administrador extends Usuario {

	private List<Usuario>usuarios;
	
	Administrador() {}
	
	 public Administrador(String email, String contrasenia, String nombre, String apellido) {
		super(email,contrasenia,nombre,apellido);
		this.usuarios = new ArrayList<Usuario>();
		super.convertirEnAdmin();
	}
	
	public void agregarUsuario(String email,String nombre, String apellido) {
		if(buscarUsuario(email)!=null) {
			throw new ExistingAddException();
		}
		this.usuarios.add(new Usuario(email,nombre,apellido));			
	}
	
	private Usuario buscarUsuario(String email) {
	    return usuarios.stream()
	            .filter(usuario -> usuario.mismoEmail(email))
	            .findFirst()
	            .orElse(null);
	}


	public void eliminarUsuario(String email) {
		Usuario user = this.buscarUsuario(email);
		if (user==null) {
			throw new UnexistingRemoveException();
		}
		usuarios.remove(user);
		
	}
	
	
	
	
	

	
	
	
	

	
	
	
	
	
}
