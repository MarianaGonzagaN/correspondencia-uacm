package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.EmisorReceptor;
import uacm.edu.mx.repository.EmisorReceptorRepository;

@RestController
public class EmisorReceptorRestController {

    private final EmisorReceptorRepository emisorReceptorRepository;
    
	
	@Autowired
    public EmisorReceptorRestController(EmisorReceptorRepository emisorReceptorRepository) {
        this.emisorReceptorRepository = emisorReceptorRepository;
    }
	
	
	
	@GetMapping("/encontrarEmisorReceptor")
	public EmisorReceptor crear(@RequestParam("id") int id) {
		
		EmisorReceptor item = new EmisorReceptor();
		EmisorReceptor tmp = emisorReceptorRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
