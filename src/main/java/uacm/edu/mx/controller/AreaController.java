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

import uacm.edu.mx.model.Area;
import uacm.edu.mx.model.CarpetaFisica;
import uacm.edu.mx.service.AreaService;
import uacm.edu.mx.service.CarpetaFisicaService;



@Controller
@RequestMapping("/area")
public class AreaController {
	
	private final AreaService areaService;
	
	@Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Area> lista = areaService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("area", new Area());
		return "catalogos/listaArea";
	}
	
	@PostMapping("/guardar")
	public String guardar(Area area,RedirectAttributes attributes) {
		areaService.guardar(area);
		return "redirect:/area/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int area) {
		areaService.eliminar(area);
        return "redirect:/area/listar";
    }

}
