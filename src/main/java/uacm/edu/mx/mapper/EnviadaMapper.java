package uacm.edu.mx.mapper;
import org.springframework.stereotype.Component;
import uacm.edu.mx.data.EnviadaRequest;
import uacm.edu.mx.data.EnviadaResponse;
import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.model.CorrespondenciaEnviada;
import uacm.edu.mx.model.CorrespondenciaRecibida;

@Component
public class EnviadaMapper {
	
	public CorrespondenciaEnviada dataToEntity(EnviadaRequest enviadaRequest) {
		CorrespondenciaEnviada corrEnv = new CorrespondenciaEnviada();
		corrEnv.setReferenciaDocumento(enviadaRequest.getReferenciaDocumento());
		corrEnv.setIdTipoDocumento(enviadaRequest.getIdTipoDocumento());
		corrEnv.setFechaDocumento(enviadaRequest.getFechaDocumento());
		corrEnv.setIdMedio(enviadaRequest.getIdMedio());
		corrEnv.setAsunto(enviadaRequest.getAsunto());
		corrEnv.setIdAreaDestinataria(enviadaRequest.getIdAreaDestinataria());
		corrEnv.setNombreDestinatario(enviadaRequest.getNombreDestinatario());
		corrEnv.setIdCargoDestinatario(enviadaRequest.getIdCargoDestinatario());
		corrEnv.setIdPrioridad(enviadaRequest.getIdPrioridad());
		/*************************Anexo*************************************/
		corrEnv.setExisteAnexo(enviadaRequest.getExisteAnexo());
		corrEnv.setNumeroAnexos(enviadaRequest.getNumeroAnexos());
		corrEnv.setTipoAnexo(enviadaRequest.getTipoAnexo());
		corrEnv.setUbicacionAnexo(enviadaRequest.getUbicacionAnexo());
		/*************************Seguimiento*************************************/
		corrEnv.setFechaRequeridaRespuesta(enviadaRequest.getFechaRequeridaRespuesta());
		corrEnv.setIdInstruccion(enviadaRequest.getIdInstruccion());
		corrEnv.setInstruccionesAdicionales(enviadaRequest.getInstruccionesAdicionales());
		corrEnv.setIdEstatus(enviadaRequest.getIdEstatus());
		corrEnv.setSolucion(enviadaRequest.getSolucion());
		corrEnv.setFechaSolucion(enviadaRequest.getFechaSolucion());
		corrEnv.setIdExpediente(enviadaRequest.getIdExpediente());
		/*******************************************************************************/
		corrEnv.setRespuestaTurno(enviadaRequest.getRespuestaTurno());
		corrEnv.setFechaEnvio(enviadaRequest.getFechaEnvio());
		corrEnv.setDocumentoEnviado(enviadaRequest.getDocumentoEnviado());
		corrEnv.setDocumentoRecibido(enviadaRequest.getDocumentoRecibido());
		corrEnv.setIdResponsableRecepcionAcuse(enviadaRequest.getIdResponsableRecepcionAcuse());
		/*******************************************************************************/
		corrEnv.setTipoDocumentoEnviado(enviadaRequest.getTipoDocumentoEnviado());
		corrEnv.setNombreDocumentoEnviado(enviadaRequest.getNombreDocumentoEnviado());
		corrEnv.setTipoDocumentoAcuse(enviadaRequest.getTipoDocumentoAcuse());
		corrEnv.setNombreDocumentoAcuse(enviadaRequest.getNombreDocumentoAcuse());
		return corrEnv;
	}
	
	public CorrespondenciaEnviada dataToEntityUpdateDoc(CorrespondenciaEnviada corrEnv, byte[] contenido, String tipoDoc,
			String nombreDoc) {
		corrEnv.setReferenciaDocumento(corrEnv.getReferenciaDocumento());
		corrEnv.setIdTipoDocumento(corrEnv.getIdTipoDocumento());
		corrEnv.setFechaDocumento(corrEnv.getFechaDocumento());
		corrEnv.setIdMedio(corrEnv.getIdMedio());
		corrEnv.setAsunto(corrEnv.getAsunto());
		corrEnv.setIdAreaDestinataria(corrEnv.getIdAreaDestinataria());
		corrEnv.setNombreDestinatario(corrEnv.getNombreDestinatario());
		corrEnv.setIdCargoDestinatario(corrEnv.getIdCargoDestinatario());
		corrEnv.setIdPrioridad(corrEnv.getIdPrioridad());
		/*************************Anexo*************************************/
		corrEnv.setExisteAnexo(corrEnv.getExisteAnexo());
		corrEnv.setNumeroAnexos(corrEnv.getNumeroAnexos());
		corrEnv.setTipoAnexo(corrEnv.getTipoAnexo());
		corrEnv.setUbicacionAnexo(corrEnv.getUbicacionAnexo());
		/*************************Seguimiento*************************************/
		corrEnv.setFechaRequeridaRespuesta(corrEnv.getFechaRequeridaRespuesta());
		corrEnv.setIdInstruccion(corrEnv.getIdInstruccion());
		corrEnv.setInstruccionesAdicionales(corrEnv.getInstruccionesAdicionales());
		corrEnv.setIdEstatus(corrEnv.getIdEstatus());
		corrEnv.setSolucion(corrEnv.getSolucion());
		corrEnv.setFechaSolucion(corrEnv.getFechaSolucion());
		corrEnv.setIdExpediente(corrEnv.getIdExpediente());
		/*******************************************************************************/
		corrEnv.setRespuestaTurno(corrEnv.getRespuestaTurno());
		corrEnv.setFechaEnvio(corrEnv.getFechaEnvio());
		corrEnv.setDocumentoEnviado(contenido);
		corrEnv.setDocumentoRecibido(corrEnv.getDocumentoRecibido());
		corrEnv.setIdResponsableRecepcionAcuse(corrEnv.getIdResponsableRecepcionAcuse());
		/*******************************************************************************/
		corrEnv.setTipoDocumentoEnviado(tipoDoc);
		corrEnv.setNombreDocumentoEnviado(nombreDoc);
		corrEnv.setTipoDocumentoAcuse(corrEnv.getTipoDocumentoAcuse());
		corrEnv.setNombreDocumentoAcuse(corrEnv.getNombreDocumentoAcuse());
		return corrEnv;
	}
	
