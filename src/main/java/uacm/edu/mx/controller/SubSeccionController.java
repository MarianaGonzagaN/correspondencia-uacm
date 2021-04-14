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
import uacm.edu.mx.model.SubSeccion;
import uacm.edu.mx.service.SubSeccionService;



@Controller
@RequestMapping("/subSeccion")
public class SubSeccionController {
	
	private final SubSeccionService subSeccionService;
	
	@Autowired
    public SubSeccionController(SubSeccionService subSeccionService) {
        this.subSeccionService = subSeccionService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<SubSeccion> lista = subSeccionService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("subSeccion", new SubSeccion());
		return "catalogos/listaSubSeccion";
	}
	
	@PostMapping("/guardar")
	public String guardar(SubSeccion seccion,RedirectAttributes attributes) {
		subSeccionService.guardar(seccion);
		return "redirect:/subSeccion/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int subSeccion) {
		subSeccionService.eliminar(subSeccion);
        return "redirect:/subSeccion/listar";
    }

}
