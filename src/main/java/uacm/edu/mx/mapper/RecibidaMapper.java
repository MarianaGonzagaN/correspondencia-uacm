package uacm.edu.mx.mapper;
import org.springframework.stereotype.Component;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.data.RecibidaResponse;
import uacm.edu.mx.model.CorrespondenciaRecibida;

@Component
public class RecibidaMapper {
	
	public CorrespondenciaRecibida dataToEntity(RecibidaRequest recibidaRequest) {
		CorrespondenciaRecibida corrRec = new CorrespondenciaRecibida();
		corrRec.setReferenciaDocumento(recibidaRequest.getReferenciaDocumento());
		corrRec.setIdTipoDocumento(recibidaRequest.getIdTipoDocumento());
		corrRec.setFechaDocumento(recibidaRequest.getFechaDocumento());
		corrRec.setIdMedio(recibidaRequest.getIdMedio());
		corrRec.setAsunto(recibidaRequest.getAsunto());
		corrRec.setIdAreaDestinataria(recibidaRequest.getIdAreaDestinataria());
		corrRec.setNombreDestinatario(recibidaRequest.getNombreDestinatario());
		corrRec.setIdCargoDestinatario(recibidaRequest.getIdCargoDestinatario());
		corrRec.setIdPrioridad(recibidaRequest.getIdPrioridad());
		/*********************Anexos******************************************/
		corrRec.setExisteAnexo(recibidaRequest.getExisteAnexo());
		corrRec.setNumeroAnexos(recibidaRequest.getNumeroAnexos());
		corrRec.setTipoAnexo(recibidaRequest.getTipoAnexo());
		corrRec.setUbicacionAnexo(recibidaRequest.getUbicacionAnexo());
		/*************************Seguimiento**************************************/
		corrRec.setFechaRequeridaRespuesta(recibidaRequest.getFechaRequeridaRespuesta());
		corrRec.setIdInstruccion(recibidaRequest.getIdInstruccion());
		corrRec.setInstruccionesAdicionales(recibidaRequest.getInstruccionesAdicionales());
		corrRec.setIdEstatus(recibidaRequest.getIdEstatus());
		corrRec.setSolucion(recibidaRequest.getSolucion());
		corrRec.setFechaSolucion(recibidaRequest.getFechaSolucion());
		corrRec.setIdExpediente(recibidaRequest.getIdExpediente());
		/**********************************************************************/
		corrRec.setTurno(recibidaRequest.getTurno());
		corrRec.setResponsableRecepcion(recibidaRequest.getResponsableRecepcion());
		corrRec.setIdAreaRemitente(recibidaRequest.getIdAreaRemitente());
		corrRec.setNombreRemitente(recibidaRequest.getNombreRemitente());
		corrRec.setIdCargoRemitente(recibidaRequest.getIdCargoRemitente());
		corrRec.setFechaRecepcion(recibidaRequest.getFechaRecepcion());
		corrRec.setDocumento(recibidaRequest.getDocumento());
		corrRec.setIdTurnadoA(recibidaRequest.getIdTurnadoA());
		corrRec.setFechaTurnado(recibidaRequest.getFechaTurnado());
		corrRec.setTipoDocumentoRecibido(recibidaRequest.getTipoDocumentoRecibido());
		corrRec.setNombreDocumentoRecibido(recibidaRequest.getNombreDocumentoRecibido());
		return corrRec;
	}
	
	public RecibidaResponse EntityToData(CorrespondenciaRecibida corrRec) {
		RecibidaResponse recibidaResponse = new RecibidaResponse();
		recibidaResponse.setReferenciaDocumento(corrRec.getReferenciaDocumento());
		recibidaResponse.setIdTipoDocumento(corrRec.getIdTipoDocumento());
		recibidaResponse.setFechaDocumento(corrRec.getFechaDocumento());
		recibidaResponse.setIdMedio(corrRec.getIdMedio());
		recibidaResponse.setAsunto(corrRec.getAsunto());
		recibidaResponse.setIdAreaDestinataria(corrRec.getIdAreaDestinataria());
		recibidaResponse.setNombreDestinatario(corrRec.getNombreDestinatario());
		recibidaResponse.setIdCargoDestinatario(corrRec.getIdCargoDestinatario());
		recibidaResponse.setIdPrioridad(corrRec.getIdPrioridad());
		/*********************Anexos******************************************/
		recibidaResponse.setExisteAnexo(corrRec.getExisteAnexo());
		recibidaResponse.setNumeroAnexos(corrRec.getNumeroAnexos());
		recibidaResponse.setTipoAnexo(corrRec.getTipoAnexo());
		recibidaResponse.setUbicacionAnexo(corrRec.getUbicacionAnexo());
		/*************************Seguimiento**************************************/
		recibidaResponse.setFechaRequeridaRespuesta(corrRec.getFechaRequeridaRespuesta());
		recibidaResponse.setIdInstruccion(corrRec.getIdInstruccion());
		recibidaResponse.setInstruccionesAdicionales(corrRec.getInstruccionesAdicionales());
		recibidaResponse.setIdEstatus(corrRec.getIdEstatus());
		recibidaResponse.setSolucion(corrRec.getSolucion());
		recibidaResponse.setFechaSolucion(corrRec.getFechaSolucion());
		recibidaResponse.setIdExpediente(corrRec.getIdExpediente());
		/**********************************************************************/
		recibidaResponse.setTurno(corrRec.getTurno());
		recibidaResponse.setResponsableRecepcion(corrRec.getResponsableRecepcion());
		recibidaResponse.setIdAreaRemitente(corrRec.getIdAreaRemitente());
		recibidaResponse.setNombreRemitente(corrRec.getNombreRemitente());
		recibidaResponse.setIdCargoRemitente(corrRec.getIdCargoRemitente());
		recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion());
		recibidaResponse.setDocumento(corrRec.getDocumento());
		recibidaResponse.setIdTurnadoA(corrRec.getIdTurnadoA());
		recibidaResponse.setFechaTurnado(corrRec.getFechaTurnado());
		return recibidaResponse;
	}
		
	/*
	 * public RecibidaResponse recibidaResponse(CorrespondenciaRecibida corrRec) {
	 * RecibidaResponse recibidaResponse = new RecibidaResponse(null, null);
	 * recibidaResponse.setReferenciaDocumento(corrRec.getReferenciaDocumento());
	 * recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion()); return
	 * recibidaResponse; }
	 */
	
}
