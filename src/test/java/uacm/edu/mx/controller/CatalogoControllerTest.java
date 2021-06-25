package uacm.edu.mx.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class CatalogoControllerTest {
	
	private static String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJtYXJ0aW5leiIsImlhdCI6MTYyMTU0MDAyOCwiZXhwIjoxODIzMDgwMDI4fQ.WETdCPUPrBs9RkNNHP9snbuAvw_4KTAkEexd0MJ4Lx4FhGiLZh8p6gFhYZDulJa01P8m8ITWk1jjNIpso0rESeN9SLLSnYQ1C3z38sJaCjqhSW71krwPrObtby_ZQub7sPnGXkr-WCIUC38pRdGUwD2XnCiBMceJAjZkdY0ux8X2xWBBv5u9UToiUIlfIy0KXiZpvJ9Q9JLiABGu7BEl2E34RGnXbOf_MYntiYAChPsD1aja3s3jzi8CCSv-YGQJFb4LZYyLV38grkTcH7rZhu_7f344PoJAuDKJqZe9GyjIWTyYKLLvF0dncuS69oUHGopXK8LEfqCO_hLosazlCA";
	@Autowired
    private MockMvc mvc;
	

	@Test
	void testCreateCatalogo() throws Exception {
		
		mvc.perform( MockMvcRequestBuilders.post("/api/catalogo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoController \"  } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateCatalogo() throws Exception {
		mvc.perform( MockMvcRequestBuilders.put("/api/catalogo/41")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoControllerUpdate\"  } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteCatalogo() throws Exception {
		
		mvc.perform( MockMvcRequestBuilders.delete("/api/catalogo/40")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoControllerUpdate\"  } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testCreateValorCatalogo() throws Exception {
		
		mvc.perform( MockMvcRequestBuilders.post("/api/catalogo/1/valor")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoControllerValor\" ,   \"descripcion\":\"CatalogoControllerValor\" } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testGetAllCatalogo() throws Exception {
			
		mvc.perform(MockMvcRequestBuilders.get("/api/catalogo")
				.header("Authorization", "Bearer " + token)).andExpect(status().isOk());
	}

	@Test
	void testGetAllCatalogoValores() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/catalogo/all")
				.header("Authorization", "Bearer " + token)).andExpect(status().isOk());
	}

	@Test
	void testGetCatalogo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/catalogo/1")
				.header("Authorization", "Bearer " + token)).andExpect(status().isOk());
	}

	@Test
	void testGetCatalogoByNombre() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/catalogo/valores/Catalogo")
				.header("Authorization", "Bearer " + token)).andExpect(status().isOk());
	}

	@Test
	void testUpdateCatalogoValor() throws Exception {
		mvc.perform( MockMvcRequestBuilders.put("/api/catalogo/valor/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoControllerValorUpdate\" ,   \"descripcion\":\"CatalogoControllerValorUpdate\" } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteCatalogoValor() throws Exception {
		mvc.perform( MockMvcRequestBuilders.delete("/api/catalogo/valor/20")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoControllerUpdate\"  } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
