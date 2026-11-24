package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Plantilla;
import ar.task.scheduler.models.helpers.PlantillaHelperTest;

public class PlantillaServiceTest extends ItemArtifactServiceTest<Plantilla> {

	@Override
	protected Plantilla crearEntidadValida() {
		return  PlantillaHelperTest.crearEntidadValida();
	}
	
}
