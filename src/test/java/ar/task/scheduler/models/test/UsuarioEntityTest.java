package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ar.task.scheduler.helpers.UsuarioHelperTest;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioEntityTest {

	
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
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioEmailVacio());
		}
		
		@Test
		public  void testCrearUsuarioEmailNulo() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioEmailNulo());
		}
		
		@Test
		public  void testCrearUsuarioEmailFormatoInvalido() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioEmailFormatoInvalido());
		}
		
		@Test
		public  void testCrearUsuarioEmailCantCaracteresInvalido() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioEmailCantCaracteresInvalido());
		}
		
		// CONTRASEÑA INVALIDA
		@Test
		public  void testCrearUsuarioContraseniaVacia() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioContraseniaVacia());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaNula() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioContraseniaNula());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaCantCaracteresInvalido() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioContraseniaCantCaracteresInvalido());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaSinMayuscula() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioContraseniaSinMayuscula());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaSinNumero() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioContraseniaSinNumero());
		}
		
		@Test
		public  void testCrearUsuarioContraseniaSinEspecial() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioContraseniaSinEspecial());
		}
		
		// NOMBRE INVALIDO
		@Test
		public  void testCrearUsuarioNombreVacio() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioNombreVacio());
		}
		
		@Test
		public  void testCrearUsuarioNombreNulo() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioNombreNulo());
		}
		
		@Test
		public  void testCrearUsuarioNombreMinCantidadCaracteres() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioNombreMinCantidadCaracteres());
		}
		
		@Test
		public  void testCrearUsuarioNombreMaxCantidadCaracteres() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioNombreMaxCantidadCaracteres());
		}
		
		// APELLIDO INVALIDO
		@Test
		public  void testCrearUsuarioApellidoVacio() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioApellidoVacio());
		}
		
		@Test
		public  void testCrearUsuarioApellidoNulo() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioApellidoNulo());
		}
		
		@Test
		public  void testCrearUsuarioApellidoMinCantidadCaracteres() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioApellidoMinCantidadCaracteres());
		}
		
		@Test
		public  void testCrearUsuarioApellidoMaxCantidadCaracteres() {
			assertThrows(Exception.class, () -> UsuarioHelperTest.crearUsuarioApellidoMaxCantidadCaracteres());
		}
	
	
}
