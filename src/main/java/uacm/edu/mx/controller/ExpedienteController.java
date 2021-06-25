package uacm.edu.mx.controller;

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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.service.ExpedienteService;
import uacm.edu.mx.service.IFondoService;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(value = "/api/expediente")
public class ExpedienteController {
	
	private final Logger logger = LoggerFactory.getLogger(ExpedienteController.class);
	
	private final ExpedienteService expedienteService;
	private final IFondoService fondoService;

	
	@Autowired
	public ExpedienteController(final ExpedienteService expedienteService, final IFondoService fondoService) {
		this.expedienteService = expedienteService;
		this.fondoService = fondoService;
	}

	@PostMapping
	public ResponseEntity <ExpedienteResponse> createExpediente(@RequestBody final ExpedienteRequest expedienteRequest) {
		return ResponseEntity.status(OK).body(expedienteService.createExpediente(expedienteRequest));
	}
	
	@GetMapping()
	public ResponseEntity<List<ExpedienteResponse>> getAllExpedientes() {
		return ResponseEntity.status(OK).body(expedienteService.getAllExpedientes());
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
