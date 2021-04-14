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

import uacm.edu.mx.model.Seccion;
import uacm.edu.mx.service.SeccionService;



@Controller
@RequestMapping("/seccion")
public class SeccionController {
	
	private final SeccionService seccionService;
	
	@Autowired
    public SeccionController(SeccionService seccionService) {
        this.seccionService = seccionService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Seccion> lista = seccionService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("seccion", new Seccion());
		return "catalogos/listaSeccion";
	}
	
	@PostMapping("/guardar")
	public String guardar(Seccion seccion,RedirectAttributes attributes) {
		seccionService.guardar(seccion);
		return "redirect:/seccion/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int seccion) {
        seccionService.eliminar(seccion);
        return "redirect:/seccion/listar";
    }

}
