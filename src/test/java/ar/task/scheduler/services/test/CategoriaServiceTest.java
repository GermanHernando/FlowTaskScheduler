package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Categoria;
import ar.task.scheduler.models.helpers.CategoriaHelperTest;
import ar.task.scheduler.services.CategoriaService;

public class CategoriaServiceTest extends BaseServiceTest<Categoria, CategoriaService>{


	@Override
	protected Categoria crearEntidadValida() {
		return CategoriaHelperTest.crearEntidadValida();
	}
	
}
