package uacm.edu.mx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.data.CatalogoRequest;
import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.mapper.ExpedienteMapper;
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.repository.ExpedienteRepository;
import uacm.edu.mx.service.ExpedienteService;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {
	
	
	private final ExpedienteRepository expedienteRepository;
	private final ExpedienteMapper expedienteMapper;
	
	@Autowired
	public ExpedienteServiceImpl(ExpedienteRepository expedienteRepository, ExpedienteMapper expedienteMapper) {
		super();
		this.expedienteRepository = expedienteRepository;
		this.expedienteMapper = expedienteMapper;
	}

	

	@Override
	public ExpedienteResponse insertar(ExpedienteRequest expedienteRequest) {
		return expedienteMapper.EntityToData(expedienteRepository.save(expedienteMapper.dataToEntity(expedienteRequest)));
	}

	@Override
	public Expediente buscarPorId(Integer idExpediente) {
		Optional<Expediente> optional = expedienteRepository.findById(idExpediente);
		if (optional.isPresent())
			return optional.get();
		return null;
	
	}

	@Override
	public List<Expediente> buscarTodos() {
		return expedienteRepository.findAll();
	}

	@Override
	public void eliminar(int idExpediente) {
		expedienteRepository.deleteById(idExpediente);
		
	}

	@Override
	public Expediente buscarPorNombre(String nombreExpediente) {
		return expedienteRepository.findByNombreExpediente(nombreExpediente);
	}

	@Override
	public List<Expediente> buscarPorFecha(Date fechaAperturaStart, Date fechaAperturaEnd) {
		
		return expedienteRepository.findAllByFechaAperturaBetween(fechaAperturaStart, fechaAperturaEnd);
	}

	
}
