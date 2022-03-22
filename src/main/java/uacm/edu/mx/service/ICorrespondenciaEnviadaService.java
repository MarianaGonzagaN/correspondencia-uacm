package uacm.edu.mx.service;

import java.util.Date;
import java.util.List;
import uacm.edu.mx.data.EnviadaRequest;
import uacm.edu.mx.data.EnviadaResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;

public interface ICorrespondenciaEnviadaService {
	
	public EnviadaResponse insertar(EnviadaRequest enviadaRequest);

	public EnviadaResponse buscarPorReferencia(String referenciaDocumento);
	
	public EnviadaResponse updateCorrEnviada(EnviadaRequest enviadaRequest, String  referencia);
	
	public EnviadaResponse updateGuardarArchivo( String  referencia, byte[] contenido,
			String tipoDoc, String nombreDoc);
	
	public EnviadaResponse updateGuardarAcuse( String  referencia, byte[] contenido,
			String tipoDoc, String nombreDoc);

	public List<EnviadaResponse> buscarTodas();
	
	 public List<EnviadaResponse> buscarPorFechaEnvio(Date fechaEnvioStart, Date fechaEnvioEnd);
	 
	 public List<EnviadaResponse> buscarPorFechaEnvioAndAreaDestinataria(Date fechaEnvioIni, Date fechaEnvioFin , Long areaId);
	
	 public List<EnviadaResponse> buscarPorEstatus (Long estatusId);
	 
	 public List<EnviadaResponse> buscarPorPrioridad (Long prioridadId);


    String buscarUltimoConsecutivo(String TipoDeDocumento);

}
