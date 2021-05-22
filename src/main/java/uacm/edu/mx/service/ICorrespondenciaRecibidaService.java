package uacm.edu.mx.service;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;

public interface ICorrespondenciaRecibidaService {
	
	public RecibidaResponse insertar(RecibidaRequest recibidaRequest);

	public RecibidaResponse buscarPorId(String referencia);

	public List<RecibidaResponse> buscarTodas();

	public List<RecibidaResponse> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd);

	public List<RecibidaResponse> buscarPorFechaRecepcionAndAreaEnvia(Date fechaRecepcionStart, Date fechaRecepcionEnd,
			Integer areaId);

	public List<RecibidaResponse> buscarPorEstatus(Integer estatusId);

	public List<RecibidaResponse> buscarPorPrioridad(Integer prioridadId);

	public String max();

	CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento(String referencia);
}
