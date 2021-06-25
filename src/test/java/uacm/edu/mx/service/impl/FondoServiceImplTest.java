package uacm.edu.mx.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.model.Direccion;
import uacm.edu.mx.service.IFondoService;

@Slf4j
@SpringBootTest
class FondoServiceImplTest {

	@Autowired
	private IFondoService fondoService;

	@Test
	void testCreateFondo() {

		Direccion direccion = new Direccion();
		direccion.setIdDireccion(1L);
		direccion.setCalle("Calle");
		direccion.setColonia("Colonia");
		direccion.setCodPostal("01120");
		direccion.setDelegacion("Delegacion");
		direccion.setCiudad("Ciudad");

		FondoRequest fondoRequest = new FondoRequest();
		fondoRequest.setNombre("FondoTest");
		fondoRequest.setTelefono("1234567890");
		fondoRequest.setDireccion(direccion);

		FondoResponse fondoResponse = fondoService.createFondo(fondoRequest);

		log.debug(fondoResponse.toString());
		assertThat(fondoResponse, is(notNullValue()));

	}

	@Test
	void testGetAllFondo() {
		List<FondoResponse> lista = fondoService.getAllFondo();
		log.debug(lista.toString());
	}

	@Test
	void testGetFondoById() {
		
		FondoResponse fondoResp = fondoService.getFondoById(1L);
		assertEquals(1L, fondoResp.getId());
		assertEquals("Test3", fondoResp.getNombre());

	}

	@Test
	void testUpdateFondo() {
		
				Direccion direccion = new Direccion();
				direccion.setIdDireccion(1L);
				direccion.setCalle("Calle");
				direccion.setColonia("Colonia");
				direccion.setCodPostal("01120");
				direccion.setDelegacion("Delegacion");
				direccion.setCiudad("Ciudad");

				FondoRequest fondoRequest = new FondoRequest();
				fondoRequest.setNombre("FondoTest");
				fondoRequest.setTelefono("1234567890");
				fondoRequest.setDireccion(direccion);
				// when
				FondoResponse fondoResp = fondoService.updateFondo(fondoRequest, 1L);
				// then
				assertEquals(1L, fondoResp.getId());

	}

}
