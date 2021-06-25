package uacm.edu.mx.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.Direccion;
import uacm.edu.mx.model.Fondo;


class FondoMapperTest {
	
	@Autowired
	FondoMapper fondoMapper;

	@Test
	void testDataToEntity() {
		
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

				Fondo fondo = fondoMapper.dataToEntity(fondoRequest);

				assertEquals(1L, fondo.getDireccion().getIdDireccion());
				assertEquals("FondoTest", fondo.getNombre());
	}

	@Test
	void testEntityToData() {

		        FondoResponse fondoResponse = new FondoResponse();
				Direccion direccion = new Direccion();
				direccion.setIdDireccion(2L);
				direccion.setCalle("Calle2");
				direccion.setColonia("Colonia2");
				direccion.setCodPostal("01121");
				direccion.setDelegacion("Delegacion2");
				direccion.setCiudad("Ciudad2");
	
				Fondo fondo = new Fondo();
				fondo.setNombre("FondoTest2");
				fondo.setTelefono("1234567891");
				fondo.setDireccion(direccion);
				
				fondoResponse = fondoMapper.EntityToData(fondo);
				
				assertEquals("FondoTest2", fondoResponse.getNombre());
				assertEquals(2L, fondoResponse.getDireccion().getIdDireccion());
	}

	

}
