package uacm.edu.mx.mapper;

import uacm.edu.mx.data.RecibidaRequest;
import uacm.edu.mx.model.CorrespondenciaRecibida;

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

}
