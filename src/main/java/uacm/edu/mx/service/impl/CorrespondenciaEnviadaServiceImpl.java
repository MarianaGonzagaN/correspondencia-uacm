package uacm.edu.mx.service.impl;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uacm.edu.mx.data.EnviadaRequest;
import uacm.edu.mx.data.EnviadaResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.mapper.EnviadaMapper;
import uacm.edu.mx.model.CorrespondenciaEnviada;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.repository.CorrespondeciaEnviadaRepository;
import uacm.edu.mx.service.ICorrespondenciaEnviadaService;

@Service
public class CorrespondenciaEnviadaServiceImpl implements ICorrespondenciaEnviadaService {

	private CorrespondeciaEnviadaRepository corrEnvRepository;
	private EnviadaMapper enviadaMapper;

	@Autowired
	public CorrespondenciaEnviadaServiceImpl(CorrespondeciaEnviadaRepository corrEnvRepository,
			EnviadaMapper enviadaMapper) {
		super();
		this.corrEnvRepository = corrEnvRepository;
		this.enviadaMapper = enviadaMapper;
	}

	@Override
	public EnviadaResponse insertar(EnviadaRequest enviadaRequest) {
		return enviadaMapper.enviadaResponse(corrEnvRepository.save(enviadaMapper.dataToEntity(enviadaRequest)));
	}
	
	@Override
	public EnviadaResponse updateCorrEnviada(EnviadaRequest enviadaRequest, String referencia) {
		System.out.print("Entre al meto update corr env ");
		CorrespondenciaEnviada corrEnv = corrEnvRepository.findByReferencia(referencia);
		return enviadaMapper.EntityToData(corrEnvRepository.save(enviadaMapper.dataToEntityUpdate(enviadaRequest, corrEnv)));
	}
	
	@Override
	public EnviadaResponse updateGuardarArchivo(String referencia, byte[] contenido, String tipoDoc,
			String nombreDoc) {
		CorrespondenciaEnviada corrEnv = corrEnvRepository.findByReferencia(referencia);
		 if (corrEnv != null) {
			 return enviadaMapper.EntityToData(corrEnvRepository.save(enviadaMapper.dataToEntityUpdateDoc( corrEnv,contenido,tipoDoc,nombreDoc)));
		 }else {
			 return null;
		 }
		 
		 
	}
	
	@Override
	public EnviadaResponse updateGuardarAcuse(String referencia, byte[] contenido, String tipoDoc,
			String nombreDoc) {
		CorrespondenciaEnviada corrEnv = corrEnvRepository.findByReferencia(referencia);
		 if (corrEnv != null) {
			 return enviadaMapper.EntityToData(corrEnvRepository.save(enviadaMapper.dataToEntityUpdateDocAcuse( corrEnv,contenido,tipoDoc,nombreDoc)));
		 }else {
			 return null;
		 }
		 
		 
	}

	@Override
	public EnviadaResponse buscarPorReferencia(String referencia) {
		CorrespondenciaEnviada corrEnv = corrEnvRepository.findByReferencia(referencia);
		return enviadaMapper.EntityToData(corrEnv);

	}
	
	@Override
	public List<EnviadaResponse> buscarTodas() {
		return corrEnvRepository.findAll().stream().map(enviadaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<EnviadaResponse> buscarPorFechaEnvio(Date fechaEnvioStart, Date fechaEnvioEnd) {
		return corrEnvRepository.findAllByFechaEnvioBetween(fechaEnvioStart, fechaEnvioEnd).stream()
				.map(enviadaMapper::EntityToData).collect(Collectors.toList());
	}

	@Override
	public List<EnviadaResponse> buscarPorFechaEnvioAndAreaDestinataria(Date fechaEnvioIni, Date fechaEnvioFin,
			Long areaId) {

		return corrEnvRepository.findByFechaEnvioAndAreaDestinataria(fechaEnvioIni, fechaEnvioFin, areaId).stream()
				.map(enviadaMapper::EntityToData).collect(Collectors.toList());

	}
	
	@Override
	public List<EnviadaResponse> buscarPorEstatus(Long estatusId) {
		return corrEnvRepository.findByEstatus(estatusId).stream().map(enviadaMapper::EntityToData)
				.collect(Collectors.toList());
	}

	@Override
	public List<EnviadaResponse> buscarPorPrioridad(Long prioridadId) {
		return corrEnvRepository.findByPrioridad(prioridadId).stream().map(enviadaMapper::EntityToData)
				.collect(Collectors.toList());
	}


	@Override
	public String buscarUltimoConsecutivo(String TipoDeDocumento) {
		// TODO Auto-generated method stub

		System.out.print("----------------------------------------------------"+ "\n" );
		System.out.print("la referencia del documento es:" + TipoDeDocumento);
		System.out.print("----------------------------------------------------"+ "\n" );

		String result = null;
		switch (TipoDeDocumento) {
		case "1":
			System.out.print("Entre al caso oficio" );
			Integer maxOficio = null;
			maxOficio = corrEnvRepository.maxOficio();
			String ultimoOficio = "UACM/SLT/COORD/OFI-" + maxOficio + "/2022";
			result = ultimoOficio;
			break;
		case "2":
			Integer maxCircular = null;
			maxCircular = corrEnvRepository.maxCirular();
			String ultimoCircular = "UACM/SLT/COORD/CIRC-" + maxCircular + "/2020";
			result = ultimoCircular;
			break;
		case "3":
			Integer maxComunicado = null;
			maxComunicado = corrEnvRepository.maxComunicado();
			String ultimoComunicado = "UACM/SLT/COORD/COMU-" + maxComunicado + "/2020";
			result = ultimoComunicado;
			break;
		case "4":
			Integer maxNotaInformativa = null;
			maxNotaInformativa = corrEnvRepository.maxNotaInformativa();
			String ultimoNotaInformativa = "UACM/SLT/COORD/NINF-" + maxNotaInformativa + "/2020";
			result = ultimoNotaInformativa;
			break;
		case "5":
			Integer maxInvitacion = null;
			maxInvitacion = corrEnvRepository.maxInvitacion();
			String ultimoInvitacion = "UACM/SLT/COORD/INVI-" + maxInvitacion + "/2020";
			result = ultimoInvitacion;
			break;
		case "6":
			Integer maxMemorandum = null;
			maxMemorandum = corrEnvRepository.maxMemorandum();
			String ultimoMemorandum = "UACM/SLT/COORD/MEMO-" + maxMemorandum + "/2020";
			result = ultimoMemorandum;
			break;
		case "7":
			Integer maxCarta = null;
			maxCarta = corrEnvRepository.maxCarta();
			String ultimoCarta = "UACM/SLT/COORD/CART-" + maxCarta + "/2020";
			result = ultimoCarta;
			break;
		case "8":
			Integer maxBoletin = null;
			maxBoletin = corrEnvRepository.maxBoletin();
			String ultimoBoletin = "UACM/SLT/COORD/BOLE-" + maxBoletin + "/2020";
			result = ultimoBoletin;
			break;
		default:
			break;
		}
		return result;

	}

	

}
