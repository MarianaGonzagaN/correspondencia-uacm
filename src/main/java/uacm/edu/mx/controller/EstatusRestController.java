package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uacm.edu.mx.model.Estatus;
import uacm.edu.mx.repository.EstatusRepository;

@RestController
public class EstatusRestController {

    private final EstatusRepository estatusRepository;
    
	
	@Autowired
    public EstatusRestController(EstatusRepository estatusRepository) {
        this.estatusRepository = estatusRepository;
    }
	
	
	@GetMapping("/encontrarEstatus")
	public Estatus crear(@RequestParam("id") int id) {
		
		Estatus item = new Estatus();
		Estatus tmp = estatusRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
