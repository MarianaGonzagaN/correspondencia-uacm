package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Serie;
import uacm.edu.mx.repository.SerieRepository;



@RestController
public class SerieRestController2 {

    private final SerieRepository serieRepository;
    
	
	@Autowired
    public SerieRestController2(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }
	
	
	@GetMapping("/encontrarSerie")
	public Serie crear(@RequestParam("id") int id) {
		
		Serie item = new Serie();
		Serie tmp = serieRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
