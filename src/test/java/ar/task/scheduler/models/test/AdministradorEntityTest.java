package ar.task.scheduler.models.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.task.scheduler.exceptions.QuantityCharactersException;
import ar.task.scheduler.exceptions.UserEmailException;
import ar.task.scheduler.exceptions.UserPasswordException;
import ar.task.scheduler.models.helpers.AdministradorHelperTest;

public class AdministradorEntityTest extends BaseEntityTest {

	@Test
	public void testcrearUserValidoConContraseña() {
		assertDoesNotThrow(() -> AdministradorHelperTest.crearUserValido());
	}

	// INVALIDO

	// EMAIL INVALIDO
	@Test
	public void testcrearUserEmailVacio() {
		assertThrows(UserEmailException.class, () -> AdministradorHelperTest.crearUserEmailVacio());
	}

	@Test
	public void testcrearUserEmailNulo() {
		assertThrows(UserEmailException.class, () -> AdministradorHelperTest.crearUserEmailNulo());
	}

	@Test
	public void testcrearUserEmailFormatoInvalido() {
		assertThrows(UserEmailException.class, () -> AdministradorHelperTest.crearUserEmailFormatoInvalido());
	}

	@Test
	public void testcrearUserEmailCantCaracteresInvalido() {
		assertThrows(QuantityCharactersException.class,
				() -> AdministradorHelperTest.crearUserEmailCantCaracteresInvalido());
	}

	// CONTRASEÑA INVALIDA
	@Test
	public void testcrearUserContraseniaVacia() {
		assertThrows(UserPasswordException.class, () -> AdministradorHelperTest.crearUserContraseniaVacia());
	}

	@Test
	public void testcrearUserContraseniaNula() {
		assertThrows(UserPasswordException.class, () -> AdministradorHelperTest.crearUserContraseniaNula());
	}

	@Test
	public void testcrearUserContraseniaCantCaracteresInvalido() {
		assertThrows(QuantityCharactersException.class,
				() -> AdministradorHelperTest.crearUserContraseniaCantCaracteresInvalido());
	}

	@Test
	public void testcrearUserContraseniaSinMayuscula() {
		assertThrows(UserPasswordException.class, () -> AdministradorHelperTest.crearUserContraseniaSinMayuscula());
	}

	@Test
	public void testcrearUserContraseniaSinNumero() {
		assertThrows(UserPasswordException.class, () -> AdministradorHelperTest.crearUserContraseniaSinNumero());
	}

	@Test
	public void testcrearUserContraseniaSinEspecial() {
		assertThrows(UserPasswordException.class, () -> AdministradorHelperTest.crearUserContraseniaSinEspecial());
	}

	// NOMBRE INVALIDO
	@Test
	public void testcrearUserNombreVacio() {
		assertThrows(IllegalArgumentException.class, () -> AdministradorHelperTest.crearUserNombreVacio());
	}

	@Test
	public void testcrearUserNombreNulo() {
		assertThrows(IllegalArgumentException.class, () -> AdministradorHelperTest.crearUserNombreNulo());
	}

	@Test
	public void testcrearUserNombreMinCantidadCaracteres() {
		assertThrows(QuantityCharactersException.class,
				() -> AdministradorHelperTest.crearUserNombreMinCantidadCaracteres());
	}

	@Test
	public void testcrearUserNombreMaxCantidadCaracteres() {
		assertThrows(QuantityCharactersException.class,
				() -> AdministradorHelperTest.crearUserNombreMaxCantidadCaracteres());
	}

	// APELLIDO INVALIDO
	@Test
	public void testcrearUserApellidoVacio() {
		assertThrows(IllegalArgumentException.class, () -> AdministradorHelperTest.crearUserApellidoVacio());
	}

	@Test
	public void testcrearUserApellidoNulo() {
		assertThrows(IllegalArgumentException.class, () -> AdministradorHelperTest.crearUserApellidoNulo());
	}

	@Test
	public void testcrearUserApellidoMinCantidadCaracteres() {
		assertThrows(QuantityCharactersException.class,
				() -> AdministradorHelperTest.crearUserApellidoMinCantidadCaracteres());
	}

	@Test
	public void testcrearUserApellidoMaxCantidadCaracteres() {
		assertThrows(QuantityCharactersException.class,
				() -> AdministradorHelperTest.crearUserApellidoMaxCantidadCaracteres());
	}

}
