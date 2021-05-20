package uacm.edu.mx.mapper;

import org.springframework.stereotype.Component;

import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;

@Component
public class RecibidaMapper {
	
	public CorrespondenciaRecibida createDataToEnti(RecibidaRequest recibidaData) {
		
		CorrespondenciaRecibida correspondenciaRecibida = new CorrespondenciaRecibida();
		
		correspondenciaRecibida.setAsunto(recibidaData.getAsunto());
		correspondenciaRecibida.setDocumento(null);
		correspondenciaRecibida.setExisteAnexo(null);
		correspondenciaRecibida.setExpediente(null);
		correspondenciaRecibida.setFechaDocumento(null);
		correspondenciaRecibida.setFechaRecepcion(null);
		correspondenciaRecibida.setFechaRequeridaRespuesta(null);
		correspondenciaRecibida.setFechaSolucion(null);
		correspondenciaRecibida.setFechaTurnado(null);
		correspondenciaRecibida.setInstruccionesAdicionales(null);
		correspondenciaRecibida.setNombreDestinatario(null);
		correspondenciaRecibida.setNombreDocumento(null);
		correspondenciaRecibida.setNombreRemitente(null);
		correspondenciaRecibida.setNumeroAnexos(null);
	
		
		return correspondenciaRecibida;
	}
	
	
	
	public CorrespondenciaRecibida dataToEntity(RecibidaRequest recibidaRequest) {
		CorrespondenciaRecibida corrRec = new CorrespondenciaRecibida();
		corrRec.setTurno(recibidaRequest.getTurno());
		return corrRec;
	}
	
	
	public RecibidaResponse EntityToData(CorrespondenciaRecibida corrRec) {

		RecibidaResponse recibidaResponse = new RecibidaResponse(null, null);
		
		recibidaResponse.setReferencia(corrRec.getReferenciaDocumento());
		recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion());
		return recibidaResponse;
	}
	
	
	
		

}
