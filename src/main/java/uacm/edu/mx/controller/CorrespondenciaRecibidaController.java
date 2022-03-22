package uacm.edu.mx.controller;

import static org.springframework.http.HttpStatus.OK;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
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
import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.service.ICorrespondenciaRecibidaService;
import uacm.edu.mx.service.IExpedienteService;
import uacm.edu.mx.service.GenerateExcelFileCorrRecPorFechaRecepService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.HttpStatus;

@Slf4j
@RestController
@RequestMapping(value = "/api/recibida")
public class CorrespondenciaRecibidaController {

	private final ICorrespondenciaRecibidaService corrRecService;
	
	@Autowired
	public CorrespondenciaRecibidaController(
			final IExpedienteService expedienteService, final ICorrespondenciaRecibidaService corrRecService,
			final GenerateExcelFileCorrRecPorFechaRecepService genFileCorrRecFechRecepService) {
		this.corrRecService = corrRecService;
	}
	
	@PostMapping("/guardarConDoc")
	public ResponseEntity<RecibidaResponse>  guardarCorr( @RequestParam("file") MultipartFile file,@ModelAttribute("recibidaRequest") RecibidaRequest recibidaRequest)
			throws IOException, ParseException {

		String nombre = file.getOriginalFilename();
		String tipo = file.getContentType();
		recibidaRequest.setTipoDocumentoRecibido(tipo);
		recibidaRequest.setNombreDocumentoRecibido(nombre);
		recibidaRequest.setDocumento(file.getBytes());
		return ResponseEntity.status(OK).body(corrRecService.insertar(recibidaRequest));
	}
	
	

	
	
	@PostMapping("guardar")
	public ResponseEntity<RecibidaResponse>  guardarCorrespondencia( @RequestBody RecibidaRequest recibidaRequest) throws ParseException
	{

		return ResponseEntity.status(OK).body(corrRecService.insertar(recibidaRequest));
	}
	


	@PostMapping("/upload")
	public ResponseEntity<RecibidaResponse>  uplaodImage(@RequestParam("archivo") MultipartFile file,@RequestParam("id") String  referenciaDocumento) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		System.out.println("referencia de documento - " + referenciaDocumento);
		String nombre = file.getOriginalFilename();
		String tipo = file.getContentType();
		byte[] contenido = file.getBytes();
		System.out.println("El nombre del archivo es:  - " +nombre);
		System.out.println("El tipo de archivo es:  - " + tipo);
		System.out.println("El tipo de archivo es:  - " + contenido);
	
		
		return ResponseEntity.status(OK).body(corrRecService.updateGuardarArchivo(referenciaDocumento,contenido,tipo,nombre));
		//return ResponseEntity.status(HttpStatus.OK);
	}

	
	@GetMapping("/buscarTurno")
	public ResponseEntity<String> buscarPorTurno() {
		System.out.println("entre al controler ---- buscar por turno");

		return ResponseEntity.status(OK).body( corrRecService.max());
	}

	
	@GetMapping( "/buscarPorFechaRecep")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorFechaDeRecep(@RequestParam ("fechaRecepcionStart") Date fechaRecepcionStart, @RequestParam ("fechaRecepcionEnd") Date fechaRecepcionEnd) {
		System.out.print("Entre al metodo buscarCorrRecPorFechaDeRecep ");
		return ResponseEntity.status(OK).body(corrRecService.buscarPorFechaRecepcion(fechaRecepcionStart,
				fechaRecepcionEnd));
	}
	
	@GetMapping("/referencia")
	public ResponseEntity<RecibidaResponse> buscarPorReferencia(@RequestParam("referenciaDocumento") String referenciaDocumento) {
		System.out.print("Entre al metodo controller buscar por referencia ");
		return ResponseEntity.status(OK).body(corrRecService.buscarPorReferencia(referenciaDocumento));
	}
	
	@PutMapping("/update")
	public ResponseEntity<RecibidaResponse> actualizarCorrRecibida(@RequestBody RecibidaRequest recibidaRequest,
			@RequestParam("referencia") String referencia) {
		System.out.print("Entre al metodo actualizarCorrRecibida ");
		return ResponseEntity.status(OK).body(corrRecService.updateCorrRecibida(recibidaRequest, referencia));
	}
	

	@GetMapping( "/vigencia")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorFechaReqDeRespuesta(@RequestParam ("fechaReqRespStart") Date fechaReqRespStart, @RequestParam ("fechaReqRespEnd") Date fechaReqRespEnd) {
		return ResponseEntity.status(OK).body(corrRecService.buscarPorFechaRecepcion(fechaReqRespStart,
				fechaReqRespEnd));
	}
	

	@GetMapping("/buscarPorArea")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorAreaRemitente(@RequestParam ("fechaRecepcionStart") Date fechaRecepcionStart, @RequestParam ("fechaRecepcionEnd") Date fechaRecepcionEnd, @RequestParam ("idArea") Long  id) {

		return ResponseEntity.status(OK).body(corrRecService.buscarPorFechaRecepcionAndAreaRemitente(fechaRecepcionStart,
				fechaRecepcionEnd,id));
	}

	@GetMapping("/estatus")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorEstatus(@RequestParam("idEstatus") final Long id) {
		return ResponseEntity.status(OK).body(corrRecService.buscarPorEstatus(id));

	}

	@GetMapping("/prioridad")
	public ResponseEntity<List<RecibidaResponse>> buscarCorrRecPorPrioridad(@RequestParam("idPrioridad") final Long id) {

		return ResponseEntity.status(OK).body(corrRecService.buscarPorPrioridad(id));
	}
	
	

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}


}
