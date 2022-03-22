package uacm.edu.mx.service;


import java.util.Date;
import java.util.List;
//import java.io.File;
//import java.text.ParseException;

import uacm.edu.mx.data.ExpedienteRequest;
import uacm.edu.mx.data.ExpedienteResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;

public interface ICorrespondenciaRecibidaService {
	
	public RecibidaResponse insertar(RecibidaRequest recibidaRequest);

	public RecibidaResponse updateCorrRecibida(RecibidaRequest recibidaRequest, String  referencia);
	
	public RecibidaResponse updateGuardarArchivo( String  referencia, byte[] contenido,
			String tipoDoc, String nombreDoc);
	
	public RecibidaResponse buscarPorReferencia(String referenciaDocumento);

	public List<RecibidaResponse> buscarTodas();

	public List<RecibidaResponse> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd);

	public List<RecibidaResponse> buscarPorFechaRecepcionAndAreaRemitente(Date fechaRecepcionStart, Date fechaRecepcionEnd,
			Long areaId);
	
	public List<RecibidaResponse> buscarPorFechaRequeridaDeRespuesta(Date fechaReqRespStart, Date fechaReqRespEnd);

	public List<RecibidaResponse> buscarPorEstatus(Long estatusId);

	public List<RecibidaResponse> buscarPorPrioridad(Long prioridadId);

	public String max();

	CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento(String referencia);
}
