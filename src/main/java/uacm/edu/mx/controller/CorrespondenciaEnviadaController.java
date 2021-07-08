
package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uacm.edu.mx.data.EnviadaRequest;
import uacm.edu.mx.data.EnviadaResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaEnviada;
import uacm.edu.mx.service.ICorrespondenciaEnviadaService;
import uacm.edu.mx.service.IExpedienteService;

@RestController
@RequestMapping(value = "/api/enviada")
public class CorrespondenciaEnviadaController {

	private final Logger logger = LoggerFactory.getLogger(CorrespondenciaEnviadaController.class);
	@Autowired
	private final ICorrespondenciaEnviadaService corrEnvService;
	private String ultimo;

	public CorrespondenciaEnviadaController(ICorrespondenciaEnviadaService corrEnvService) {
		super();
		this.corrEnvService = corrEnvService;
	}

	@GetMapping("/buscarUltimo")
	public String buscarPor(String tipoDocumento) {
		ultimo = null;
		return ultimo = corrEnvService.buscarUltimoConsecutivo(tipoDocumento);
	}

	@PostMapping("guardar")
	public ResponseEntity<EnviadaResponse> guardarCorrespondencia(@RequestBody EnviadaRequest enviadaRequest)
			throws ParseException {

		return ResponseEntity.status(OK).body(corrEnvService.insertar(enviadaRequest));
	}

	@GetMapping("/{referencia}")
	public ResponseEntity<EnviadaResponse> buscarPorReferencia(@RequestParam("referencia") String referencia) {
		return ResponseEntity.status(OK).body(corrEnvService.buscarPorReferencia(referencia));
	}

	@GetMapping("/buscarPorFechaEnvio")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorFechaDeEnvio(
			@RequestParam("fechaEnvioIni") Date fechaEnvioIni, @RequestParam("fechaRecepcionEnd") Date fechaEnvioFin) {
		return ResponseEntity.status(OK).body(corrEnvService.buscarPorFechaEnvio(fechaEnvioIni, fechaEnvioFin));
	}

	@GetMapping("/buscarPorArea")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorAreaRemitente(
			@RequestParam("fechaEnvioIni") Date fechaEnvioIni,
			@RequestParam("fechaEnvioFin") Date fechaEnvioFin, Integer id) {

		return ResponseEntity.status(OK).body(
				corrEnvService.buscarPorFechaEnvioAndAreaDestinataria(fechaEnvioIni, fechaEnvioFin, id));
	}

	@GetMapping("/estatus/{id}")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorEstatus(@PathVariable("id") final Integer id) {
		return ResponseEntity.status(OK).body(corrEnvService.buscarPorEstatus(id));

	}

	@GetMapping("/prioridad/{id}")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorPrioridad(@PathVariable("id") final Integer id) {

		return ResponseEntity.status(OK).body(corrEnvService.buscarPorPrioridad(id));
	}


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}
