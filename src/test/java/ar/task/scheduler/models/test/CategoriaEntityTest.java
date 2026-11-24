package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.models.helpers.CategoriaHelperTest;

public class CategoriaEntityTest extends BaseEntityTest{

	@Test
	public void testCrearCategoriaValida() {
		assertDoesNotThrow(()-> CategoriaHelperTest.crearEntidadValida());
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
