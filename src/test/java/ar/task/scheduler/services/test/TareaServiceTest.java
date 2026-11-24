package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Tarea;
import ar.task.scheduler.models.helpers.TareaHelperTest;

public class TareaServiceTest extends ItemArtifactServiceTest<Tarea> {

	@Override
	protected Tarea crearEntidadValida() {
		return TareaHelperTest.crearEntidadValida();
	}

}
