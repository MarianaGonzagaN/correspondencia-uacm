package uacm.edu.mx.mapper;
import org.springframework.stereotype.Component;
import uacm.edu.mx.data.EnviadaRequest;
import uacm.edu.mx.data.EnviadaResponse;
import uacm.edu.mx.model.CorrespondenciaEnviada;

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
	 
	
}
