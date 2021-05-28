package uacm.edu.mx.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorRequest;
import uacm.edu.mx.data.CatalogoValorResponse;
import uacm.edu.mx.exception.CatalogoException;
import uacm.edu.mx.mapper.CatalogoMapper;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.repository.CatalogoRepository;
import uacm.edu.mx.repository.CatalogoValorRepository;
import uacm.edu.mx.service.ICatalogoService;

@Slf4j
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
	public CatalogoResponse update(CatalogoRequest catalogoRequest, Long catalogo_id) {
		// TODO Auto-generated method stub
		Catalogo catalogo = catalogoRepository.findById(catalogo_id)
				.orElseThrow(() -> new CatalogoException("No se encontro catalogo a editar con id " + catalogo_id));
		return catalogoMapper
				.EntityToData(catalogoRepository.save(catalogoMapper.dataToEntityUpdate(catalogoRequest, catalogo)));
	}

	@Override
	public void delete(Long catalogo_id) {
		// TODO Auto-generated method stub

		Catalogo catalogo = catalogoRepository.findById(catalogo_id)
				.orElseThrow(() -> new CatalogoException("No se encontro catalogo a borrar con id " + catalogo_id));
		catalogoRepository.delete(catalogo);
	}

	@Override
	public CatalogoResponse getCatalogo(Long catalogo_id) {
		Catalogo catalogo = catalogoRepository.findById(catalogo_id)
				.orElseThrow(() -> new CatalogoException("No se encontro catalogo con id " + catalogo_id));

		List<CatalogoValorResponse> setCatalogoValores = catalogoValorRepository.findByCatalogo(catalogo).stream()
				.map(catalogoMapper::EntityValorToData).collect(Collectors.toList());

		return catalogoMapper.catalogoResponse(catalogo, setCatalogoValores);
	}

	@Override
	public List<CatalogoResponse> getAllCatalogo() {
		// TODO Auto-generated method stub
		return catalogoRepository.findAll().stream().map(catalogoMapper::EntityToData).collect(Collectors.toList());
	}
	
	@Override
	public List<CatalogoResponse> getAllCatalogosValores() {
		// TODO Auto-generated method stub
		return catalogoRepository.findAll().stream().map(catalogo ->{ 
			List<CatalogoValorResponse> setCatalogoValores = catalogoValorRepository.findByCatalogo(catalogo).stream()
					.map(catalogoMapper::EntityValorToData).collect(Collectors.toList());
			return catalogoMapper.catalogoResponse(catalogo, setCatalogoValores);
		}).collect(Collectors.toList());
	}
	

	@Override
	public CatalogoResponse addValorCatalogo(CatalogoValorRequest catalogoValorRequest, Long catalogo_id) {

		Catalogo catalogo = catalogoRepository.findById(catalogo_id)
				.orElseThrow(() -> new CatalogoException("No se encontro catalogo con id " + catalogo_id));
		catalogoValorRepository.save(catalogoMapper.dataValorToEntity(catalogoValorRequest, catalogo));
		List<CatalogoValorResponse> setCatalogoValores = catalogoValorRepository.findByCatalogo(catalogo).stream()
				.map(catalogoMapper::EntityValorToData).collect(Collectors.toList());

		return catalogoMapper.catalogoResponse(catalogo, setCatalogoValores);
	}

	@Override
	public CatalogoResponse updateValorCatalogo(CatalogoValorRequest catalogoValorRequest, Long catalogo_valor_id) {

		CatalogoValores catalogoValores = catalogoValorRepository.findById(catalogo_valor_id)
				.orElseThrow(() -> new CatalogoException("No se encontro valor con id " + catalogo_valor_id));
		
		catalogoValores = catalogoMapper.dataValorToEntityUpdate(catalogoValorRequest, catalogoValores);
		catalogoValorRepository.save(catalogoValores);
		Catalogo catalogo = catalogoValores.getCatalogo();
		List<CatalogoValorResponse> setCatalogoValores = catalogoValorRepository.findByCatalogo(catalogo).stream()
				.map(catalogoMapper::EntityValorToData).collect(Collectors.toList());

		return catalogoMapper.catalogoResponse(catalogo, setCatalogoValores);
	}

	@Override
	public void deleteValorCatalogo(Long catalogo_valor_id) {
		
		CatalogoValores catalogoValores = catalogoValorRepository.findById(catalogo_valor_id)
				.orElseThrow(() -> new CatalogoException("No se encontro valor con id " + catalogo_valor_id));
		catalogoValorRepository.delete(catalogoValores);

	}

}
