package uacm.edu.mx.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.model.Catalogo;


@Slf4j
@DataJpaTest
class CatalogoRepositoryTest {
	
	@Autowired
	CatalogoRepository catalogoRepository;

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		  // Given
        Catalogo catalogo = new Catalogo ("CatalogoTestRepository");

        // When
        Catalogo catalogoSave = catalogoRepository.save(catalogo);
        log.debug(catalogoSave.toString());
        // Then
        assertEquals("CatalogoTestRepository", catalogoSave.getNombre());
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testExistsById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll1() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
