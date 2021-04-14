package uacm.edu.mx.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.model.Estatus;
import uacm.edu.mx.model.Area;
import uacm.edu.mx.model.Prioridad;
import uacm.edu.mx.service.AnexoService;
import uacm.edu.mx.service.AreaService;
import uacm.edu.mx.service.CargoService;
import uacm.edu.mx.service.CorrespondenciaRecibidaService;
import uacm.edu.mx.service.EstatusService;
import uacm.edu.mx.service.ExpedienteService;
import uacm.edu.mx.service.GenerateExcelFileCorrRecPorFechaRecepService;
import uacm.edu.mx.service.InstruccionService;
import uacm.edu.mx.service.MedioService;
import uacm.edu.mx.service.PersonaService;
import uacm.edu.mx.service.PrioridadService;
import uacm.edu.mx.service.TipoDocumentoService;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/recibida")
public class CorrespondenciaRecibidaController {

	private final Logger logger = LoggerFactory.getLogger(CorrespondenciaRecibidaController.class);

	private final TipoDocumentoService tipoDocumentoService;
	private final AreaService areaService;
	private final CargoService cargoService;
	private final MedioService medioService;
	private final PrioridadService prioridadService;
	private final PersonaService personaService;
	private final InstruccionService instruccionService;
	private final EstatusService estatusService;
	private final ExpedienteService expedienteService;
	private final CorrespondenciaRecibidaService corrRecService;
	private final GenerateExcelFileCorrRecPorFechaRecepService genFileCorrRecFechRecepService;

	@Autowired
	public CorrespondenciaRecibidaController(final TipoDocumentoService tipoDocumentoService,
			final AreaService areaService, final CargoService cargoService, final MedioService medioService,
			final PrioridadService prioridadService, final PersonaService personaService,
			final InstruccionService instruccionService, final EstatusService estatusService,
			final ExpedienteService expedienteService, final CorrespondenciaRecibidaService corrRecService,
			final GenerateExcelFileCorrRecPorFechaRecepService genFileCorrRecFechRecepService) {
		this.tipoDocumentoService = tipoDocumentoService;
		this.areaService = areaService;
		this.cargoService = cargoService;
		this.medioService = medioService;
		this.prioridadService = prioridadService;
		this.personaService = personaService;
		this.instruccionService = instruccionService;
		this.estatusService = estatusService;
		this.expedienteService = expedienteService;
		this.corrRecService = corrRecService;
		this.genFileCorrRecFechRecepService = genFileCorrRecFechRecepService;
	}

	@GetMapping("/agregar")
	private String getCorrRec(@ModelAttribute CorrespondenciaRecibida corrRec) {

		return "correspondenciaRecibida/agregarCorrRecibida";
	}

	@GetMapping(value = "/buscarPorTurno")
	public String buscarPorTurno(Model model, RedirectAttributes attributes) {
		String turno = "0";
		turno = corrRecService.max();
		if (turno != null) {
			model.addAttribute("msgTurno", "Se encontro el último turno.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("ultimoTurno", turno);
			model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());
		} else {
			attributes.addFlashAttribute("msgTurno", "No se encontró último turno");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());
			return "redirect:/recibida/agregar";
		}

