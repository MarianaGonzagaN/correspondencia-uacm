package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.service.IFondoService;

@RestController
@RequestMapping(value = "/api/fondo")
public class FondoController {
	
	
	private final IFondoService fondoService;
	
	@Autowired
	public FondoController(IFondoService fondoService) {
		super();
		this.fondoService = fondoService;
	}
	
	@PostMapping
	public ResponseEntity<FondoResponse> createFondo(@RequestBody final FondoRequest fondoRequest) {
		return ResponseEntity.status(OK).body(fondoService.createFondo(fondoRequest));
	}
	
	@GetMapping()
	public ResponseEntity<List<FondoResponse>> getAllFondo() {
		return ResponseEntity.status(OK).body(fondoService.getAllFondo());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FondoResponse> getFondo(@PathVariable("id") final Long id) {
		return ResponseEntity.status(OK).body(fondoService.getFondoById(id));
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<FondoResponse> updateFondo(@RequestBody final FondoRequest fondoRequest,
			@PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(fondoService.updateFondo(fondoRequest, id));
	}


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}
