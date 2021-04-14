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

import uacm.edu.mx.model.Instruccion;
import uacm.edu.mx.service.InstruccionService;

@Controller
@RequestMapping("/instruccion")
public class InstruccionController {
	
	private final InstruccionService instruccionService;
	
	@Autowired
    public InstruccionController(InstruccionService instruccionService) {
        this.instruccionService = instruccionService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Instruccion> lista = instruccionService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("instruccion", new Instruccion());
		return "catalogos/listaInstruccion";
	}
	
	@PostMapping("/guardar")
	public String guardar(Instruccion instruccion,RedirectAttributes attributes) {
		instruccionService.guardar(instruccion);
		return "redirect:/instruccion/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int instruccion) {
        instruccionService.eliminar(instruccion);
        return "redirect:/instruccion/listar";
    }

}
