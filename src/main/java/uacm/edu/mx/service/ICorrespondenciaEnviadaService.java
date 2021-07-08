package uacm.edu.mx.service;

import java.util.Date;
import java.util.List;
import uacm.edu.mx.data.EnviadaRequest;
import uacm.edu.mx.data.EnviadaResponse;

public interface ICorrespondenciaEnviadaService {
	
	public EnviadaResponse insertar(EnviadaRequest recibidaRequest);

	public EnviadaResponse buscarPorReferencia(String referenciaDocumento);

	public List<EnviadaResponse> buscarTodas();
	
	 public List<EnviadaResponse> buscarPorFechaEnvio(Date fechaEnvioStart, Date fechaEnvioEnd);
	 
	 public List<EnviadaResponse> buscarPorFechaEnvioAndAreaDestinataria(Date fechaEnvioIni, Date fechaEnvioFin , Integer areaId);
	
	 public List<EnviadaResponse> buscarPorEstatus (Integer estatusId);
	 
	 public List<EnviadaResponse> buscarPorPrioridad (Integer prioridadId);


    String buscarUltimoConsecutivo(String TipoDeDocumento);

}
