package ar.task.scheduler.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.AdminNotFoundException;
import ar.task.scheduler.models.Administrador;
import ar.task.scheduler.models.Tarea;
import ar.task.scheduler.repositories.AdministradorRepository;

@Service
public class AdministradorServiceImp extends UsuarioServiceImp<Administrador> implements AdministradorService {

	// Recordar que métodos para agregar o eliminar admin o usuario son heredados de UsuarioService
	

	@Autowired
	private AdministradorRepository adminRepository;
	
	
	public void guardarPlantilla(Administrador admin, Tarea tarea) {
		Administrador ad = this.buscarUsuario(admin.getEmail());
		if (ad == null) {
			throw new AdminNotFoundException();
		}
		ad.agregarPlantillaTarea(tarea);
		adminRepository.save(ad);
	}

	public void eliminarPlantilla(Administrador admin, Tarea tarea) {
		Administrador ad = this.buscarUsuario(admin.getEmail());
		if (ad == null) {
			throw new AdminNotFoundException();
		}
		ad.eliminarPlantillaTarea(tarea.getTitulo());
		adminRepository.save(ad);
	}
	
	public void agregarTareaAUsuario(String adminEmail, String usuarioEmail, Tarea tarea) {
		  Administrador ad = this.buscarUsuario(adminEmail);
		    if (ad == null) {
		        throw new AdminNotFoundException();
		    }

		ad.agregarTareaAUsuario(usuarioEmail,tarea); 	// asociarla
		adminRepository.save(ad); 						// persistir la relación
	}

	public void eliminarTareaAUsuario(String adminEmail, String usuarioEmail, Tarea tarea) {
		  Administrador ad = this.buscarUsuario(adminEmail);
		    if (ad == null) {
		        throw new AdminNotFoundException();
		    }

		ad.eliminarTareaAUsuario(usuarioEmail,tarea); 	// disasociarla
		adminRepository.save(ad); 						// persistir la relación

	}

}
