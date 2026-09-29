package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Plantilla;
import ar.task.scheduler.models.helpers.PlantillaHelperTest;
import ar.task.scheduler.services.PlantillaService;

public class PlantillaServiceTest<T extends Plantilla>  extends BaseServiceTest<T, PlantillaService<T>> {

	@Override
	protected T crearEntidadValida() {
		return (T) PlantillaHelperTest.crearEntidadValida();
	}
	
}
