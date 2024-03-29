package uacm.edu.mx.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.exception.ExpedienteException;
import uacm.edu.mx.mapper.RecibidaMapper;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.model.Expediente;
import uacm.edu.mx.repository.CorrespondeciaRecibidaRepository;
import uacm.edu.mx.service.ICorrespondenciaRecibidaService;

@Service
public class CorrespondenciaRecibidaServiceImpl implements ICorrespondenciaRecibidaService {

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
		String turno = recibidaRequest.getTurno() + "-" + localDate.getYear();
		recibidaRequest.setTurno(turno);
		return recibidaMapper.recibidaResponse(corrRecRepository.save(recibidaMapper.dataToEntity(recibidaRequest)));
	}
	
	@Override
	public RecibidaResponse updateCorrRecibida(RecibidaRequest recibidaRequest, String referencia) {
		System.out.print("Entre al meto update corr rec ");
		CorrespondenciaRecibida corrRec = corrRecRepository.findByReferencia(referencia);
		return recibidaMapper.EntityToData(corrRecRepository.save(recibidaMapper.dataToEntityUpdate(recibidaRequest, corrRec)));
	}

	@Override
	public RecibidaResponse buscarPorReferencia(String referencia) {
		CorrespondenciaRecibida corrRec = corrRecRepository.findByReferencia(referencia);
		return recibidaMapper.EntityToData(corrRec);

	}
	
	@Override
	public RecibidaResponse updateGuardarArchivo(String referencia, byte[] contenido, String tipoDoc,
			String nombreDoc) {
		CorrespondenciaRecibida corrRec = corrRecRepository.findByReferencia(referencia);
		 if (corrRec != null) {
			 return recibidaMapper.EntityToData(corrRecRepository.save(recibidaMapper.dataToEntityUpdateDoc( corrRec,contenido,tipoDoc,nombreDoc)));
		 }else {
			 return null;
		 }
		 
		 
	}

	@Override
	public List<RecibidaResponse> buscarTodas() {
		return corrRecRepository.findAll().stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<RecibidaResponse> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd) {
		return corrRecRepository.findAllByFechaRecepcionBetween(fechaRecepcionStart, fechaRecepcionEnd).stream()
				.map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public String max() {
		return corrRecRepository.max();
	}

	@Override
	public List<RecibidaResponse> buscarPorFechaRecepcionAndAreaRemitente(Date fechaRecepcionStart, Date fechaRecepcionEnd,
			Long  areaId) {
		return corrRecRepository.findByFechaRecepcionAndAreaRemitente(fechaRecepcionStart, fechaRecepcionEnd, areaId)
				.stream().map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<RecibidaResponse> buscarPorFechaRequeridaDeRespuesta(Date fechaReqRespStart, Date fechaReqRespEnd) {
		return corrRecRepository.findByfechaRequeridaRespuesta(fechaReqRespStart, fechaReqRespEnd).stream()
				.map(recibidaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<RecibidaResponse> buscarPorEstatus(Long estatusId) {
		return corrRecRepository.findByEstatus(estatusId).stream().map(recibidaMapper::EntityToData)
				.collect(Collectors.toList());
	}

	@Override
	public List<RecibidaResponse> buscarPorPrioridad(Long prioridadId) {
		return corrRecRepository.findByPrioridad(prioridadId).stream().map(recibidaMapper::EntityToData)
				.collect(Collectors.toList());
	}

	@Override
	public CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento(String referencia) {
		// TODO Auto-generated method stub
		return corrRecRepository.findByDocumento(referencia);
	}

	


}
