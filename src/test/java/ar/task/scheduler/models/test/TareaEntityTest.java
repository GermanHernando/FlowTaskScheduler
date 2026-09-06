package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.models.helpers.TareaHelperTest;


@SpringBootTest
@ActiveProfiles("test")
public class TareaEntityTest {

	//-------------------------
	//VALIDO
	//-------------------------
	
	@Test
	public void testCrearTareaValidaSinFecha() {
		assertDoesNotThrow(()-> TareaHelperTest.crearTareaValidaSinFecha());
	}
	
	@Test
	public void testCrearTareaValidaConFecha() {
		assertDoesNotThrow(()-> TareaHelperTest.crearTareaValidaConFecha());
	}
	
	//-------------------------
	//INVALIDO
	//-------------------------
	
	//TITULO INVALIDO
	
	@Test
	public void testCrearTareaTituloVacio() {
		assertThrows(IllegalArgumentException.class, ()->TareaHelperTest.crearTareaTituloVacio());
	}
	
	@Test
	public void testCrearTareaTituloNulo() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaTituloNulo());
	}

	@Test
	public void testCrearTareaTituloMinCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> TareaHelperTest.crearTareaTituloMinCantCaracteres());
	}

	@Test
	public void testCrearTareaTituloMaxCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> TareaHelperTest.crearTareaTituloMaxCantCaracteres());
	}


	// DESCRIPCION INVALIDA


	@Test
	public void testCrearTareaDescripcionVacia() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaDescripcionVacia());
	}

	@Test
	public void testCrearTareaDescripcionNula() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaDescripcionNula());
	}

	@Test
	public void testCrearTareaDescripcionMinCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> TareaHelperTest.crearTareaDescripcionMinCantCaracteres());
	}

	@Test
	public void testCrearTareaDescripcionMaxCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> TareaHelperTest.crearTareaDescripcionMaxCantCaracteres());
	}


	// CATEGORIA INVALIDA


	@Test
	public void testCrearTareaCategoriaVacia() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaCategoriaVacia());
	}

	@Test
	public void testCrearTareaCategoriaNula() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaCategoriaNula());
	}

	@Test
	public void testCrearTareaCategoriaMinCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> TareaHelperTest.crearTareaCategoriaMinCantCaracteres());
	}

	@Test
	public void testCrearTareaCategoriaMaxCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> TareaHelperTest.crearTareaCategoriaMaxCantCaracteres());
	}


	// FECHA INVALIDA


	@Test
	public void testCrearTareaFechaNula() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaFechaNula());
	}

	@Test
	public void testCrearTareaFechaAnterior() {
		assertThrows(IllegalArgumentException.class, 
				() -> TareaHelperTest.crearTareaFechaAnterior());
	}

}
	
	
