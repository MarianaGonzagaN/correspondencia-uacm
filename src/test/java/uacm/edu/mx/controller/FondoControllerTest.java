package uacm.edu.mx.controller;

import static org.junit.jupiter.api.Assertions.*;
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
class FondoControllerTest {
	
	private static String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJtYXJ0aW5leiIsImlhdCI6MTYyMTU0MDAyOCwiZXhwIjoxODIzMDgwMDI4fQ.WETdCPUPrBs9RkNNHP9snbuAvw_4KTAkEexd0MJ4Lx4FhGiLZh8p6gFhYZDulJa01P8m8ITWk1jjNIpso0rESeN9SLLSnYQ1C3z38sJaCjqhSW71krwPrObtby_ZQub7sPnGXkr-WCIUC38pRdGUwD2XnCiBMceJAjZkdY0ux8X2xWBBv5u9UToiUIlfIy0KXiZpvJ9Q9JLiABGu7BEl2E34RGnXbOf_MYntiYAChPsD1aja3s3jzi8CCSv-YGQJFb4LZYyLV38grkTcH7rZhu_7f344PoJAuDKJqZe9GyjIWTyYKLLvF0dncuS69oUHGopXK8LEfqCO_hLosazlCA";
	@Autowired
    private MockMvc mvc;

	@Test
	void testCreateFondo() throws Exception {
		
				mvc.perform( MockMvcRequestBuilders.post("/api/fondo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \" nombre \"  :  \"CatalogoController \"  , "
						+ "\"telefono\": \"5521551100\","
						+ "\"fechaCreacion\": \"2021-05-30\","
						+ "\"direccion\": {\r\n" + 
						"        \"calle\": \"x\",\r\n" + 
						"        \"colonia\": \"y\" ,\r\n" + 
						"        \"codPostal\": \"09360\",\r\n" + 
						"        \"delegacion\": \"Iztapalapa\" ,\r\n" + 
						"        \"ciudad\": \"CDMX\"\r\n" + 
						"    }} ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}

	@Test
	void testGetAllFondo() throws Exception {
		
		mvc.perform( MockMvcRequestBuilders.get("/api/fondo")
				.header("Authorization", "Bearer " + token)).andExpect(status().isOk());

	}

	@Test
	void testGetFondo() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/api/fondo/1")
				.header("Authorization", "Bearer " + token)).andExpect(status().isOk());
	}

	@Test
	void testUpdateFondo() throws Exception {
		
		mvc.perform( MockMvcRequestBuilders.put("/api/fondo/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(" { \"id\": 52,\r\n" + 
						"    \"nombre\": \"UACM-SLT-COORDINACION\",\r\n" + 
						"    \"telefono\": \"1\",\r\n" + 
						"    \"fechaCreacion\": 1623733200000,\r\n" + 
						"    \"direccion\": {\r\n" + 
						"        \"idDireccion\": 3,\r\n" + 
						"        \"calle\": \"x\",\r\n" + 
						"        \"colonia\": \"x\",\r\n" + 
						"        \"codPostal\": \"01121\",\r\n" + 
						"        \"delegacion\": \"IZTAPALAPA\",\r\n" + 
						"        \"ciudad\": \"CDMX\"\r\n" + 
						"    } } ") 
				.header("Authorization", "Bearer " + token)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}

}
