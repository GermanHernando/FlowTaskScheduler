package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Tarea;
import ar.task.scheduler.models.helpers.TareaHelperTest;
import ar.task.scheduler.services.TareaService;



public class TareaServiceTest extends PlantillaServiceTest<Tarea, TareaService> {

	@Override
	protected T crearEntidadValida() {
		return TareaHelperTest.crearEntidadValida();
	}

}
