
package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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
	public ResponseEntity<String> buscarPor(@RequestParam("tipoDocumento") String tipoDocumento) {
		
		System.out.print("Entre al metodo buscar ultimo corr env:  "+tipoDocumento);
		return ResponseEntity.status(OK).body(  corrEnvService.buscarUltimoConsecutivo(tipoDocumento));
	}

	@PostMapping("guardar")
	public ResponseEntity<EnviadaResponse> guardarCorrespondencia(@RequestBody EnviadaRequest enviadaRequest)
			throws ParseException {

		return ResponseEntity.status(OK).body(corrEnvService.insertar(enviadaRequest));
	}
	
	@PostMapping("/upload")
	public ResponseEntity<EnviadaResponse>  uplaodCorrEnv(@RequestParam("archivo") MultipartFile file,@RequestParam("id") String  referenciaDocumento) throws IOException {
		System.out.println("Entre a upload corr env"+"\n");
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("referencia de documento - " + referenciaDocumento);
		String nombre = file.getOriginalFilename();
		String tipo = file.getContentType();
		byte[] contenido = file.getBytes();
		System.out.println("El nombre del archivo es:  - " +nombre);
		System.out.println("El tipo de archivo es:  - " + tipo);
		System.out.println("El tipo de archivo es:  - " + contenido);
	
		
		return ResponseEntity.status(OK).body(corrEnvService.updateGuardarArchivo(referenciaDocumento,contenido,tipo,nombre));
	}
	
	@PostMapping("/uploadAcuse")
	public ResponseEntity<EnviadaResponse>  uplaodAcuse(@RequestParam("archivo") MultipartFile file,@RequestParam("id") String  referenciaDocumento) throws IOException {
		System.out.println("Entre a upload  acuse"+"\n");
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("referencia de documento - " + referenciaDocumento);
		String nombre = file.getOriginalFilename();
		String tipo = file.getContentType();
		byte[] contenido = file.getBytes();
		System.out.println("El nombre del archivo es:  - " +nombre);
		System.out.println("El tipo de archivo es:  - " + tipo);
		System.out.println("El tipo de archivo es:  - " + contenido);
	
		
		return ResponseEntity.status(OK).body(corrEnvService.updateGuardarAcuse(referenciaDocumento,contenido,tipo,nombre));
	}
	
	
	

	@PutMapping("/update")
	public ResponseEntity<EnviadaResponse> actualizarCorrEnviada(@RequestBody EnviadaRequest enviadaRequest,
			@RequestParam("referencia") String referencia) {
		System.out.print("Entre al metodo actualizarCorrEnviada ");
		return ResponseEntity.status(OK).body(corrEnvService.updateCorrEnviada(enviadaRequest, referencia));
	}

	@GetMapping("/referencia")
	public ResponseEntity<EnviadaResponse> buscarPorReferencia(@RequestParam("referenciaDocumento") String referenciaDocumento) {
		System.out.print("Entre al metodo controller buscar por referencia correspondencia enviada");
		return ResponseEntity.status(OK).body(corrEnvService.buscarPorReferencia(referenciaDocumento));
	}
	

	@GetMapping("/buscarPorFechaEnvio")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorFechaDeEnvio(
			@RequestParam("fechaEnvioIni") Date fechaEnvioIni, @RequestParam("fechaEnvioFin") Date fechaEnvioFin) {
		return ResponseEntity.status(OK).body(corrEnvService.buscarPorFechaEnvio(fechaEnvioIni, fechaEnvioFin));
	}
	

	@GetMapping("/buscarPorArea")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorAreaDestinataria(
			@RequestParam("fechaEnvioIni") Date fechaEnvioIni, @RequestParam("fechaEnvioFin") Date fechaEnvioFin,
			@RequestParam("idArea") Long id) {

		return ResponseEntity.status(OK)
				.body(corrEnvService.buscarPorFechaEnvioAndAreaDestinataria(fechaEnvioIni, fechaEnvioFin, id));
	}


	@GetMapping("/estatus")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrEnvPorEstatus(@RequestParam("idEstatus") final Long id) {
		return ResponseEntity.status(OK).body(corrEnvService.buscarPorEstatus(id));

	}
	

	@GetMapping("/prioridad")
	public ResponseEntity<List<EnviadaResponse>> buscarCorrRecPorPrioridad(@RequestParam("idPrioridad") final Long id) {

		return ResponseEntity.status(OK).body(corrEnvService.buscarPorPrioridad(id));
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}
