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

import uacm.edu.mx.model.Medio;
import uacm.edu.mx.service.MedioService;



@Controller
@RequestMapping("/medio")
public class MedioController {
	
	private final MedioService medioService;
	
	@Autowired
    public MedioController(MedioService medioService) {
        this.medioService = medioService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Medio> lista = medioService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("medio", new Medio());
		return "catalogos/listaMedio";
	}
	
	@PostMapping("/guardar")
	public String guardar(Medio medio,RedirectAttributes attributes) {
		medioService.guardar(medio);
		return "redirect:/medio/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int medio) {
        medioService.eliminar(medio);
        return "redirect:/medio/listar";
    }

}
