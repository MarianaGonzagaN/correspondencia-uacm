package uacm.edu.mx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.service.IExpedienteService;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/api/expediente")
public class ExpedienteController {

	private final Logger logger = LoggerFactory.getLogger(ExpedienteController.class);

	private final IExpedienteService expedienteService;

	@Autowired
	public ExpedienteController(IExpedienteService expedienteService) {
		this.expedienteService = expedienteService;
	}

	@PostMapping
	public ResponseEntity<ExpedienteResponse> createExpediente(@RequestBody final ExpedienteRequest expedienteRequest) {
		return ResponseEntity.status(OK).body(expedienteService.createExpediente(expedienteRequest));
	}

	@GetMapping()
	public ResponseEntity<List<ExpedienteResponse>> getAllExpedientes() {
		return ResponseEntity.status(OK).body(expedienteService.getAllExpedientes());
	}

	@GetMapping("/buscarPorFecha")
	public ResponseEntity<List<ExpedienteResponse>> buscarExpedientePorFecha(
			@RequestParam("fechaAperturaStart") Date fechaAperturaStart,
			@RequestParam("fechaAperturaEnd") Date fechaAperturaEnd) {

		return ResponseEntity.status(OK)
				.body(expedienteService.getExpedienteByFecha(fechaAperturaStart, fechaAperturaEnd));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ExpedienteResponse> getExpediente(@PathVariable("id") final Long id) {
		return ResponseEntity.status(OK).body(expedienteService.getExpedienteById(id));
	}

	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<ExpedienteResponse> getExpedienteByNombre(@PathVariable("nombre") final String nombre) {
		return ResponseEntity.status(OK).body(expedienteService.getExpedienteByNombre(nombre));
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ExpedienteResponse> updateExpediente(@RequestBody final ExpedienteRequest expedienteRequest,
			@PathVariable("id") final Long id) {

		return ResponseEntity.status(OK).body(expedienteService.updateExpediente(expedienteRequest, id));
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}
