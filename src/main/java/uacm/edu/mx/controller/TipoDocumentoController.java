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

import uacm.edu.mx.model.TipoDocumento;
import uacm.edu.mx.service.TipoDocumentoService;





@Controller
@RequestMapping("/tipoDocumento")
public class TipoDocumentoController {
	
	private final TipoDocumentoService tipoDocumentoService;
	
	@Autowired
    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<TipoDocumento> lista = tipoDocumentoService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("tipoDocumento", new TipoDocumento());
		return "catalogos/listaTipoDocumento";
	}
	
	@PostMapping("/guardar")
	public String guardar(TipoDocumento tipoDocumento,RedirectAttributes attributes) {
		tipoDocumentoService.guardar(tipoDocumento);
		return "redirect:/tipoDocumento/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int tipoDocumento) {
		tipoDocumentoService.eliminar(tipoDocumento);
        return "redirect:/tipoDocumento/listar";
    }

}
