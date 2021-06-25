package uacm.edu.mx.service;

import java.util.List;

import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.model.Fondo;

public interface IFondoService {

	public FondoResponse createFondo(FondoRequest fondoRequest);	
	public List<FondoResponse> getAllFondo();
	public FondoResponse getFondoById(Long  idFondo);	
	public FondoResponse updateFondo(FondoRequest fondoRequest, Long  idFondo);
	
}
