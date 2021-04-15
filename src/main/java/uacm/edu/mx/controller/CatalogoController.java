package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.service.ICatalogoService;

@RestController
@RequestMapping(value = "/catalogo")
public class CatalogoController {

	private final ICatalogoService catalogoService;

	@Autowired
	public CatalogoController(ICatalogoService catalogoService) {
		super();
		this.catalogoService = catalogoService;
	}

	@PostMapping
	public ResponseEntity<CatalogoResponse> createUser(@RequestBody final CatalogoRequest catalogoRequest) {

		return ResponseEntity.status(OK).body(catalogoService.createCatalogo(catalogoRequest));
	}

	@PostMapping("valor/{id}")
	public ResponseEntity<CatalogoResponse> createValorCatalogo(
			@RequestBody final CatalogoValorRequest catalogoValorRequest, @PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(catalogoService.addValorCatalogo(catalogoValorRequest, id));
	}

	@GetMapping
	public ResponseEntity<List<CatalogoResponse>> getAllUser() {

		return ResponseEntity.status(OK).body(catalogoService.getAllCatalogo());
	}
}
