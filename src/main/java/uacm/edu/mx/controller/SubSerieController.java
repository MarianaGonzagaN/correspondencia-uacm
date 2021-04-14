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

import uacm.edu.mx.model.SubSerie;
import uacm.edu.mx.service.SubSerieService;



@Controller
@RequestMapping("/subSerie")
public class SubSerieController {
	
	private final SubSerieService subSerieService;
	
	@Autowired
    public SubSerieController(SubSerieService subSerieService) {
        this.subSerieService = subSerieService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<SubSerie> lista = subSerieService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("subSerie", new SubSerie());
		return "catalogos/listasubSerie";
	}
	
	@PostMapping("/guardar")
	public String guardar(SubSerie subSerie,RedirectAttributes attributes) {
		subSerieService.guardar(subSerie);
		return "redirect:/subSerie/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int subSerie) {
        subSerieService.eliminar(subSerie);
        return "redirect:/subSerie/listar";
    }

}
