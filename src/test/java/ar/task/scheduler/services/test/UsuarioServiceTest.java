package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Usuario;
import ar.task.scheduler.models.helpers.UsuarioHelperTest;

//TODO Probar los tests de servicios.
public class UsuarioServiceTest extends UserArtifactServiceTest<Usuario>{

	@Override
	protected Usuario crearEntidadValida() {
		return UsuarioHelperTest.crearUserValido();
	}

}
