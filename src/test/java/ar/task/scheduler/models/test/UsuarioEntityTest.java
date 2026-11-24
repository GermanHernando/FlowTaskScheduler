package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.models.helpers.UsuarioHelperTest;


public class UsuarioEntityTest extends BaseEntityTest {

	
	//VALIDO
	@Test
	public  void testcrearUserValido() {
		assertDoesNotThrow(() -> UsuarioHelperTest.crearUserValido());
	}

	
	//INVALIDO
	
	// EMAIL INVALIDO
		@Test
		public  void testcrearUserEmailVacio() {
			assertThrows(UserEmailException.class, () -> UsuarioHelperTest.crearUserEmailVacio());
		}
		
		@Test
		public  void testcrearUserEmailNulo() {
			assertThrows(UserEmailException.class, () -> UsuarioHelperTest.crearUserEmailNulo());
		}
		
		@Test
		public  void testcrearUserEmailFormatoInvalido() {
			assertThrows(UserEmailException.class, () -> UsuarioHelperTest.crearUserEmailFormatoInvalido());
		}
		
		@Test
		public  void testcrearUserEmailCantCaracteresInvalido() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUserEmailCantCaracteresInvalido());
		}
		
		
		// NOMBRE INVALIDO
		@Test
		public  void testcrearUserNombreVacio() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUserNombreVacio());
		}
		
		@Test
		public  void testcrearUserNombreNulo() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUserNombreNulo());
		}
		
		@Test
		public  void testcrearUserNombreMinCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUserNombreMinCantidadCaracteres());
		}
		
		@Test
		public  void testcrearUserNombreMaxCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUserNombreMaxCantidadCaracteres());
		}
		
		// APELLIDO INVALIDO
		@Test
		public  void testcrearUserApellidoVacio() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUserApellidoVacio());
		}
		
		@Test
		public  void testcrearUserApellidoNulo() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUserApellidoNulo());
		}
		
		@Test
		public  void testcrearUserApellidoMinCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUserApellidoMinCantidadCaracteres());
		}
		
		@Test
		public  void testcrearUserApellidoMaxCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUserApellidoMaxCantidadCaracteres());
		}
	
	
}
