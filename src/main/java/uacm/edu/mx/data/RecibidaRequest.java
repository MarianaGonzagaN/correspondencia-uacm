package uacm.edu.mx.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.Expediente;

@Data
public class RecibidaRequest {

	private String referenciaDocumento;
	private CatalogoValores idTipoDocumento;
	private Date fechaDocumento;
	private CatalogoValores idMedio;
	private String asunto;
	private CatalogoValores idAreaRecibe;
	private String nombreDestinatario;
	private CatalogoValores idCargoDestinatario;
	private CatalogoValores idPrioridad;
	private Integer existeAnexo;
	private Integer numeroAnexos;
	private String tipoAnexo;
	private String ubicacionAnexo;
	private Date fechaRequeridaRespuesta;
	private CatalogoValores idInstruccion; 
	private String instruccionesAdicionales;
	private CatalogoValores idEstatus;
	private String solucion;
	private Date fechaSolucion;
	private Expediente expediente;
	/************************************/
	private String turno;
	private String responsableRecepcion;
	private String nombreRemitente;
	private Date fechaRecepcion; 
	private byte[] documento;
	private Date fechaTurnado;
	private String tipoDocumento;
	private String nombreDocumento;
}
