package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.models.helpers.PlantillaHelperTest;

@SpringBootTest
@ActiveProfiles("test")
public class PlantillaEntityTest {

	//-------------------------
	//VALIDO
	//-------------------------
	
	
	@Test
	public void testCrearPlantillaValida() {
		assertDoesNotThrow(()-> PlantillaHelperTest.crearEntidadValida());
	}
	
	//-------------------------
	//INVALIDO
	//-------------------------
	
	//TITULO INVALIDO
	
	@Test
	public void testCrearPlantillaTituloVacio() {
		assertThrows(IllegalArgumentException.class, ()->PlantillaHelperTest.crearPlantillaTituloVacio());
	}
	
	@Test
	public void testCrearPlantillaTituloNulo() {
		assertThrows(IllegalArgumentException.class, 
				() -> PlantillaHelperTest.crearPlantillaTituloNulo());
	}

	@Test
	public void testCrearPlantillaTituloMinCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> PlantillaHelperTest.crearPlantillaTituloMinCantCaracteres());
	}

	@Test
	public void testCrearPlantillaTituloMaxCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> PlantillaHelperTest.crearPlantillaTituloMaxCantCaracteres());
	}


	// DESCRIPCION INVALIDA


	@Test
	public void testCrearPlantillaDescripcionVacia() {
		assertThrows(IllegalArgumentException.class, 
				() -> PlantillaHelperTest.crearPlantillaDescripcionVacia());
	}

	@Test
	public void testCrearPlantillaDescripcionNula() {
		assertThrows(IllegalArgumentException.class, 
				() -> PlantillaHelperTest.crearPlantillaDescripcionNula());
	}

	@Test
	public void testCrearPlantillaDescripcionMinCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> PlantillaHelperTest.crearPlantillaDescripcionMinCantCaracteres());
	}

	@Test
	public void testCrearPlantillaDescripcionMaxCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> PlantillaHelperTest.crearPlantillaDescripcionMaxCantCaracteres());
	}


	// CATEGORIA INVALIDA


	@Test
	public void testCrearPlantillaCategoriaVacia() {
		assertThrows(IllegalArgumentException.class, 
				() -> PlantillaHelperTest.crearPlantillaCategoriaVacia());
	}

	@Test
	public void testCrearPlantillaCategoriaNula() {
		assertThrows(IllegalArgumentException.class, 
				() -> PlantillaHelperTest.crearPlantillaCategoriaNula());
	}

	@Test
	public void testCrearPlantillaCategoriaMinCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> PlantillaHelperTest.crearPlantillaCategoriaMinCantCaracteres());
	}

	@Test
	public void testCrearPlantillaCategoriaMaxCantCaracteres() {
		assertThrows(QuantityCharactersException.class, 
				() -> PlantillaHelperTest.crearPlantillaCategoriaMaxCantCaracteres());
	}


}
