package ar.task.scheduler.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.models.helpers.CategoriaHelperTest;
import ar.task.scheduler.services.CategoriaService;

@SpringBootTest
@ActiveProfiles("test")
public class CategoriaServiceTest {

	@Autowired
	private CategoriaService servicio;
	
	@Test
	public void saveCategoriaSuccess() {
		this.servicio.agregarCategoria(CategoriaHelperTest.crearCategoriaValida().getNombre());
	}
	
	@Test
	public void deleteCategoriaSuccess() {
		this.servicio.eliminarCategoria(CategoriaHelperTest.crearCategoriaValida().getNombre());
	}
	
}
