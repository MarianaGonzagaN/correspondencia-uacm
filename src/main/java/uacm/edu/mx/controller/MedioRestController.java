package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Medio;
import uacm.edu.mx.repository.MedioRepository;


@RestController
public class MedioRestController {

    private final MedioRepository medioRepository;
    
	
	@Autowired
    public MedioRestController(MedioRepository medioRepository) {
        this.medioRepository = medioRepository;
    }
	
	
	@GetMapping("/encontrarMedio")
	public Medio crear(@RequestParam("id") int id) {
		
		Medio item = new Medio();
		Medio tmp = medioRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
