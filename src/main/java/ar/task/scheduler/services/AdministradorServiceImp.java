package ar.task.scheduler.services;

import org.springframework.stereotype.Service;

import ar.task.scheduler.exceptions.AdminNotFoundException;
import ar.task.scheduler.models.Administrador;
import ar.task.scheduler.models.Plantilla;
import ar.task.scheduler.models.Tarea;

@Service
public class AdministradorServiceImp extends UsuarioServiceImp<Administrador> implements AdministradorService {

	
	
	public void guardarPlantilla(Administrador admin, Plantilla plantilla) {
		Administrador ad = this.buscarUsuario(admin.getEmail());
		if (ad == null) {
			throw new AdminNotFoundException();
		}
		ad.agregarPlantilla(plantilla);
		repository().save(ad);
	}

	public void eliminarPlantilla(Administrador admin, Plantilla plantilla) {
		Administrador ad = this.buscarUsuario(admin.getEmail());
		if (ad == null) {
			throw new AdminNotFoundException();
		}
		ad.eliminarPlantilla(plantilla.getTitulo());
		repository().save(ad);
	}
	
	public void agregarTareaAUsuario(String adminEmail, String usuarioEmail, Tarea tarea) {
		  Administrador ad = this.buscarUsuario(adminEmail);
		    if (ad == null) {
		        throw new AdminNotFoundException();
		    }

		ad.agregarTareaAUsuario(usuarioEmail,tarea); 	// asociarla
		repository().save(ad); 						// persistir la relación
	}

	public void eliminarTareaAUsuario(String adminEmail, String usuarioEmail, Tarea tarea) {
		  Administrador ad = this.buscarUsuario(adminEmail);
		    if (ad == null) {
		        throw new AdminNotFoundException();
		    }

		ad.eliminarTareaAUsuario(usuarioEmail,tarea); 	// disasociarla
		repository().save(ad); 						// persistir la relación

	}

}
