package ar.task.scheduler.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.models.Persistible;
import ar.task.scheduler.services.CRUDService;

@SpringBootTest
@ActiveProfiles(value = "test")
public abstract class BaseServiceTest <T extends Persistible, S extends CRUDService<T>> {

	@Autowired
	private S servicio;
	
	@Test
	public void testGuardarEntidadExitosamente() {
		T entidad = crearEntidadValida();
		this.servicio.guardar(entidad);
	}
	
	@Test
	public void testEliminarEntidadExitosamente() {
		T entidad = crearEntidadValida();
		this.servicio.guardar(entidad);
		this.servicio.eliminar(entidad);
	}
	
	protected abstract T crearEntidadValida();
	
}
