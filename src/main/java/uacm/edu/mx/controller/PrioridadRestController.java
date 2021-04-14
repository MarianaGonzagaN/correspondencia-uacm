package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Prioridad;
import uacm.edu.mx.repository.PrioridadRepository;






@RestController
public class PrioridadRestController {

    private final PrioridadRepository prioridadRepository;
    
	
	@Autowired
    public PrioridadRestController(PrioridadRepository prioridadRepository) {
        this.prioridadRepository = prioridadRepository;
    }
	
	
	@GetMapping("/encontrarPrioridad")
	public Prioridad crear(@RequestParam("id") int id) {
		
		Prioridad item = new Prioridad();
		Prioridad tmp = prioridadRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
