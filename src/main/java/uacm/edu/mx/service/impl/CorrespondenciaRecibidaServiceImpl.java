package uacm.edu.mx.service.impl;

import static org.springframework.http.HttpStatus.OK;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uacm.edu.mx.data.CatalogoResponse;
import uacm.edu.mx.data.CatalogoValorResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.exception.CatalogoException;
import uacm.edu.mx.exception.RecibidaException;
import uacm.edu.mx.mapper.RecibidaMapper;
import uacm.edu.mx.model.Catalogo;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.repository.CorrespondeciaRecibidaRepository;
import uacm.edu.mx.service.ICorrespondenciaRecibidaService;

@Service
public class CorrespondenciaRecibidaServiceImpl implements ICorrespondenciaRecibidaService{
	
	
	private final CorrespondeciaRecibidaRepository corrRecRepository;
	private final RecibidaMapper recibidaMapper;
	
	
	@Autowired
	public CorrespondenciaRecibidaServiceImpl(CorrespondeciaRecibidaRepository corrRecRepository,
			RecibidaMapper recibidamapper) {
		super();
		this.corrRecRepository = corrRecRepository;
		this.recibidaMapper = recibidamapper;
	}

	@Override
	public RecibidaResponse insertar(RecibidaRequest recibidaRequest) {
		LocalDate localDate = LocalDate.now();
		String turno = recibidaRequest.getTurno()+"-"+localDate.getYear();
		recibidaRequest.setTurno(turno);
		return recibidaMapper.recibidaResponse(corrRecRepository.save(recibidaMapper.dataToEntity(recibidaRequest)));
	}
	

	@Override
	public RecibidaResponse buscarPorId(String referencia) {
		CorrespondenciaRecibida  corrRec = corrRecRepository.findById(referencia)
				.orElseThrow(() -> new RecibidaException("No se encontró la correspondencia con la referencia" + referencia));	
		return recibidaMapper.EntityToData(corrRec);
		
	}
	
	@Override
	public List<RecibidaResponse> buscarTodas() {
		return corrRecRepository.findAll().stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}
	
	@Override
	public List<RecibidaResponse> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd) {
		return corrRecRepository.findAllByFechaRecepcionBetween(fechaRecepcionStart, fechaRecepcionEnd).stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public String max() {
		return corrRecRepository.max();
	}

	@Override
	public List<CorrespondenciaRecibida> buscarPendientesDeSolucion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecibidaResponse> buscarPorFechaRecepcionAndAreaEnvia(Date fechaRecepcionStart,
			Date fechaRecepcionEnd, Integer areaId) {
		return corrRecRepository.findByFechaRecepcionAndAreaEnvia(fechaRecepcionStart, fechaRecepcionEnd,areaId).stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<RecibidaResponse> buscarPorEstatus(Integer estatusId) {
		return corrRecRepository.findByEstatus(estatusId).stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<RecibidaResponse> buscarPorPrioridad(Integer prioridadId) {
		return corrRecRepository.findByPrioridad(prioridadId).stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento(String referencia) {
		// TODO Auto-generated method stub
		return corrRecRepository.findByDocumento(referencia);
	}



}
