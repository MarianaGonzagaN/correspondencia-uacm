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
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.service.ExpedienteService;
import uacm.edu.mx.service.FondoService;


@Controller
@RequestMapping("/expediente")
public class ExpedienteController {
	
	private final Logger logger = LoggerFactory.getLogger(ExpedienteController.class);
	
	private final ExpedienteService expedienteService;
	private final FondoService fondoService;

	
	@Autowired
	public ExpedienteController(final ExpedienteService expedienteService, final FondoService fondoService) {
		this.expedienteService = expedienteService;
		this.fondoService = fondoService;
	}


	@GetMapping("/agregar")
	private String getExpediente(@ModelAttribute Expediente expediente) {

		return "expediente/agregarExpediente";
	}

	@PostMapping(value = "/guardar")
	public String guardar(@ModelAttribute Expediente expediente, BindingResult result, RedirectAttributes attributes) {
		expedienteService.insertar(expediente);
		attributes.addFlashAttribute("msg", "El expediente se ha guardado.");
		attributes.addFlashAttribute("alertClass", "alert-success");

		return "redirect:/expediente/agregar";
	}

	@GetMapping(value = "/modificar")
	public String getPagModificar(@ModelAttribute Expediente expedientes) {

		return "expediente/modificarExpediente";

	}

	@PostMapping(value = "/buscarPorNombre")
	public String buscarExpedientePorNombre(@ModelAttribute Expediente expediente1, String nombreExpediente,
			Model model, RedirectAttributes attributes) {

		Expediente expediente = expedienteService.buscarPorNombre(nombreExpediente);
		if (expediente != null) {

			model.addAttribute("msgNombre", "El expediente se ha encontrado.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("expediente", expediente);

		} else {
			attributes.addFlashAttribute("msgNombre", "El expediente no existe");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/expediente/modificar";
		}

		return "expediente/buscarExpedientes";

	}
	
	
	@PostMapping(value = "/buscarExpedienteMod")
	public String buscarExpedientePorNombreMod(@ModelAttribute Expediente expediente1, String nombreExpediente,
			Model model, RedirectAttributes attributes) {

		Expediente expediente = expedienteService.buscarPorNombre(nombreExpediente);
		if (expediente != null) {

			model.addAttribute("msgNombre", "El expediente se ha encontrado.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("expediente", expediente);

		} else {
			attributes.addFlashAttribute("msgNombre", "El expediente no existe");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/expediente/modificar";
		}

		return "expediente/modificarExpediente";

	}
	
	@GetMapping(value = "/buscar")
	public String getPagBuscar(@ModelAttribute Expediente expedientes) {

		return "expediente/buscarExpedientes";

	}

	
	@PostMapping(value = "/buscarExpediente")
	public String buscarExpediente(@ModelAttribute Expediente expediente1, String nombreExpediente,
			Model model, RedirectAttributes attributes) {

		Expediente expediente = expedienteService.buscarPorNombre(nombreExpediente);
		if (expediente != null) {

			model.addAttribute("msgNombre", "El expediente se ha encontrado.");
			model.addAttribute("alertClass", "alert-success");
			model.addAttribute("expediente", expediente);

		} else {
			attributes.addFlashAttribute("msgNombre", "El expediente no se ha encontrado");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/expediente/buscar";
		}

		return "expediente/buscarExpedientes";

	}
	
	
	@GetMapping(value = "/buscarExpedientes")
	public String buscarExpedientes(Date fechaAperturaStart, Date fechaAperturaEnd, Model model,
			RedirectAttributes attributes) {
		List<Expediente> listExp = expedienteService.buscarPorFecha(fechaAperturaStart, fechaAperturaEnd);
		model.addAttribute("expedientes", listExp);
		model.addAttribute("expediente", new Expediente());

		if (!listExp.isEmpty()) {

			model.addAttribute("msgFecha", "Se han encontrado expedientes.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFecha", "No se encontraron expedientes.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/expediente/buscar";

		}

		   return "expediente/buscarExpedientes";

	}

	@GetMapping("/listar")
	private String listar(Model model) {

		List<Expediente> listExp = expedienteService.buscarTodos();
		model.addAttribute("expedientes", listExp);
		return "expediente/listaExpedientes";
	}

	@GetMapping(value = "/buscarPorFecha")
	public String buscarExpedientePorFecha(Date fechaAperturaStart, Date fechaAperturaEnd, Model model,
			RedirectAttributes attributes) {
		List<Expediente> listExp = expedienteService.buscarPorFecha(fechaAperturaStart, fechaAperturaEnd);
		model.addAttribute("expedientes", listExp);
		model.addAttribute("expediente", new Expediente());

		if (!listExp.isEmpty()) {

			model.addAttribute("msgFecha", "Se han encontrado expedientes.");
			model.addAttribute("alertClass", "alert-success");

		} else {

			attributes.addFlashAttribute("msgFecha", "No se encontraron expedientes.");
			attributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/expediente/modificar";

		}

		return "expediente/buscarExpedientes";

	}


	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}


}
