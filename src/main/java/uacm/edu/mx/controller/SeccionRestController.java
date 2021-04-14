package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Seccion;
import uacm.edu.mx.repository.SeccionRepository;



@RestController
public class SeccionRestController {

    private final SeccionRepository seccionRepository;
    
	
	@Autowired
    public SeccionRestController(SeccionRepository seccionRepository) {
        this.seccionRepository = seccionRepository;
    }
	
	
	@GetMapping("/encontrarSeccion")
	public Seccion crear(@RequestParam("id") int id) {
		
		Seccion item = new Seccion();
		Seccion tmp = seccionRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
