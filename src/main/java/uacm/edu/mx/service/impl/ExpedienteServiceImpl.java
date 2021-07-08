package uacm.edu.mx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.data.FondoRequest;
import uacm.edu.mx.data.FondoResponse;
import uacm.edu.mx.mapper.ExpedienteMapper;
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.model.Fondo;
import uacm.edu.mx.repository.ExpedienteRepository;
import uacm.edu.mx.service.IExpedienteService;
import uacm.edu.mx.exception.ExpedienteException;
import uacm.edu.mx.exception.FondoException;

@Service
public class ExpedienteServiceImpl implements IExpedienteService {
	
	
	private final ExpedienteRepository expedienteRepository;
	private final ExpedienteMapper expedienteMapper;
	
	@Autowired
	public ExpedienteServiceImpl(ExpedienteRepository expedienteRepository, ExpedienteMapper expedienteMapper) {
		super();
		this.expedienteRepository = expedienteRepository;
		this.expedienteMapper = expedienteMapper;
	}

	@Override
	public ExpedienteResponse createExpediente(ExpedienteRequest expedienteRequest) {
		return expedienteMapper.EntityToData(expedienteRepository.save(expedienteMapper.dataToEntity(expedienteRequest)));
	}
	
	@Override
	public List<ExpedienteResponse> getAllExpedientes() {
		return expedienteRepository.findAll().stream().map(expedienteMapper::EntityToData).collect(Collectors.toList());
	}
	
	@Override
	public List<ExpedienteResponse> getExpedienteByFecha(Date fechaAperturaStart, Date fechaAperturaEnd) {
		return expedienteRepository.findAllByFechaAperturaBetween(fechaAperturaStart, fechaAperturaEnd)
				.stream().map(expedienteMapper::EntityToData).collect(Collectors.toList());
	}


	@Override
	public ExpedienteResponse getExpedienteById(Long idExpediente) {
		Expediente expediente = expedienteRepository.findById(idExpediente)
				.orElseThrow(() -> new ExpedienteException("No se encontro el expediente con  id " + idExpediente));
		return expedienteMapper.EntityToData(expediente);
	
	}
	@Override
	public ExpedienteResponse getExpedienteByNombre(String nombreExpediente) {
		Expediente expediente = expedienteRepository.findByNombreExpediente(nombreExpediente);
		return expedienteMapper.EntityToData(expediente);
	
	}
	@Override
	public ExpedienteResponse updateExpediente(ExpedienteRequest expedienteRequest, Long idExpediente) {
		Expediente expediente = expedienteRepository.findById(idExpediente)
				.orElseThrow(() -> new ExpedienteException("No se encontro el expediente con  id" + idExpediente));
		return expedienteMapper.EntityToData(expedienteRepository.save(expedienteMapper.dataToEntityUpdate(expedienteRequest, expediente)));
	}


}
