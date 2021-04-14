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

import uacm.edu.mx.model.Persona;
import uacm.edu.mx.service.PersonaService;




@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	private final PersonaService personaService;
	
	@Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Persona> lista = personaService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("persona", new Persona());
		return "catalogos/listaPersona";
	}
	
	@PostMapping("/guardar")
	public String guardar(Persona seccion,RedirectAttributes attributes) {
		personaService.guardar(seccion);
		return "redirect:/persona/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int persona) {
		personaService.eliminar(persona);
        return "redirect:/perosna/listar";
    }

}
