package uacm.edu.mx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uacm.edu.mx.model.Area;
import uacm.edu.mx.model.CorrespondenciaEnviada;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.model.Estatus;
import uacm.edu.mx.model.Prioridad;
import uacm.edu.mx.service.AnexoService;
import uacm.edu.mx.service.AreaService;
import uacm.edu.mx.service.CargoService;
import uacm.edu.mx.service.CorrespondenciaEnviadaService;
import uacm.edu.mx.service.EstatusService;
import uacm.edu.mx.service.ExpedienteService;
import uacm.edu.mx.service.InstruccionService;
import uacm.edu.mx.service.MedioService;
import uacm.edu.mx.service.PersonaService;
import uacm.edu.mx.service.PrioridadService;
import uacm.edu.mx.service.TipoDocumentoService;

@Controller
@RequestMapping("/enviada")
public class CorrespondenciaEnviadaController {

	private final Logger logger = LoggerFactory.getLogger(CorrespondenciaEnviadaController.class);

	private final TipoDocumentoService tipoDocumentoService;
	private final AreaService areaService;
	private final CargoService cargoService;
	private final MedioService medioService;
	private final PrioridadService prioridadService;
	private final PersonaService personaService;
	private final InstruccionService instruccionService;
	private final EstatusService estatusService;
	private final ExpedienteService expedienteService;
	private final CorrespondenciaEnviadaService corrEnvService;

	@Autowired
	public CorrespondenciaEnviadaController(final TipoDocumentoService tipoDocumentoService,
			final AreaService areaService, final CargoService cargoService, final MedioService medioService,
			final PrioridadService prioridadService, final PersonaService personaService,
			final InstruccionService instruccionService, final EstatusService estatusService,
			final ExpedienteService expedienteService, final CorrespondenciaEnviadaService corrEnvService) {
		this.tipoDocumentoService = tipoDocumentoService;
		this.areaService = areaService;
		this.cargoService = cargoService;
		this.medioService = medioService;
		this.prioridadService = prioridadService;
		this.personaService = personaService;
		this.instruccionService = instruccionService;
		this.estatusService = estatusService;
		this.expedienteService = expedienteService;
		this.corrEnvService = corrEnvService;
	}

	@GetMapping("/agregar")
	private String getCorrEnv(@ModelAttribute CorrespondenciaEnviada correspondenciaEnviada) {

		return "correspondenciaEnviada/agregarCorrEnviada";
	}

	@PostMapping(value = "/guardar")
	public String guardar(@ModelAttribute CorrespondenciaEnviada correspondenciaEnviada, BindingResult result,
			RedirectAttributes attributes) {
		corrEnvService.insertar(correspondenciaEnviada);
		attributes.addFlashAttribute("msg", "La corresponencia se guardó.");
		attributes.addFlashAttribute("alertClass", "alert-success");

		return "redirect:/enviada/agregar";
	}

