package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Persona;
import uacm.edu.mx.repository.PersonaRepository;




@RestController
public class PersonaRestController {

    private final PersonaRepository personaRepository;
    
	
	@Autowired
    public PersonaRestController(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }
	
	
	@GetMapping("/encontrarPersona")
	public Persona crear(@RequestParam("id") int id) {
		
		Persona item = new Persona();
		Persona tmp = personaRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
