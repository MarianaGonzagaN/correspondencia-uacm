package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Area;
import uacm.edu.mx.repository.AreaRepository;


@RestController
public class AreaRestController {

	private final AreaRepository areaRepository;
    
	@Autowired
    public AreaRestController(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }
	
	
	@GetMapping("/encontrarArea")
	public Area crear(@RequestParam("id") int id) {
		
		Area item = new Area();
		Area tmp = areaRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
