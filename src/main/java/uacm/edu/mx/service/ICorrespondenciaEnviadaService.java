package uacm.edu.mx.service;

import java.util.Date;
import java.util.List;

import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaEnviada;

public interface ICorrespondenciaEnviadaService {
	
	public RecibidaResponse insertar(CorrespondenciaEnviada correspondenciaEnviada);	
	List<CorrespondenciaEnviada> buscarTodos();
	CorrespondenciaEnviada buscarPorId(String referencia);
    List<CorrespondenciaEnviada> buscarPorFechaEnvio(Date fechaEnvioStart, Date fechaEnvioEnd);
    List<CorrespondenciaEnviada> buscarPorFechaEnvioAndAreaRecibe (Date fechaEnvioStart, Date fechaEnvioEnd , Integer areaId);
    List<CorrespondenciaEnviada> buscarPorEstatus (Integer estatusId);
    List<CorrespondenciaEnviada> buscarPorPrioridad (Integer prioridadId);
    String buscarUltimoConsecutivo(String TipoDeDocumento);

}
