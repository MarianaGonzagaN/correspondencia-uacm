package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uacm.edu.mx.model.CarpetaFisica;
import uacm.edu.mx.repository.CarpetaFisicaRepository;

@RestController
public class CarpetaFisicaRestController {

	private final CarpetaFisicaRepository carpetaFisicaRepository;
    
	
	@Autowired
    public CarpetaFisicaRestController(CarpetaFisicaRepository carpetaFisicaRepository) {
        this.carpetaFisicaRepository = carpetaFisicaRepository;
    }
	
	
	@GetMapping("/encontrarCarpetaFisica")
	public CarpetaFisica crear(@RequestParam("id") int id) {
		
		CarpetaFisica item = new CarpetaFisica();
		CarpetaFisica tmp = carpetaFisicaRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
