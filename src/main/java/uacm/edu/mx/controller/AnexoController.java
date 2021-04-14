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

import uacm.edu.mx.model.Anexo;
import uacm.edu.mx.service.AnexoService;




@Controller
@RequestMapping("/anexo")
public class AnexoController {
	
	private final AnexoService anexoService;
	
	@Autowired
    public AnexoController(AnexoService anexoService) {
        this.anexoService = anexoService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Anexo> lista = anexoService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("anexo", new Anexo());
		return "catalogos/listaAnexo";
	}
	
	@PostMapping("/guardar")
	public String guardar(Anexo anexo,RedirectAttributes attributes) {
		anexoService.guardar(anexo);
		return "redirect:/anexo/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int anexo) {
		anexoService.eliminar(anexo);
        return "redirect:/anexo/listar";
    }

}
