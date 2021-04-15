package uacm.edu.mx.mapper;

import org.springframework.stereotype.Component;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;

@Component
public class CatalogoMapper {

	public Catalogo dataToEntity(CatalogoRequest catalogoRequest) {
		
		Catalogo catalogo = new Catalogo();
		catalogo.setNombre(catalogoRequest.getNombre());
		
		return catalogo;
	}
	
	public CatalogoResponse EntityToData(Catalogo catalogo) {
		
		CatalogoResponse catalogoResponse = new CatalogoResponse();
		
		catalogoResponse.setId(catalogo.getId());
		catalogoResponse.setNombre(catalogo.getNombre());
		catalogoResponse.setValores(catalogo.getValores());
		
		return catalogoResponse;
	}
	
	public CatalogoValores dataValorToEntity(CatalogoValorRequest catalogoValorRequest) {
		
		CatalogoValores catalogoValor = new CatalogoValores();
		catalogoValorRequest.setDescripcion(catalogoValorRequest.getDescripcion());
		catalogoValorRequest.setNombre(catalogoValorRequest.getNombre());
		
		return catalogoValor;
	}
	
	
}
