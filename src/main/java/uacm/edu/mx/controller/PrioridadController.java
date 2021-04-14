package uacm.edu.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uacm.edu.mx.model.Prioridad;
import uacm.edu.mx.service.PrioridadService;




@Controller
@RequestMapping("/prioridad")
public class PrioridadController {
	
	private final PrioridadService prioridadService;
	
	@Autowired
    public PrioridadController(PrioridadService prioridadService) {
        this.prioridadService = prioridadService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Prioridad> lista = prioridadService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("prioridad", new Prioridad());
		return "catalogos/listaPrioridad";
	}
	
	@PostMapping("/guardar")
	public String guardar(Prioridad prioridad,RedirectAttributes attributes) {
		prioridadService.guardar(prioridad);
		return "redirect:/prioridad/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int prioridad) {
		prioridadService.eliminar(prioridad);
        return "redirect:/prioridad/listar";
    }

}
