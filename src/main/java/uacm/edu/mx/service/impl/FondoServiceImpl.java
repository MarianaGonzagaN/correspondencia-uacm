package uacm.edu.mx.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.exception.CatalogoException;
import uacm.edu.mx.exception.FondoException;
import uacm.edu.mx.mapper.FondoMapper;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.Fondo;
import uacm.edu.mx.repository.FondoRepository;
import uacm.edu.mx.service.IFondoService;

@Service
public class FondoServiceImpl implements IFondoService {

	private final FondoRepository fondoRepository;
	private final FondoMapper fondoMapper;

	@Autowired
	public FondoServiceImpl(FondoRepository fondoRepository, FondoMapper fondoMapper) {
		super();
		this.fondoRepository = fondoRepository;
		this.fondoMapper = fondoMapper;
	}

	@Override
	public FondoResponse createFondo(FondoRequest fondoRequest) {
		return fondoMapper.EntityToData(fondoRepository.save(fondoMapper.dataToEntity(fondoRequest)));
	}

	@Override
	public List<FondoResponse> getAllFondo() {
		return fondoRepository.findAll().stream().map(fondoMapper::EntityToData).collect(Collectors.toList());
	}
	
	@Override
	public FondoResponse getFondoById(Long idFondo) {
		Fondo fondo = fondoRepository.findById(idFondo)
				.orElseThrow(() -> new FondoException(idFondo));
		return fondoMapper.EntityToData(fondo);
	}

	@Override
	public FondoResponse updateFondo(FondoRequest fondoRequest, Long idFondo) {
		Fondo fondo = fondoRepository.findById(idFondo)
				.orElseThrow(() -> new FondoException(idFondo));
	
		return fondoMapper.EntityToData(fondoRepository.save(fondoMapper.dataToEntityUpdate(fondoRequest, fondo)));
	}



	

}
