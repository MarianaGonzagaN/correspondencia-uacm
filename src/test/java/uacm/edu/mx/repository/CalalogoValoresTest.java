package uacm.edu.mx.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.repository.CatalogoRepository;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@Sql({"/import.sql"})
public class CalalogoValoresTest {

	
	@Autowired
	CatalogoRepository catalogoRepository;


	 @Test
	    void testFindAll() {
	        List<Catalogo> cuentas = catalogoRepository.findAll();
	        assertFalse(cuentas.isEmpty());
	        assertEquals(1, cuentas.size());
	}
	 
	 
	@Test
    void testSave() {
        // Given
        Catalogo catalogo = new Catalogo ("Catalogo Test");

        // When
        Catalogo catalogoT = catalogoRepository.save(catalogo);
        // Then
        assertEquals("Catalogo Test", catalogo.getNombre());
    }
	
	 @Test
		void findById() {
			Optional<Catalogo> catalogo = catalogoRepository.findById(2L);
			assertTrue(catalogo.isPresent());
			assertEquals("Catalogo Sección", catalogo.get().getNombre());
		}
	
	
	
	
	 

}
