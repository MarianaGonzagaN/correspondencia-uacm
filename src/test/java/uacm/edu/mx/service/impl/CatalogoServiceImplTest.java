package uacm.edu.mx.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.service.ICatalogoService;

@Slf4j
@SpringBootTest
class CatalogoServiceImplTest {

	@Autowired
	private ICatalogoService catService;

	@Test
	void testCreateCatalogo() {
		// given
		CatalogoRequest cat = new CatalogoRequest("CatalogoServiceTest");

		// when
		CatalogoResponse catResp = catService.createCatalogo(cat);

		// then
		log.debug(catResp.toString());

		assertThat(catResp, is(notNullValue()));

	}

	@Test
	void testUpdate() {

		// given
		CatalogoRequest cat = new CatalogoRequest();
		cat.setNombre("Test3");

		// when
		CatalogoResponse catResp = catService.update(cat, 5L);

		// then
		assertEquals(1L, catResp.getId()); //
		assertEquals("Test3", catResp.getNombre());

		// fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCatalogo() {

		// given
		CatalogoResponse catResp = catService.getCatalogo(1L);

		// when

		// then

		assertEquals(1L, catResp.getId());
		assertEquals("Test3", catResp.getNombre());
		// fail("Not yet implemented");
	}

	@Test
	void testGetAllCatalogo() {

		List<CatalogoResponse> lista = catService.getAllCatalogo();

		// fail("Not yet implemented");
	}

	@Test
	void testGetAllCatalogosValores() {

		List<CatalogoResponse> lista = catService.getAllCatalogosValores();
		// fail("Not yet implemented");
	}

	@Test
	void testAddValorCatalogo() {

		// given
		CatalogoValorRequest catValorReq = new CatalogoValorRequest();
		catValorReq.setNombre("CatVatTest-1");
		catValorReq.setDescripcion("CatVatTest-1");

		// when
		CatalogoResponse catResp = catService.addValorCatalogo(catValorReq, 1L);

		// then
		assertNotNull(catValorReq);
		assertEquals(1L, catResp.getId());

		// fail("Not yet implemented");
	}

	@Test
	void testUpdateValorCatalogo() {

		// given
		CatalogoValorRequest catalogoValorRequest = new CatalogoValorRequest();
		catalogoValorRequest.setNombre("CatValTest-1");
		// when
		CatalogoResponse catResp = catService.updateValorCatalogo(catalogoValorRequest, 1L);
		// then
		assertEquals(1L, catResp.getId());
		// fail("Not yet implemented");
	}

	@Test
	void testDeleteValorCatalogo() {
		// given
		// when
		catService.deleteValorCatalogo(1L);
		// then

		// fail("Not yet implemented");
	}

}
