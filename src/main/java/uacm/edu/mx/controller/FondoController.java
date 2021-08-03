package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.exception.FondoException;
import uacm.edu.mx.service.IFondoService;
import org.springframework.dao.DataAccessException;

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
	public ResponseEntity<?> createFondo(@Valid  @RequestBody final FondoRequest fondoRequest, BindingResult result) {
		
		FondoResponse fondoNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			 fondoNuevo = fondoService.createFondo(fondoRequest);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El fondo ha sido creado con éxito!");
		response.put("fondo", fondoNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<FondoResponse>> getAllFondo() {
		return ResponseEntity.status(OK).body(fondoService.getAllFondo());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getFondo(@PathVariable("id") final Long id) {

		FondoResponse fondoResponse = null;
		Map<String, Object> response = new HashMap<>();

		try {
			fondoResponse = fondoService.getFondoById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(fondoResponse == null) {
			response.put("mensaje", "El fondo con  ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<FondoResponse>(fondoResponse, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateFondo(@RequestBody final FondoRequest fondoRequest,
			@PathVariable("id") final Long id, BindingResult result) {
		
		FondoResponse fondoResponseActual = fondoService.getFondoById(id);

		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			System.out.println(errors);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (fondoResponseActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el Fondo con ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			return ResponseEntity.status(OK).body(fondoService.updateFondo(fondoRequest, id));
		}catch(DataAccessException e){
			response.put("mensaje", "Error al actualizar el fondo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}
