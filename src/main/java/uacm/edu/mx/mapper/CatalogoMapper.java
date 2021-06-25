package uacm.edu.mx.mapper;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.data.CatalogoValorResponse;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;

@Slf4j
@Component
public class CatalogoMapper {

	public Catalogo dataToEntity(CatalogoRequest catalogoRequest) {
		
		Catalogo catalogo = new Catalogo();
		catalogo.setNombre(catalogoRequest.getNombre());
		
		return catalogo;
	}
	
	public Catalogo dataToEntityUpdate(CatalogoRequest catalogoRequest, Catalogo catalogo) {
		
		catalogo.setNombre(catalogoRequest.getNombre());
		
		return catalogo;
	}
	
	public CatalogoResponse EntityToData(Catalogo catalogo) {
		
		CatalogoResponse catalogoResponse = new CatalogoResponse();
		
		catalogoResponse.setId(catalogo.getId());
		catalogoResponse.setNombre(catalogo.getNombre());
		
		return catalogoResponse;
	}
	
	public CatalogoValores dataValorToEntity(CatalogoValorRequest catalogoValorRequest,Catalogo catalogo) {
		
		CatalogoValores catalogoValor = new CatalogoValores();
		
		catalogoValor.setDescripcion(catalogoValorRequest.getDescripcion());
		catalogoValor.setNombre(catalogoValorRequest.getNombre());
		catalogoValor.setCatalogo(catalogo);
		
		return catalogoValor;
	}
	
	public CatalogoValores dataValorToEntityUpdate(CatalogoValorRequest catalogoValorRequest,CatalogoValores catalogoValores) {
		
		catalogoValores.setDescripcion(catalogoValorRequest.getDescripcion());
		catalogoValores.setNombre(catalogoValorRequest.getNombre());
		
		return catalogoValores;
	}
	
	public CatalogoValorResponse EntityValorToData(CatalogoValores catalogoValores) {
		
		CatalogoValorResponse cvr = new CatalogoValorResponse();
		
		cvr.setDescripcion(catalogoValores.getDescripcion());
		cvr.setId(catalogoValores.getId());
		cvr.setNombre(catalogoValores.getNombre());
		
		return cvr;
	}


	public CatalogoResponse catalogoResponse(Catalogo catalogo, List<CatalogoValorResponse> setCatalogoValores) {
		
		CatalogoResponse catalogoResponse = new CatalogoResponse();
		
		catalogoResponse.setId(catalogo.getId());
		catalogoResponse.setNombre(catalogo.getNombre());
		catalogoResponse.setValores(setCatalogoValores);
		
		return catalogoResponse;
	}
	
}
