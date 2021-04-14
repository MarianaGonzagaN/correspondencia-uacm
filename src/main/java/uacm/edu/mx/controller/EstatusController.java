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

import uacm.edu.mx.model.Estatus;
import uacm.edu.mx.service.EstatusService;

@Controller
@RequestMapping("/estatus")
public class EstatusController {
	
	private final EstatusService estatusService;
	
	@Autowired
    public EstatusController(EstatusService estatusService) {
        this.estatusService = estatusService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Estatus> lista = estatusService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("estatus", new Estatus());
		return "catalogos/listaEstatus";
	}
	
	@PostMapping("/guardar")
	public String guardar(Estatus estatus,RedirectAttributes attributes) {
		estatusService.guardar(estatus);
		return "redirect:/estatus/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int estatus) {
        estatusService.eliminar(estatus);
        return "redirect:/estatus/listar";
    }

}
