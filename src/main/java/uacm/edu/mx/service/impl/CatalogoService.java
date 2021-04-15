package uacm.edu.mx.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.exception.CatalogoException;
import uacm.edu.mx.mapper.CatalogoMapper;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.repository.CatalogoRepository;
import uacm.edu.mx.repository.CatalogoValorRepository;
import uacm.edu.mx.service.ICatalogoService;

@Service
public class CatalogoService implements ICatalogoService {

	private final CatalogoRepository catalogoRepository;
	private final CatalogoValorRepository catalogoValorRepository;
	private final CatalogoMapper catalogoMapper;

	@Autowired
	public CatalogoService(CatalogoRepository catalogoRepository, CatalogoValorRepository catalogoValorRepository,
			CatalogoMapper catalogoMapper) {
		super();
		this.catalogoRepository = catalogoRepository;
		this.catalogoValorRepository = catalogoValorRepository;
		this.catalogoMapper = catalogoMapper;
	}

	@Override
	public CatalogoResponse createCatalogo(CatalogoRequest catalogoRequest) {
		// TODO Auto-generated method stub

		return catalogoMapper.EntityToData(catalogoRepository.save(catalogoMapper.dataToEntity(catalogoRequest)));
	}

	@Override
	public CatalogoResponse update(CatalogoRequest catalogoRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CatalogoResponse getCatalogo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CatalogoResponse> getAllCatalogo() {
		// TODO Auto-generated method stub
		return catalogoRepository.findAll().stream().map(catalogoMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public CatalogoResponse addValorCatalogo(CatalogoValorRequest catalogoValorRequest, Long catalogo_id) {
		
		Catalogo catalogo = catalogoRepository.findById(catalogo_id).orElseThrow(() -> new CatalogoException());
		catalogo.addValor(catalogoMapper.dataValorToEntity(catalogoValorRequest));

		return catalogoMapper.EntityToData(catalogoRepository.save(catalogo));
	}

	@Override
	public CatalogoResponse updateValorCatalogo(CatalogoValorRequest catalogoValorRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteValorCatalogo(Long id) {
		// TODO Auto-generated method stub

	}

}