	public CorrespondenciaEnviada dataToEntityUpdateDocAcuse(CorrespondenciaEnviada corrEnv, byte[] contenido, String tipoDoc,
			String nombreDoc) {
		corrEnv.setReferenciaDocumento(corrEnv.getReferenciaDocumento());
		corrEnv.setIdTipoDocumento(corrEnv.getIdTipoDocumento());
		corrEnv.setFechaDocumento(corrEnv.getFechaDocumento());
		corrEnv.setIdMedio(corrEnv.getIdMedio());
		corrEnv.setAsunto(corrEnv.getAsunto());
		corrEnv.setIdAreaDestinataria(corrEnv.getIdAreaDestinataria());
		corrEnv.setNombreDestinatario(corrEnv.getNombreDestinatario());
		corrEnv.setIdCargoDestinatario(corrEnv.getIdCargoDestinatario());
		corrEnv.setIdPrioridad(corrEnv.getIdPrioridad());
		/*************************Anexo*************************************/
		corrEnv.setExisteAnexo(corrEnv.getExisteAnexo());
		corrEnv.setNumeroAnexos(corrEnv.getNumeroAnexos());
		corrEnv.setTipoAnexo(corrEnv.getTipoAnexo());
		corrEnv.setUbicacionAnexo(corrEnv.getUbicacionAnexo());
		/*************************Seguimiento*************************************/
		corrEnv.setFechaRequeridaRespuesta(corrEnv.getFechaRequeridaRespuesta());
		corrEnv.setIdInstruccion(corrEnv.getIdInstruccion());
		corrEnv.setInstruccionesAdicionales(corrEnv.getInstruccionesAdicionales());
		corrEnv.setIdEstatus(corrEnv.getIdEstatus());
		corrEnv.setSolucion(corrEnv.getSolucion());
		corrEnv.setFechaSolucion(corrEnv.getFechaSolucion());
		corrEnv.setIdExpediente(corrEnv.getIdExpediente());
		/*******************************************************************************/
		corrEnv.setRespuestaTurno(corrEnv.getRespuestaTurno());
		corrEnv.setFechaEnvio(corrEnv.getFechaEnvio());
		corrEnv.setDocumentoEnviado(corrEnv.getDocumentoEnviado());
		corrEnv.setDocumentoRecibido(contenido);
		corrEnv.setIdResponsableRecepcionAcuse(corrEnv.getIdResponsableRecepcionAcuse());
		/*******************************************************************************/
		corrEnv.setTipoDocumentoEnviado(corrEnv.getTipoDocumentoEnviado());
		corrEnv.setNombreDocumentoEnviado(corrEnv.getNombreDocumentoEnviado());
		corrEnv.setTipoDocumentoAcuse(tipoDoc);
		corrEnv.setNombreDocumentoAcuse(nombreDoc);
		return corrEnv;
	}
	
