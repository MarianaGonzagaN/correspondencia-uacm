package uacm.edu.mx.data;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.Expediente;

@Getter
@Setter
public class RecibidaResponse {

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
	private String turno;
	private String responsableRecepcion;
	private CatalogoValores idAreaRemitente;
	private String nombreRemitente;
	private CatalogoValores idCargoRemitente;
	private Date fechaRecepcion; 
	private byte[] documento;
	private CatalogoValores idTurnadoA;
	private Date fechaTurnado;
	private String tipoDocumentoRecibido;
	private String nombreDocumentoRecibido;
	
	/*
	 * public RecibidaResponse(final String referenciaDocumento, final Date
	 * fechaRecepcion) { this.referenciaDocumento = referenciaDocumento;
	 * this.fechaRecepcion = fechaRecepcion; }
	 */
	public RecibidaResponse() {

		super();
	}
	
	public RecibidaResponse(final String referenciaDocumento, final Date fechaRecepcion) {
		this.referenciaDocumento = referenciaDocumento;
		this.fechaRecepcion = fechaRecepcion;
	}


}
