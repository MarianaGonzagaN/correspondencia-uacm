package uacm.edu.mx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uacm.edu.mx.data.CatalogoValorResponse;

@Service
public interface ICatalogoValorService {
	
	
	public List<CatalogoValorResponse> getValoresCatalogoByNombre (String nombreCatalogo);

}
