package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.models.helpers.CategoriaHelperTest;
@SpringBootTest
@ActiveProfiles(value = "test")
public class CategoriaEntityTest {

	@Test
	public void testCrearCategoriaValida() {
		assertDoesNotThrow(()-> CategoriaHelperTest.crearCategoriaValida());
	}
	
	//NOMBRE INVALIDO
	@Test
	public  void testCrearCategoriaVacia() {
		assertThrows(IllegalArgumentException.class, () -> CategoriaHelperTest.crearCategoriaNombreVacio());
	}
	
	@Test
	public  void testCrearCategoriaNombreNulo() {
		assertThrows(IllegalArgumentException.class, () -> CategoriaHelperTest.crearCategoriaNombreNulo());
	}
	
	@Test
	public  void testCrearCategoriaNombreMinCantidadCaracteres() {
		assertThrows(QuantityCharactersException.class, () -> CategoriaHelperTest.crearCategoriaNombreMinCantidadCaracteres());
	}
	
	@Test
	public  void testCrearCategoriaNombreMaxCantidadCaracteres() {
		assertThrows(QuantityCharactersException.class, () -> CategoriaHelperTest.crearCategoriaNombreMaxCantidadCaracteres());
	}

}
