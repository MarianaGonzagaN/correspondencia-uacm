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

import uacm.edu.mx.model.EmisorReceptor;
import uacm.edu.mx.service.EmisorReceptorService;

@Controller
@RequestMapping("/emisorReceptor")
public class EmisorReceptorController {
	
	private final EmisorReceptorService emisorReceptorService;
	
	@Autowired
    public EmisorReceptorController(EmisorReceptorService emisorReceptorService) {
        this.emisorReceptorService = emisorReceptorService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<EmisorReceptor> lista = emisorReceptorService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("emisorReceptor", new EmisorReceptor());
		return "catalogos/listaEmisorReceptor";
	}
	
	@PostMapping("/guardar")
	public String guardar(EmisorReceptor emisorReceptor,RedirectAttributes attributes) {
		emisorReceptorService.guardar(emisorReceptor);
		return "redirect:/emisorReceptor/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int emisorReceptor) {
        emisorReceptorService.eliminar(emisorReceptor);
        return "redirect:/emisorReceptor/listar";
    }

}
