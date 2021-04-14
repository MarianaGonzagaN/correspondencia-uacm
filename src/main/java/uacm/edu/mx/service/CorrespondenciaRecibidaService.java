package uacm.edu.mx.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import uacm.edu.mx.model.CorrespondenciaRecibida;

public interface CorrespondenciaRecibidaService {
	
	void insertar(CorrespondenciaRecibida correspondenciaRecibida);	
	List<CorrespondenciaRecibida> buscarTodos();
	CorrespondenciaRecibida buscarPorId(String referencia);
    List<CorrespondenciaRecibida> buscarPorFechaRecepcion(Date fechaRecepcionStart, Date fechaRecepcionEnd);
    List<CorrespondenciaRecibida> buscarPorFechaRecepcionAndAreaEnvia (Date fechaRecepcionStart, Date fechaRecepcionEnd, Integer areaId);
    List<CorrespondenciaRecibida> buscarPorEstatus (Integer estatusId);
    List<CorrespondenciaRecibida> buscarPorPrioridad (Integer prioridadId);
    List<CorrespondenciaRecibida> buscarPendientesDeSolucion();
    public String max();
    CorrespondenciaRecibida buscarArchivoPorReferenciaDeDocumento (String referencia);
}
