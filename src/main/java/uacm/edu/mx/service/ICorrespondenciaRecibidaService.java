package uacm.edu.mx.service;


import java.util.Date;
import java.util.List;
//import java.io.File;
//import java.text.ParseException;

import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;

public interface ICorrespondenciaRecibidaService {
	
	public RecibidaResponse insertar(RecibidaRequest recibidaRequest);

	public RecibidaResponse buscarPorReferencia(String referenciaDocumento);

	public List<RecibidaResponse> buscarTodas();

	public List<RecibidaResponse> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd);

	public List<RecibidaResponse> buscarPorFechaRecepcionAndAreaRemitente(Date fechaRecepcionStart, Date fechaRecepcionEnd,
			Integer areaId);
	
	public List<RecibidaResponse> buscarPorFechaRequeridaDeRespuesta(Date fechaReqRespStart, Date fechaReqRespEnd);

	public List<RecibidaResponse> buscarPorEstatus(Integer estatusId);

	public List<RecibidaResponse> buscarPorPrioridad(Integer prioridadId);

	public String max();

	CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento(String referencia);
}
