package uacm.edu.mx.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import uacm.edu.mx.data.CatalogoValorResponse;
import uacm.edu.mx.mapper.CatalogoMapper;
import uacm.edu.mx.repository.CatalogoValorRepository;
import uacm.edu.mx.service.ICatalogoValorService;

@Slf4j
@Service
public class CatalogoValorServiceImpl implements ICatalogoValorService{
	
	private final CatalogoValorRepository catalogoValorRepository;
	private final CatalogoMapper catalogoMapper;
	
	@Autowired
	public CatalogoValorServiceImpl(CatalogoValorRepository catalogoValorRepository, CatalogoMapper catalogoMapper) {
		super();
		this.catalogoValorRepository = catalogoValorRepository;
		this.catalogoMapper = catalogoMapper;
	}

	
	@Override
	public List<CatalogoValorResponse> getValoresCatalogoByNombre(String nombreCatalogo) {
		
		List<CatalogoValorResponse> catResp = new ArrayList<>();

		catResp = catalogoValorRepository.getValoresCatalogoByNombre(nombreCatalogo).stream()
				.map(catalogoMapper::EntityValorToData).collect(Collectors.toList());
		
		System.out.println("valores de response"+ catResp);
		
		return catResp;
		
	}

	
	
}
