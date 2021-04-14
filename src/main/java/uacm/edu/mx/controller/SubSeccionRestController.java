package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Seccion;
import uacm.edu.mx.model.SubSeccion;
import uacm.edu.mx.repository.SeccionRepository;
import uacm.edu.mx.repository.SubSeccionRepository;



@RestController
public class SubSeccionRestController {

    private final SubSeccionRepository subSeccionRepository;
    
	
	@Autowired
    public SubSeccionRestController(SubSeccionRepository subSeccionRepository) {
        this.subSeccionRepository = subSeccionRepository;
    }
	
	
	@GetMapping("/encontrarSubSeccion")
	public SubSeccion crear(@RequestParam("id") int id) {
		
		SubSeccion item = new SubSeccion();
		SubSeccion tmp = subSeccionRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
