package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.exceptions.UserPasswordException;
import ar.task.scheduler.models.helpers.UsuarioHelperTest;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioEntityTest {

	
	//FIXME Reveer 2 test que fallan 
	
	//VALIDO
	@Test
	public  void testCrearUsuarioValidoSinContraseña() {
		assertDoesNotThrow(() -> UsuarioHelperTest.crearUsuarioValidoSinContrasenia());
	}

	@Test
	public  void testCrearUsuarioValidoConContraseña() {
		assertDoesNotThrow(() ->UsuarioHelperTest.crearUsuarioValidoConContrasenia());		
	}
	
	//INVALIDO
	
	// EMAIL INVALIDO
		@Test
		public  void testCrearUsuarioEmailVacio() {
			assertThrows(UserEmailException.class, () -> UsuarioHelperTest.crearUsuarioEmailVacio());
		}
		
		@Test
		public  void testCrearUsuarioEmailNulo() {
			assertThrows(UserEmailException.class, () -> UsuarioHelperTest.crearUsuarioEmailNulo());
		}
		
		@Test
		public  void testCrearUsuarioEmailFormatoInvalido() {
			assertThrows(UserEmailException.class, () -> UsuarioHelperTest.crearUsuarioEmailFormatoInvalido());
		}
		
		@Test
		public  void testCrearUsuarioEmailCantCaracteresInvalido() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUsuarioEmailCantCaracteresInvalido());
		}
		
		// CONTRASEÑA INVALIDA
		@Test
		public  void testCrearUsuarioContraseniaVacia() {
			assertThrows(UserPasswordException.class, () -> UsuarioHelperTest.crearUsuarioContraseniaVacia());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaNula() {
			assertThrows(UserPasswordException.class, () -> UsuarioHelperTest.crearUsuarioContraseniaNula());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaCantCaracteresInvalido() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUsuarioContraseniaCantCaracteresInvalido());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaSinMayuscula() {
			assertThrows(UserPasswordException.class, () -> UsuarioHelperTest.crearUsuarioContraseniaSinMayuscula());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaSinNumero() {
			assertThrows(UserPasswordException.class, () -> UsuarioHelperTest.crearUsuarioContraseniaSinNumero());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaSinEspecial() {
			assertThrows(UserPasswordException.class, () -> UsuarioHelperTest.crearUsuarioContraseniaSinEspecial());
		}
		
		// NOMBRE INVALIDO
		@Test
		public  void testCrearUsuarioNombreVacio() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUsuarioNombreVacio());
		}
		
		@Test
		public  void testCrearUsuarioNombreNulo() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUsuarioNombreNulo());
		}
		
		@Test
		public  void testCrearUsuarioNombreMinCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUsuarioNombreMinCantidadCaracteres());
		}
		
		@Test
		public  void testCrearUsuarioNombreMaxCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUsuarioNombreMaxCantidadCaracteres());
		}
		
		// APELLIDO INVALIDO
		@Test
		public  void testCrearUsuarioApellidoVacio() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUsuarioApellidoVacio());
		}
		
		@Test
		public  void testCrearUsuarioApellidoNulo() {
			assertThrows(IllegalArgumentException.class, () -> UsuarioHelperTest.crearUsuarioApellidoNulo());
		}
		
		@Test
		public  void testCrearUsuarioApellidoMinCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUsuarioApellidoMinCantidadCaracteres());
		}
		
		@Test
		public  void testCrearUsuarioApellidoMaxCantidadCaracteres() {
			assertThrows(QuantityCharactersException.class, () -> UsuarioHelperTest.crearUsuarioApellidoMaxCantidadCaracteres());
		}
	
	
}