	@GetMapping(value = "/buscarUltimo")
	public String buscarPor(String referenciaDocumento, Model model, RedirectAttributes attributes) {

		String ultimo = null;
		ultimo = corrEnvService.buscarUltimoConsecutivo(referenciaDocumento);

		if (ultimo != null) {
			model.addAttribute("msgTurno", "Se encontro la última referencia.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("ultimo", ultimo);
			model.addAttribute("correspondenciaEnviada", new CorrespondenciaEnviada());
		} else {
			attributes.addFlashAttribute("msgTurno", "No se encontró la última referencia");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			model.addAttribute("correspondenciaEnviada", new CorrespondenciaEnviada());
			return "redirect:/enviada/agregar";
		}

		return "correspondenciaEnviada/agregarCorrEnviada";
	}

	/***
	 * Método para llamar a la vista principal de buscar
	 */
	@GetMapping(value = "/buscar")
	public String getPagBuscar(@ModelAttribute CorrespondenciaEnviada correspondenciaEnviada, Model model) {
		return "correspondenciaEnviada/buscarCorrEnviada";
	}

	/***
	 * Método para buscar la fecha de envio
	 */
	@GetMapping(value = "/buscarPorFechaEnvio")
	public String buscarCorrespondenciasPorFechaEnvio(Date fechaEnvioStart, Date fechaEnvioEnd, Model model,
			RedirectAttributes attributes) {
		List<CorrespondenciaEnviada> listCorrEnv = corrEnvService.buscarPorFechaEnvio(fechaEnvioStart, fechaEnvioStart);
		model.addAttribute("correspondenciasPorFechEnvio", listCorrEnv);

		if (!listCorrEnv.isEmpty()) {

			model.addAttribute("msgFechaEnvio", "Se han encontrado correspondencias con fecha de envío.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFechaEnvio", "No se encontraron correspondencias con fecha de envío.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/buscar";

		}
		return "correspondenciaEnviada/buscarCorrEnviada";

	}

	/***
	 * Método para buscar las correspondencias por area remitente
	 */

	@GetMapping(value = "/buscarPorArea")
	public String buscarCorrRecPorAreaDestinataria(Date fechaEnvioStart, Date fechaEnvioEnd, Integer id, Model model,
			RedirectAttributes attributes) {

		List<CorrespondenciaEnviada> listCorrEnvArea = corrEnvService.buscarPorFechaEnvioAndAreaRecibe(fechaEnvioStart,
				fechaEnvioEnd, id);
		System.out.println("-------------------el tamaño de la lista de correspondencias: " + listCorrEnvArea.size());
		model.addAttribute("correspondenciasPorArea", listCorrEnvArea);
		model.addAttribute("CorrespondenciaEnviada", new CorrespondenciaEnviada());

		if (!listCorrEnvArea.isEmpty()) {

			model.addAttribute("msgArea", "Se han encontrado correspondencias con area.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgArea", "No se encontraron correspondencias con area.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/buscar";

		}

		return "correspondenciaEnviada/buscarCorrEnviada";

	}

	/***
	 * Método para buscar las correspondencias por estados
	 * 
	 */
	@GetMapping(value = "/buscarPorEstatus")
	public String buscarCorrRecPorEstatus(Integer id, Model model, RedirectAttributes attributes) {

		List<CorrespondenciaEnviada> listCorrRecEstatus = corrEnvService.buscarPorEstatus(id);
		model.addAttribute("correspondenciasPorEstatus", listCorrRecEstatus);
		model.addAttribute("correspondenciaEnviada", new CorrespondenciaEnviada());

		if (!listCorrRecEstatus.isEmpty()) {

			model.addAttribute("msgEstado", "Se han encontrado correspondencias con estado.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgEstado", "No se encontraron correspondencias con estado.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/buscar";

		}

		return "correspondenciaEnviada/buscarCorrEnviada";

	}

	/***
	 * Método para buscar las correspondencias por prioridad
	 * 
	 */
	@GetMapping(value = "/buscarPorPrioridad")
	public String buscarCorrRecPorPrioridad(Integer id, Model model, RedirectAttributes attributes) {

		List<CorrespondenciaEnviada> listCorrRecPrioridad = corrEnvService.buscarPorPrioridad(id);
		model.addAttribute("correspondenciasPorPrioridad", listCorrRecPrioridad);
		model.addAttribute("correspondenciaEnviada", new CorrespondenciaEnviada());

		if (!listCorrRecPrioridad.isEmpty()) {

			model.addAttribute("msgPrioridad", "Se han encontrado correspondencias con prioridad.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgPrioridad", "No se encontraron correspondencias con prioridad.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/buscar";

		}

		return "correspondenciaEnviada/buscarCorrEnviada";

	}

	/***
	 * Método para buscar las correspondencias por referencia
	 * 
	 */
	@PostMapping(value = "/buscarReferencia")
	public String buscarCorrEnv(@ModelAttribute CorrespondenciaEnviada correspondenciaEnviada, String referencia,
			Model model, RedirectAttributes attributes) {

		CorrespondenciaEnviada corrRec = corrEnvService.buscarPorId(referencia);
		if (corrRec != null) {

			model.addAttribute("msgNombre", "Se contró la correspondencia.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("correspondenciaEnviada", corrRec);

		} else {
			attributes.addFlashAttribute("msgNombre", "La corresponencia no existe");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/buscar";
		}

		return "correspondenciaEnviada/buscarCorrEnviada";

	}

	/***
	 * Método para llamar a la vista principal de modificar
	 */
	@GetMapping(value = "/modificar")
	public String getPagModificarCorrEnv(@ModelAttribute CorrespondenciaEnviada correspondenciaEnviada) {
		return "correspondenciaEnviada/modificarCorrEnviada";
	}

	/***
	 * Método para buscar la fecha de envio en modificar
	 */
	@GetMapping(value = "/buscarPorFechaEnvMod")
	public String buscarCorrEnvPorFechEnvMod(Date fechaEnvioStart, Date fechaEnvioEnd, Model model,
			RedirectAttributes attributes) {

		List<CorrespondenciaEnviada> listCorrEnv = corrEnvService.buscarPorFechaEnvio(fechaEnvioStart, fechaEnvioStart);
		model.addAttribute("correspondenciasPorFechEnvio", listCorrEnv);

		if (!listCorrEnv.isEmpty()) {

			model.addAttribute("msgFechaEnvio", "Se han encontrado correspondencias con fecha de envío.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFechaEnvio", "No se encontraron correspondencias con fecha de envío.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/modificar";

		}
		return "correspondenciaEnviada/modificarCorrEnviada";

	}

	/***
	 * Método para buscar la fecha de recepción en modificar
	 */
	@PostMapping(value = "/buscarPorReferenciaMod")
	public String buscarCorrRecPorReferenciaMod(@ModelAttribute CorrespondenciaEnviada correspondenciaEnviada,
			String referencia, Model model, RedirectAttributes attributes) {

		CorrespondenciaEnviada corrEnv = corrEnvService.buscarPorId(referencia);
		if (corrEnv != null) {

			model.addAttribute("msgReferenciaMod", "Se contró la correspondencia.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("correspondenciaEnviada", corrEnv);

		} else {
			attributes.addFlashAttribute("msgReferenciaMod", "La corresponencia no existe");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/enviada/modificar";
		}

		return "correspondenciaEnviada/modificarCorrEnviada";

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
