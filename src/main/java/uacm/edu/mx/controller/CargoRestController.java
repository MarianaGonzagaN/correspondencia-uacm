package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Cargo;
import uacm.edu.mx.repository.CargoRepository;

@RestController
public class CargoRestController {

	private final CargoRepository cargoRepository;
    
	
	@Autowired
    public CargoRestController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }
	
	
	@GetMapping("/encontrarCargo")
	public Cargo crear(@RequestParam("id") int id) {
		
		Cargo item = new Cargo();
		Cargo tmp = cargoRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
