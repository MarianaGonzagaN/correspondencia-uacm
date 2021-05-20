package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.service.ICorrespondenciaRecibidaService;
import uacm.edu.mx.service.ExpedienteService;
import uacm.edu.mx.service.GenerateExcelFileCorrRecPorFechaRecepService;

import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("correspondencia/recibida")
public class CorrespondenciaRecibidaController {

	private final ICorrespondenciaRecibidaService corrRecService;
	@Autowired
	public CorrespondenciaRecibidaController(
			final ExpedienteService expedienteService, final ICorrespondenciaRecibidaService corrRecService,
			final GenerateExcelFileCorrRecPorFechaRecepService genFileCorrRecFechRecepService) {
		this.corrRecService = corrRecService;
	}
	

	/*add
	 * @GetMapping private String getCorrRec(@ModelAttribute CorrespondenciaRecibida
	 * corrRec) {
	 * 
	 * return "correspondenciaRecibida/agregarCorrRecibida"; }
	 */

	@GetMapping("buscarTurno/")
	public String buscarPorTurno() {
		String turno = "0";
		return turno = corrRecService.max();
	}

	@PostMapping
	public ResponseEntity<RecibidaResponse>  guardarCorrespondencia( @RequestParam("file") MultipartFile file, @RequestBody RecibidaRequest recibidaRequest)
			throws IOException {

		String nombre = file.getOriginalFilename();
		String tipo = file.getContentType();

		recibidaRequest.setTipoDocumento(tipo);
		recibidaRequest.setNombreDocumento(nombre);
		recibidaRequest.setDocumento(file.getBytes());

		return ResponseEntity.status(OK).body(corrRecService.insertar(recibidaRequest));
	}
	

	@GetMapping("/{referencia}")
	public ResponseEntity<RecibidaResponse> buscarPorReferencia(@RequestParam("referencia") String referencia) {
		return ResponseEntity.status(OK).body(corrRecService.buscarPorId(referencia));
	}
	
	@GetMapping( value = "/buscarPorFechaRecep")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrespondencias(@RequestParam ("fechaRecepcionStart") Date fechaRecepcionStart, @RequestParam ("fechaRecepcionEnd") Date fechaRecepcionEnd) {
		return ResponseEntity.status(OK).body(corrRecService.buscarPorFechaRecepcion(fechaRecepcionStart,
				fechaRecepcionEnd));
	}
	

	@GetMapping(value = "/buscarPorArea")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorAreaRemitente(@RequestParam ("fechaRecepcionStart") Date fechaRecepcionStart, @RequestParam ("fechaRecepcionEnd") Date fechaRecepcionEnd, Integer id) {

		return ResponseEntity.status(OK).body(corrRecService.buscarPorFechaRecepcionAndAreaEnvia(fechaRecepcionStart,
				fechaRecepcionEnd,id));
	}

	/***
	 * Método para buscar las correspondencias por estados
	 * 
	 */
	@GetMapping("/estatus/{id}")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorEstatus(@PathVariable("id") final Integer id) {
		return ResponseEntity.status(OK).body(corrRecService.buscarPorEstatus(id));

	}

	/***
	 * Método para buscar las correspondencias por prioridad
	 * 
	 */
	@GetMapping("/prioridad/{id}")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorPrioridad(@PathVariable("id") final Integer id) {

		return ResponseEntity.status(OK).body(corrRecService.buscarPorPrioridad(id));
	}

	/***
	 * Método para buscar las correspondencias por referencia
	 * 
	 */

	

}
