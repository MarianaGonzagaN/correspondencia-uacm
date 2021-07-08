package uacm.edu.mx.data;

import java.util.Date;
import lombok.Data;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.Expediente;

@Data
public class EnviadaRequest {
	
	
	private String referenciaDocumento;
	private CatalogoValores idTipoDocumento;
	private Date fechaDocumento;
	private CatalogoValores idMedio;
	private String asunto;
	private CatalogoValores idAreaDestinataria;
	private String nombreDestinatario;
	private CatalogoValores idCargoDestinatario;
	private CatalogoValores idPrioridad;
	/************Anexos*******************/
	private Integer existeAnexo;
	private Integer numeroAnexos;
	private String tipoAnexo;
	private String ubicacionAnexo;
	/************Seguimiento*******************/
	private Date fechaRequeridaRespuesta;
	private CatalogoValores idInstruccion; 
	private String instruccionesAdicionales;
	private CatalogoValores idEstatus;
	private String solucion;
	private Date fechaSolucion;
	private Expediente idExpediente;
	/************************************/
	private String respuestaTurno;
	private Date fechaEnvio; 
	private byte[] documentoEnviado;
	private byte[] documentoRecibido;
	private CatalogoValores idResponsableRecepcionAcuse;
	/***************Datos de los documentos adjuntos********************/
	private String tipoDocumentoEnviado;
	private String nombreDocumentoEnviado;
	private String tipoDocumentoAcuse;
	private String nombreDocumentoAcuse;
}
