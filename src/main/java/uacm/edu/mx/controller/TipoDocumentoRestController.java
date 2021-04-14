package uacm.edu.mx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.TipoDocumento;
import uacm.edu.mx.repository.TipoDocumentoRepository;


@RestController
public class TipoDocumentoRestController {

	private final TipoDocumentoRepository tipoDocumentoRepository;
    
	@Autowired
    public TipoDocumentoRestController(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }
	
	
	@GetMapping("/encontrarTipoDocumento")
	public TipoDocumento crear(@RequestParam("id") int id) {
		
		TipoDocumento item = new TipoDocumento();
		TipoDocumento tmp = tipoDocumentoRepository.getOne(id);
		item.setId(tmp.getId());
		item.setNombre(tmp.getNombre());
		return item;
	}
	 
}
