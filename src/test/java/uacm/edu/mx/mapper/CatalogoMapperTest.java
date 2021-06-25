package uacm.edu.mx.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.data.CatalogoValorResponse;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;

@Slf4j
@SpringBootTest
class CatalogoMapperTest {

	@Autowired
	CatalogoMapper catalogoMapper;

	@Test
	void testDataToEntity() {

		// given
		CatalogoRequest catalogoRequest = new CatalogoRequest();
		catalogoRequest.setNombre("Test3");
		// when
		Catalogo catalogo = catalogoMapper.dataToEntity(catalogoRequest);

		// then //
		assertEquals("Test3", catalogo.getNombre());

		// fail("Not yet implemented");
	}

	@Test
	void testDataToEntityUpdate() {

		// given
		CatalogoRequest catRequest = new CatalogoRequest();
		catRequest.setNombre("Test5");

		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("Test3");

		// when
		catalogo = catalogoMapper.dataToEntityUpdate(catRequest, catalogo);

		// then //
		assertEquals("Test5", catalogo.getNombre());

		// fail("Not yet implemented");

	}

	@Test
	void testEntityToData() {

		// given
		CatalogoResponse catResponse = new CatalogoResponse();

		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("Test5");

		// when
		catResponse = catalogoMapper.EntityToData(catalogo);

		// then //
		assertEquals("Test5", catalogo.getNombre());

		// fail("Not yet implemented");
	}

	@Test
	void testDataValorToEntity() {
		// given
		CatalogoValores catalogoValores = new CatalogoValores();

		CatalogoValorRequest catalogoValorRequest = new CatalogoValorRequest();
		catalogoValorRequest.setNombre("");

		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("Test5");

		// when
		catalogoValores = catalogoMapper.dataValorToEntity(catalogoValorRequest, catalogo);

		// then //
		assertEquals("", catalogoValores.getNombre());

		// fail("Not yet implemented");
	}

	@Test
	void testDataValorToEntityUpdate() {
		
		// given
		CatalogoValores catalogoValores = new CatalogoValores();

		CatalogoValorRequest catalogoValorRequest = new CatalogoValorRequest();
		catalogoValorRequest.setNombre("");

		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("Test5");

		// when
		catalogoValores = catalogoMapper.dataValorToEntityUpdate(catalogoValorRequest, catalogoValores);

		// then //
		assertEquals("", catalogoValores.getNombre());

		// fail("Not yet implemented");
	}

	@Test
	void testEntityValorToData() {
				// given
				CatalogoValores catalogoValores = new CatalogoValores();
				catalogoValores.setNombre("");
				catalogoValores.setDescripcion("");
				
				CatalogoValorResponse  catalogoValorResponse = new CatalogoValorResponse();
	
				// when
				catalogoValorResponse = catalogoMapper.EntityValorToData(catalogoValores);

				// then //
				assertEquals("", catalogoValores.getNombre());

				// fail("Not yet implemented");
	}

	@Test
	void testCatalogoResponse() {
		// given
		CatalogoValores catalogoValores = new CatalogoValores();
		catalogoValores.setNombre("");
		catalogoValores.setDescripcion("");
		
		List  setCatalogoValores  = new ArrayList<>();
		
		Catalogo catalogo = new Catalogo();
		catalogo.setNombre("Test5");
		
		CatalogoResponse  catalogoResponse = new CatalogoResponse();

		// when
		catalogoResponse = catalogoMapper.catalogoResponse(catalogo,  setCatalogoValores);

		// then //
		assertEquals("", catalogoValores.getNombre());

		// fail("Not yet implemented");
	}

}
