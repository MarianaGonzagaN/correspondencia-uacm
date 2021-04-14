package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.SubSerie;
import uacm.edu.mx.repository.SubSerieRepository;





@RestController
public class SubSerieRestController {

    private final SubSerieRepository subSerieRepository;
    
	
	@Autowired
    public SubSerieRestController(SubSerieRepository subSerieRepository) {
        this.subSerieRepository = subSerieRepository;
    }
	
	
	@GetMapping("/encontrarSubSerie")
	public SubSerie crear(@RequestParam("id") int id) {
		
		SubSerie item = new SubSerie();
		SubSerie tmp = subSerieRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