		return "correspondenciaRecibida/agregarCorrRecibida";
	}

	@PostMapping(value = "/guardar")
	public String guardar(@ModelAttribute CorrespondenciaRecibida correspondenciaRecibida,
			@RequestParam("file") MultipartFile file, BindingResult result, RedirectAttributes attributes)
			throws IOException {

		String nombre = file.getOriginalFilename();
		String tipo = file.getContentType();

		System.out.println("-------------------------------------------");
		System.out.println("------------nombre-----------XD-------------------" + nombre);
		System.out.println("------------tipo-----------XD-------------------" + tipo);
		System.out.println("-------------------------------------------");

		correspondenciaRecibida.setTipoDocumento(tipo);
		correspondenciaRecibida.setNombreDocumento(nombre);
		correspondenciaRecibida.setDocumento(file.getBytes());

		corrRecService.insertar(correspondenciaRecibida);
		attributes.addFlashAttribute("msg", "La corresponencia se guardó.");
		attributes.addFlashAttribute("alertClass", "alert-success");

		return "redirect:/recibida/agregar";
	}

	/***
	 * Método para llamar a la vista principal de buscar
	 */
	@GetMapping(value = "/buscar")
	public String getPagBuscar(@ModelAttribute CorrespondenciaRecibida modificarCorrRecibida, Model model) {

		return "correspondenciaRecibida/buscarCorrRecibida";

	}

	/***
	 * Método para buscar por fechas
	 */
	@GetMapping(value = "/buscarPorFecha")
	public String buscarCorrRecPorFecha(Date fechaRecepcionStart, Date fechaRecepcionEnd, Model model,
			RedirectAttributes attributes) {
		List<CorrespondenciaRecibida> listCorrRec = corrRecService.buscarPorFechaRecepcion(fechaRecepcionStart,
				fechaRecepcionEnd);
		model.addAttribute("correspondencias", listCorrRec);
		model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());

		if (!listCorrRec.isEmpty()) {

			model.addAttribute("msgFecha", "Se han encontrado correspondencias.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFecha", "No se encontraron correspondencias.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/modificar";

		}
		return "correspondenciaRecibida/modificarCorrRecibida";

	}

	/***
	 * Método para buscar la fecha de recepción
	 */
	@GetMapping(value = "/buscarPorFechaRecep")
	public String buscarCorrespondencias(Date fechaRecepcionStart, Date fechaRecepcionEnd, Model model,
			RedirectAttributes attributes) {
		List<CorrespondenciaRecibida> listCorrRec = corrRecService.buscarPorFechaRecepcion(fechaRecepcionStart,
				fechaRecepcionEnd);

		if (!listCorrRec.isEmpty()) {

			model.addAttribute("fechaRecepcionStart", fechaRecepcionStart);
			model.addAttribute("fechaRecepcionEnd", fechaRecepcionEnd);
			model.addAttribute("correspondenciasPorFechRec", listCorrRec);
			model.addAttribute("msgFechaRecep", "Se han encontrado correspondencias con fecha de recepción ---.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFechaRecep", "No se encontraron correspondencias con fecha de recepción.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/buscar";

		}
		return "correspondenciaRecibida/buscarCorrRecibida";

	}

	@GetMapping("/downloadExcelFile")
	public void downloadExcelFile(HttpServletResponse response,
			@RequestParam("fechaRecepcionStart") Date fechaRecepcionStart,
			@RequestParam("fechaRecepcionEnd") Date fechaRecepcionEnd) throws IOException {

		System.out.println("-------------------------------------------");
		System.out.println("------------fechaRecepcionStart------------------------------" + fechaRecepcionStart);
		System.out.println("-------------------------------------------");
		List<CorrespondenciaRecibida> listCorrRec = (List<CorrespondenciaRecibida>) corrRecService
				.buscarPorFechaRecepcion(fechaRecepcionStart, fechaRecepcionEnd);
		ByteArrayInputStream byteArrayInputStream = genFileCorrRecFechRecepService.export(listCorrRec);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=correspondencias-fecha-recepcion.xlsx");
		IOUtils.copy(byteArrayInputStream, response.getOutputStream());
	}

	/***
	 * Método para buscar las correspondencias por area remitente
	 */

	@GetMapping(value = "/buscarPorArea")
	public String buscarCorrRecPorAreaRemitente(Date fechaRecepcionStart, Date fechaRecepcionEnd, Integer id,
			Model model, RedirectAttributes attributes) {

		List<CorrespondenciaRecibida> listCorrRecArea = corrRecService
				.buscarPorFechaRecepcionAndAreaEnvia(fechaRecepcionStart, fechaRecepcionEnd, id);
		model.addAttribute("correspondenciasPorArea", listCorrRecArea);
		model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());

		if (!listCorrRecArea.isEmpty()) {

			model.addAttribute("msgArea", "Se han encontrado correspondencias con area.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgArea", "No se encontraron correspondencias con area.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/buscar";

		}

		return "correspondenciaRecibida/buscarCorrRecibida";

	}

	/***
	 * Método para buscar las correspondencias por estados
	 * 
	 */
	@GetMapping(value = "/buscarPorEstatus")
	public String buscarCorrRecPorEstatus(Integer id, Model model, RedirectAttributes attributes) {

		List<CorrespondenciaRecibida> listCorrRecEstatus = corrRecService.buscarPorEstatus(id);
		model.addAttribute("correspondenciasPorEstatus", listCorrRecEstatus);
		model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());

		if (!listCorrRecEstatus.isEmpty()) {

			model.addAttribute("msgEstado", "Se han encontrado correspondencias con estado.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgEstado", "No se encontraron correspondencias con estado.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/buscar";

		}

		return "correspondenciaRecibida/buscarCorrRecibida";

	}

	/***
	 * Método para buscar las correspondencias por prioridad
	 * 
	 */
	@GetMapping(value = "/buscarPorPrioridad")
	public String buscarCorrRecPorPrioridad(Integer id, Model model, RedirectAttributes attributes) {

		List<CorrespondenciaRecibida> listCorrRecPrioridad = corrRecService.buscarPorPrioridad(id);
		model.addAttribute("correspondenciasPorPrioridad", listCorrRecPrioridad);
		model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());

		if (!listCorrRecPrioridad.isEmpty()) {

			model.addAttribute("msgPrioridad", "Se han encontrado correspondencias con prioridad.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgPrioridad", "No se encontraron correspondencias con prioridad.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/buscar";

		}

		return "correspondenciaRecibida/buscarCorrRecibida";

	}

	/***
	 * Método para buscar las correspondencias por referencia
	 * 
	 */

	@PostMapping(value = "/buscarReferencia")
	public String buscarCorrRec(@ModelAttribute CorrespondenciaRecibida modificarCorrRecibida, String referencia,
			Model model, RedirectAttributes attributes) {

		CorrespondenciaRecibida corrRec = corrRecService.buscarPorId(referencia);
		if (corrRec != null) {

			model.addAttribute("msgNombre", "Se contró la correspondencia.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("correspondenciaRecibida", corrRec);

		} else {
			attributes.addFlashAttribute("msgNombre", "La corresponencia no existe");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/buscar";
		}

		return "correspondenciaRecibida/buscarCorrRecibida";

	}

	@PostMapping("/file")
	public ResponseEntity<byte[]> getFile(@ModelAttribute CorrespondenciaRecibida modificarCorrRecibida,
			String referencia, Model model, RedirectAttributes attributes) {
		System.out.println("-------------------------------------------");
		System.out.println("------------REFERENCIA-----------XD-------------------" + referencia);
		System.out.println("-------------------------------------------");

		CorrespondenciaRecibida corrRec = corrRecService.buscarArchivoPorReferenciaDeDocumento(referencia);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + corrRec.getNombreDocumento() + "\"").body(corrRec.getDocumento());
	}

	/***
	 * Método para llamar a la vista principal de modificar
	 */
	@GetMapping(value = "/modificar")
	public String getPagModificar(@ModelAttribute CorrespondenciaRecibida correspondenciaRecibida) {
		return "correspondenciaRecibida/modificarCorrRecibida";
	}

	/***
	 * Método para buscar la fecha de recepción en modificar
	 */
	@GetMapping(value = "/buscarPorFechaRecepMod")
	public String buscarCorrRecPorFechRecep(Date fechaRecepcionStart, Date fechaRecepcionEnd, Model model,
			RedirectAttributes attributes) {
		List<CorrespondenciaRecibida> listCorrRec = corrRecService.buscarPorFechaRecepcion(fechaRecepcionStart,
				fechaRecepcionEnd);
		model.addAttribute("correspondenciasPorFechRec", listCorrRec);
		model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());

		if (!listCorrRec.isEmpty()) {

			model.addAttribute("msgFechaRecep", "Se han encontrado correspondencias con fecha de recepción.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFechaRecep", "No se encontraron correspondencias con fecha de recepción.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/modificar";

		}
		return "correspondenciaRecibida/modificarCorrRecibida";

	}

	/***
	 * Método para buscar la fecha de recepción en modificar
	 */
	@PostMapping(value = "/buscarPorReferenciaMod")
	public String buscarCorrRecPorReferenciaMod(@ModelAttribute CorrespondenciaRecibida modificarCorrRecibida,
			String referencia, Model model, RedirectAttributes attributes) {

		CorrespondenciaRecibida corrRec = corrRecService.buscarPorId(referencia);
		if (corrRec != null) {

			model.addAttribute("msgReferenciaMod", "Se contró la correspondencia.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("correspondenciaRecibida", corrRec);

		} else {
			attributes.addFlashAttribute("msgReferenciaMod", "La corresponencia no existe");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/recibida/modificar";
		}

		return "correspondenciaRecibida/modificarCorrRecibida";

	}

	@ModelAttribute
	public void setListas(Model model) {

		model.addAttribute("listaTipoDocumentos", tipoDocumentoService.buscarTodos());
		model.addAttribute("listaAreas", areaService.buscarTodos());
		model.addAttribute("listaCargos", cargoService.buscarTodos());
		model.addAttribute("listaMedios", medioService.buscarTodos());
		model.addAttribute("listaPrioridades", prioridadService.buscarTodos());
		model.addAttribute("listaPersonas", personaService.buscarTodos());
		model.addAttribute("listaInstrucciones", instruccionService.buscarTodos());
		model.addAttribute("listaEstatus", estatusService.buscarTodos());
		model.addAttribute("listaExpedientes", expedienteService.buscarTodos());

	}

	@ModelAttribute
	public void listCatalogos(Model model) {
		model.addAttribute("correspondenciaRecibida", new CorrespondenciaRecibida());
		Area areaForm = new Area();
		model.addAttribute("area", areaForm);
		List<Area> listArea = areaService.buscarTodos();
		model.addAttribute("listaAreas", listArea);

		Estatus estadoForm = new Estatus();
		model.addAttribute("estado", estadoForm);
		List<Estatus> listEstatus = estatusService.buscarTodos();
		model.addAttribute("listaEstatus", listEstatus);

		Prioridad prioridadForm = new Prioridad();
		model.addAttribute("prioridad", prioridadForm);
		List<Prioridad> listPrioridad = prioridadService.buscarTodos();
		model.addAttribute("listaPrioridades", listPrioridad);
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}