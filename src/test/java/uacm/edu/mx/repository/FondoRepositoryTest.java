package uacm.edu.mx.repository;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uacm.edu.mx.model.Direccion;
import uacm.edu.mx.model.Fondo;

@DataJpaTest
class FondoRepositoryTest {
	
	@Autowired
	FondoRepository fondoRepository;


	@Test
	void testFindAll() {
		 List<Fondo> cuentas = fondoRepository.findAll();
	        assertFalse(cuentas.isEmpty());
	        assertEquals(1, cuentas.size());
		
	}

	@Test
	void testSave() {
		
		Direccion direccion = new Direccion();
		direccion.setIdDireccion(1L);
		direccion.setCalle("Calle");
		direccion.setColonia("Colonia");
		direccion.setCodPostal("01120");
		direccion.setDelegacion("Delegacion");
		direccion.setCiudad("Ciudad");

		Fondo fondo = new Fondo();
		fondo.setNombre("FondoTest");
		fondo.setTelefono("1234567890");
		fondo.setDireccion(direccion);
		
		fondoRepository.save(fondo);

		assertEquals("FondoTest", fondo.getNombre());
		
	}

	@Test
	void testFindById() {
		Optional<Fondo> fondo = fondoRepository.findById(2L);
		assertTrue(fondo.isPresent());
		assertEquals("FondoTest", fondo.get().getNombre());
		
	}

}
