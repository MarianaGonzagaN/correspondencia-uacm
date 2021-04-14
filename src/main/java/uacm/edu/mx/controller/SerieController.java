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

import uacm.edu.mx.model.Serie;
import uacm.edu.mx.service.SerieService;



@Controller
@RequestMapping("/serie")
public class SerieController {
	
	private final SerieService serieService;
	
	@Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Serie> lista = serieService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("serie", new Serie());
		return "catalogos/listaserie";
	}
	
	@PostMapping("/guardar")
	public String guardar(Serie serie,RedirectAttributes attributes) {
		serieService.guardar(serie);
		return "redirect:/serie/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int serie) {
        serieService.eliminar(serie);
        return "redirect:/serie/listar";
    }

}
