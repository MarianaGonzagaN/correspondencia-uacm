package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.data.CatalogoValorResponse;
import uacm.edu.mx.exception.ApiError;
import uacm.edu.mx.exception.CatalogoException;
import uacm.edu.mx.service.ICatalogoService;
import uacm.edu.mx.service.ICatalogoValorService;

@RestController
@RequestMapping(value = "/api/catalogo")
public class CatalogoController {

	private final ICatalogoService catalogoService;
	private final ICatalogoValorService catalogoValorService;

	@Autowired
	public CatalogoController(ICatalogoService catalogoService, ICatalogoValorService catalogoValorService) {
		super();
		this.catalogoService = catalogoService;
		this.catalogoValorService = catalogoValorService;
	}

	@PostMapping
	public ResponseEntity<CatalogoResponse> createCatalogo(@RequestBody final CatalogoRequest catalogoRequest) {

		return ResponseEntity.status(OK).body(catalogoService.createCatalogo(catalogoRequest));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CatalogoResponse> updateCatalogo(@RequestBody final CatalogoRequest catalogoRequest,
			@PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(catalogoService.update(catalogoRequest, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCatalogo(@PathVariable("id") final Long id) {
		catalogoService.delete(id);
		return ResponseEntity.status(OK).body("Catalogo Borrado!!");
	}

	@PostMapping("/valorCatalogo/{id}")
	public ResponseEntity<CatalogoResponse> createValorCatalogo(
			@RequestBody final CatalogoValorRequest catalogoValorRequest, @PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(catalogoService.addValorCatalogo(catalogoValorRequest, id));
	}

	@GetMapping()
	public ResponseEntity<List<CatalogoResponse>> getAllCatalogo() {

		return ResponseEntity.status(OK).body(catalogoService.getAllCatalogo());
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CatalogoResponse>> getAllCatalogoValores() {

		return ResponseEntity.status(OK).body(catalogoService.getAllCatalogosValores());
	}


	@GetMapping("/{id}")
	public ResponseEntity<CatalogoResponse> getCatalogo(@PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(catalogoService.getCatalogo(id));
	}
	
	
	@GetMapping("/valores/{nombre}")
	public ResponseEntity<List<CatalogoValorResponse>> getCatalogoByNombre(@PathVariable("nombre") final String nombre) {
		return ResponseEntity.status(OK).body(catalogoValorService.getValoresCatalogoByNombre(nombre));
	}
	
	@PutMapping("/valor/{id}")
	public ResponseEntity<CatalogoResponse> updateCatalogoValor(@RequestBody final CatalogoValorRequest catalogoValorRequest,
			@PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(catalogoService.updateValorCatalogo(catalogoValorRequest, id));
	}
	
	@DeleteMapping("/valor/{id}")
	public ResponseEntity<String> deleteCatalogoValor(@PathVariable("id") final Long id) {
		catalogoService.deleteValorCatalogo(id);
		return ResponseEntity.status(OK).body("Valor Borrado!!");
	}
	
	
}
