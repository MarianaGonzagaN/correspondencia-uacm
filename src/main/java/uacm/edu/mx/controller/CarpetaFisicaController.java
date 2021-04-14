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

import uacm.edu.mx.model.CarpetaFisica;
import uacm.edu.mx.service.CarpetaFisicaService;



@Controller
@RequestMapping("/carpetaFisica")
public class CarpetaFisicaController {
	
	private final CarpetaFisicaService carpetaFisicaService;
	
	@Autowired
    public CarpetaFisicaController(CarpetaFisicaService carpetaFisicaService) {
        this.carpetaFisicaService = carpetaFisicaService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<CarpetaFisica> lista = carpetaFisicaService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("carpetaFisica", new CarpetaFisica());
		return "catalogos/listaCarpetaFisica";
	}
	
	@PostMapping("/guardar")
	public String guardar(CarpetaFisica carpetaFisica,RedirectAttributes attributes) {
		carpetaFisicaService.guardar(carpetaFisica);
		return "redirect:/carpetaFisica/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int subSeccion) {
		carpetaFisicaService.eliminar(subSeccion);
        return "redirect:/carpetaFisica/listar";
    }

}
