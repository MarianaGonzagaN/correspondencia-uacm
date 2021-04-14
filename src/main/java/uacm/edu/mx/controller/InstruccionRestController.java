package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uacm.edu.mx.model.Instruccion;
import uacm.edu.mx.repository.InstruccionRepository;

@RestController
public class InstruccionRestController {

    private final InstruccionRepository instruccionRepository;
    
	
	@Autowired
    public InstruccionRestController(InstruccionRepository instruccionRepository) {
        this.instruccionRepository = instruccionRepository;
    }
	
	
	@GetMapping("/encontrarInstruccion")
	public Instruccion crear(@RequestParam("id") int id) {
		
		Instruccion item = new Instruccion();
		Instruccion tmp = instruccionRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
