package ar.task.scheduler.services.test;

import ar.task.scheduler.models.Administrador;
import ar.task.scheduler.models.helpers.AdministradorHelperTest;

public class AdministradorServiceTest extends UserArtifactServiceTest<Administrador>{

	@Override
	protected Administrador crearEntidadValida() {
		return AdministradorHelperTest.crearUserValido();
	}

}