	public EnviadaResponse EntityToData(CorrespondenciaEnviada corrEnv) {
		EnviadaResponse enviadaResponse = new EnviadaResponse();
		enviadaResponse.setReferenciaDocumento(corrEnv.getReferenciaDocumento());
		enviadaResponse.setIdTipoDocumento(corrEnv.getIdTipoDocumento());
		enviadaResponse.setFechaDocumento(corrEnv.getFechaDocumento());
		enviadaResponse.setIdMedio(corrEnv.getIdMedio());
		enviadaResponse.setAsunto(corrEnv.getAsunto());
		enviadaResponse.setIdAreaDestinataria(corrEnv.getIdAreaDestinataria());
		enviadaResponse.setNombreDestinatario(corrEnv.getNombreDestinatario());
		enviadaResponse.setIdCargoDestinatario(corrEnv.getIdCargoDestinatario());
		enviadaResponse.setIdPrioridad(corrEnv.getIdPrioridad());
		/*************************Anexo*************************************/
		enviadaResponse.setExisteAnexo(corrEnv.getExisteAnexo());
		enviadaResponse.setNumeroAnexos(corrEnv.getNumeroAnexos());
		enviadaResponse.setTipoAnexo(corrEnv.getTipoAnexo());
		enviadaResponse.setUbicacionAnexo(corrEnv.getUbicacionAnexo());
		/*************************Seguimiento*************************************/
		enviadaResponse.setFechaRequeridaRespuesta(corrEnv.getFechaRequeridaRespuesta());
		enviadaResponse.setIdInstruccion(corrEnv.getIdInstruccion());
		enviadaResponse.setInstruccionesAdicionales(corrEnv.getInstruccionesAdicionales());
		enviadaResponse.setIdEstatus(corrEnv.getIdEstatus());
		enviadaResponse.setSolucion(corrEnv.getSolucion());
		enviadaResponse.setFechaSolucion(corrEnv.getFechaSolucion());
		enviadaResponse.setIdExpediente(corrEnv.getIdExpediente());
		/*******************************************************************************/
		enviadaResponse.setRespuestaTurno(corrEnv.getRespuestaTurno());
		enviadaResponse.setFechaEnvio(corrEnv.getFechaEnvio());
		enviadaResponse.setDocumentoEnviado(corrEnv.getDocumentoEnviado());
		enviadaResponse.setDocumentoRecibido(corrEnv.getDocumentoRecibido());
		enviadaResponse.setIdResponsableRecepcionAcuse(corrEnv.getIdResponsableRecepcionAcuse());
		return enviadaResponse;
	}
		
	 public EnviadaResponse enviadaResponse(CorrespondenciaEnviada corrEnv) {
	 EnviadaResponse enviadaResponse = new EnviadaResponse(null, null);
	 enviadaResponse.setReferenciaDocumento(corrEnv.getReferenciaDocumento());
	 enviadaResponse.setFechaEnvio(corrEnv.getFechaEnvio()); return
			 enviadaResponse; }

		public CorrespondenciaEnviada dataToEntityUpdate(EnviadaRequest enviadaRequest, CorrespondenciaEnviada corrEnv) {
			corrEnv.setReferenciaDocumento(enviadaRequest.getReferenciaDocumento());
			corrEnv.setIdTipoDocumento(enviadaRequest.getIdTipoDocumento());
			corrEnv.setFechaDocumento(enviadaRequest.getFechaDocumento());
			corrEnv.setIdMedio(enviadaRequest.getIdMedio());
			corrEnv.setAsunto(enviadaRequest.getAsunto());
			corrEnv.setIdAreaDestinataria(enviadaRequest.getIdAreaDestinataria());
			corrEnv.setNombreDestinatario(enviadaRequest.getNombreDestinatario());
			corrEnv.setIdCargoDestinatario(enviadaRequest.getIdCargoDestinatario());
			corrEnv.setIdPrioridad(enviadaRequest.getIdPrioridad());
			/*************************Anexo*************************************/
			corrEnv.setExisteAnexo(enviadaRequest.getExisteAnexo());
			corrEnv.setNumeroAnexos(enviadaRequest.getNumeroAnexos());
			corrEnv.setTipoAnexo(enviadaRequest.getTipoAnexo());
			corrEnv.setUbicacionAnexo(enviadaRequest.getUbicacionAnexo());
			/*************************Seguimiento*************************************/
			corrEnv.setFechaRequeridaRespuesta(enviadaRequest.getFechaRequeridaRespuesta());
			corrEnv.setIdInstruccion(enviadaRequest.getIdInstruccion());
			corrEnv.setInstruccionesAdicionales(enviadaRequest.getInstruccionesAdicionales());
			corrEnv.setIdEstatus(enviadaRequest.getIdEstatus());
			corrEnv.setSolucion(enviadaRequest.getSolucion());
			corrEnv.setFechaSolucion(enviadaRequest.getFechaSolucion());
			corrEnv.setIdExpediente(enviadaRequest.getIdExpediente());
			/*******************************************************************************/
			corrEnv.setRespuestaTurno(enviadaRequest.getRespuestaTurno());
			corrEnv.setFechaEnvio(enviadaRequest.getFechaEnvio());
			corrEnv.setDocumentoEnviado(enviadaRequest.getDocumentoEnviado());
			corrEnv.setDocumentoRecibido(enviadaRequest.getDocumentoRecibido());
			corrEnv.setIdResponsableRecepcionAcuse(enviadaRequest.getIdResponsableRecepcionAcuse());
			/*******************************************************************************/
			corrEnv.setTipoDocumentoEnviado(enviadaRequest.getTipoDocumentoEnviado());
			corrEnv.setNombreDocumentoEnviado(enviadaRequest.getNombreDocumentoEnviado());
			corrEnv.setTipoDocumentoAcuse(enviadaRequest.getTipoDocumentoAcuse());
			corrEnv.setNombreDocumentoAcuse(enviadaRequest.getNombreDocumentoAcuse());
			return corrEnv;
		}
		
	 
	
}
