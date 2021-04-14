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

import uacm.edu.mx.model.Cargo;
import uacm.edu.mx.service.CargoService;

@Controller
@RequestMapping("/cargo")
public class CargoController {
	
	private final CargoService cargoService;
	
	@Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }
	
	@GetMapping("/listar")
	private String listar(Model model) {
		
		List<Cargo> lista = cargoService.buscarTodos();
		model.addAttribute("lista", lista);
		model.addAttribute("cargo", new Cargo());
		return "catalogos/listaCargo";
	}
	
	@PostMapping("/guardar")
	public String guardar(Cargo cargo,RedirectAttributes attributes) {
		cargoService.guardar(cargo);
		return "redirect:/cargo/listar";
	}
	
	@GetMapping("/eliminar")
    public String eliminar(@RequestParam("id") int cargo) {
		cargoService.eliminar(cargo);
        return "redirect:/cargo/listar";
    }

}
