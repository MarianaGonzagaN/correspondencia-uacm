package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Anexo;
import uacm.edu.mx.repository.AnexoRepository;


@RestController
public class AnexoRestController {

	private final AnexoRepository anexoRepository;
    
	@Autowired
    public AnexoRestController(AnexoRepository anexoRepository) {
        this.anexoRepository = anexoRepository;
    }
	
	
	@GetMapping("/encontrarAnexo")
	public Anexo crear(@RequestParam("id") int id) {
		
		Anexo item = new Anexo();
		Anexo tmp = anexoRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
