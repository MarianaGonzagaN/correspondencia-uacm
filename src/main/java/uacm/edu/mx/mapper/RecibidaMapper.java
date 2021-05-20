package uacm.edu.mx.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.model.Expediente;

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
		
		corrRec.setReferenciaDocumento(recibidaRequest.getReferenciaDocumento());
		corrRec.setIdTipoDocumento(recibidaRequest.getIdTipoDocumento());
		corrRec.setFechaDocumento(recibidaRequest.getFechaDocumento());
		corrRec.setFechaRecepcion(recibidaRequest.getFechaRecepcion());
		corrRec.setIdMedio(recibidaRequest.getIdMedio());
		corrRec.setAsunto(recibidaRequest.getAsunto());
		corrRec.setIdAreaRecibe(recibidaRequest.getIdAreaRecibe());
		corrRec.setNombreDestinatario(recibidaRequest.getNombreDestinatario());
		corrRec.setIdCargoDestinatario(recibidaRequest.getIdCargoDestinatario());
		corrRec.setIdPrioridad(recibidaRequest.getIdPrioridad());
		corrRec.setExisteAnexo(recibidaRequest.getExisteAnexo());
		corrRec.setNumeroAnexos(recibidaRequest.getNumeroAnexos());
		corrRec.setTipoAnexo(recibidaRequest.getTipoAnexo());
		corrRec.setUbicacionAnexo(recibidaRequest.getUbicacionAnexo());
		corrRec.setFechaRequeridaRespuesta(recibidaRequest.getFechaRequeridaRespuesta());
		corrRec.setIdInstruccion(recibidaRequest.getIdInstruccion());
		corrRec.setInstruccionesAdicionales(recibidaRequest.getInstruccionesAdicionales());
		corrRec.setIdEstatus(recibidaRequest.getIdEstatus());
		corrRec.setSolucion(recibidaRequest.getSolucion());
		corrRec.setFechaSolucion(recibidaRequest.getFechaSolucion());
		corrRec.setExpediente(recibidaRequest.getExpediente());
		corrRec.setTurno(recibidaRequest.getTurno());
		corrRec.setResponsableRecepcion(recibidaRequest.getResponsableRecepcion());
		corrRec.setNombreRemitente(recibidaRequest.getNombreRemitente());
		corrRec.setFechaRecepcion(recibidaRequest.getFechaRecepcion());
		corrRec.setDocumento(recibidaRequest.getDocumento());
		corrRec.setFechaTurnado(recibidaRequest.getFechaTurnado());
		corrRec.setTipoDocumento(recibidaRequest.getTipoDocumento());
		corrRec.setNombreDocumento(recibidaRequest.getNombreDocumento());
		return corrRec;
	}
	
	
	public RecibidaResponse EntityToData(CorrespondenciaRecibida corrRec) {

		RecibidaResponse recibidaResponse = new RecibidaResponse();
		
		recibidaResponse.setReferencia(corrRec.getReferenciaDocumento());
		recibidaResponse.setIdTipoDocumento(corrRec.getIdTipoDocumento());
		recibidaResponse.setFechaDocumento(corrRec.getFechaDocumento());
		recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion());
		recibidaResponse.setIdMedio(corrRec.getIdMedio());
		recibidaResponse.setAsunto(corrRec.getAsunto());
		recibidaResponse.setIdAreaRecibe(corrRec.getIdAreaRecibe());
		recibidaResponse.setNombreDestinatario(corrRec.getNombreDestinatario());
		recibidaResponse.setIdCargoDestinatario(corrRec.getIdCargoDestinatario());
		recibidaResponse.setIdPrioridad(corrRec.getIdPrioridad());
		recibidaResponse.setExisteAnexo(corrRec.getExisteAnexo());
		recibidaResponse.setNumeroAnexos(corrRec.getNumeroAnexos());
		recibidaResponse.setTipoAnexo(corrRec.getTipoAnexo());
		recibidaResponse.setUbicacionAnexo(corrRec.getUbicacionAnexo());
		recibidaResponse.setFechaRequeridaRespuesta(corrRec.getFechaRequeridaRespuesta());
		recibidaResponse.setIdInstruccion(corrRec.getIdInstruccion());
		recibidaResponse.setInstruccionesAdicionales(corrRec.getInstruccionesAdicionales());
		recibidaResponse.setIdEstatus(corrRec.getIdEstatus());
		recibidaResponse.setSolucion(corrRec.getSolucion());
		recibidaResponse.setFechaSolucion(corrRec.getFechaSolucion());
		recibidaResponse.setExpediente(corrRec.getExpediente());
		recibidaResponse.setTurno(corrRec.getTurno());
		recibidaResponse.setResponsableRecepcion(corrRec.getResponsableRecepcion());
		recibidaResponse.setNombreRemitente(corrRec.getNombreRemitente());
		recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion());
		recibidaResponse.setDocumento(corrRec.getDocumento());
		recibidaResponse.setFechaTurnado(corrRec.getFechaTurnado());
		recibidaResponse.setTipoDocumento(corrRec.getTipoDocumento());
		recibidaResponse.setNombreDocumento(corrRec.getNombreDocumento());
		return recibidaResponse;
	}
		
	public RecibidaResponse recibidaResponse(CorrespondenciaRecibida corrRec) {

		RecibidaResponse recibidaResponse = new RecibidaResponse(null, null);
		
		recibidaResponse.setReferencia(corrRec.getReferenciaDocumento());
		recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion());
		return recibidaResponse;
	}
	
	
	
		

}
