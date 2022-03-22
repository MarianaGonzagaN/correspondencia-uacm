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
		recibidaResponse.setTipoDocumentoRecibido(corrRec.getTipoDocumentoRecibido());
		recibidaResponse.setNombreDocumentoRecibido(corrRec.getNombreDocumentoRecibido());
		return recibidaResponse;
	}
		
	
	 public RecibidaResponse recibidaResponse(CorrespondenciaRecibida corrRec) {
	 RecibidaResponse recibidaResponse = new RecibidaResponse(null, null);
	 recibidaResponse.setReferenciaDocumento(corrRec.getReferenciaDocumento());
	 recibidaResponse.setFechaRecepcion(corrRec.getFechaRecepcion()); return
	 recibidaResponse; 
	 }
	 
	 public CorrespondenciaRecibida dataToEntityUpdate( RecibidaRequest recibidaRequest, CorrespondenciaRecibida corrRec) {
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
	 
	 
	 public CorrespondenciaRecibida dataToEntityUpdateDoc( CorrespondenciaRecibida corrRec, byte[] contenido, String tipoDoc,
				String nombreDoc) {
			corrRec.setReferenciaDocumento(corrRec.getReferenciaDocumento());
			corrRec.setIdTipoDocumento(corrRec.getIdTipoDocumento());
			corrRec.setFechaDocumento(corrRec.getFechaDocumento());
			corrRec.setIdMedio(corrRec.getIdMedio());
			corrRec.setAsunto(corrRec.getAsunto());
			corrRec.setIdAreaDestinataria(corrRec.getIdAreaDestinataria());
			corrRec.setNombreDestinatario(corrRec.getNombreDestinatario());
			corrRec.setIdCargoDestinatario(corrRec.getIdCargoDestinatario());
			corrRec.setIdPrioridad(corrRec.getIdPrioridad());
			/*********************Anexos******************************************/
			corrRec.setExisteAnexo(corrRec.getExisteAnexo());
			corrRec.setNumeroAnexos(corrRec.getNumeroAnexos());
			corrRec.setTipoAnexo(corrRec.getTipoAnexo());
			corrRec.setUbicacionAnexo(corrRec.getUbicacionAnexo());
			/*************************Seguimiento**************************************/
			corrRec.setFechaRequeridaRespuesta(corrRec.getFechaRequeridaRespuesta());
			corrRec.setIdInstruccion(corrRec.getIdInstruccion());
			corrRec.setInstruccionesAdicionales(corrRec.getInstruccionesAdicionales());
			corrRec.setIdEstatus(corrRec.getIdEstatus());
			corrRec.setSolucion(corrRec.getSolucion());
			corrRec.setFechaSolucion(corrRec.getFechaSolucion());
			corrRec.setIdExpediente(corrRec.getIdExpediente());
			/**********************************************************************/
			corrRec.setTurno(corrRec.getTurno());
			corrRec.setResponsableRecepcion(corrRec.getResponsableRecepcion());
			corrRec.setIdAreaRemitente(corrRec.getIdAreaRemitente());
			corrRec.setNombreRemitente(corrRec.getNombreRemitente());
			corrRec.setIdCargoRemitente(corrRec.getIdCargoRemitente());
			corrRec.setFechaRecepcion(corrRec.getFechaRecepcion());
			corrRec.setDocumento(contenido);
			corrRec.setIdTurnadoA(corrRec.getIdTurnadoA());
			corrRec.setFechaTurnado(corrRec.getFechaTurnado());
			corrRec.setTipoDocumentoRecibido(tipoDoc);
			corrRec.setNombreDocumentoRecibido(nombreDoc);
			return corrRec;
		}
	 
	
}
