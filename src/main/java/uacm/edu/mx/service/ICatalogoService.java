package uacm.edu.mx.service;

import java.util.List;

import org.springframework.stereotype.Service;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;

@Service
public interface ICatalogoService {

	public CatalogoResponse createCatalogo(CatalogoRequest catalogoRequest);
	public CatalogoResponse update(CatalogoRequest catalogoRequest);
	public void delete(Long id);
	public CatalogoResponse getCatalogo(Long id);
	public List<CatalogoResponse> getAllCatalogo();
	public CatalogoResponse addValorCatalogo(CatalogoValorRequest catalogoValorRequest, Long catalogo_id);
	public CatalogoResponse updateValorCatalogo(CatalogoValorRequest catalogoValorRequest);
	public void deleteValorCatalogo(Long id);
}
