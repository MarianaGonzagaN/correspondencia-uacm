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
import uacm.edu.mx.model.Expediente;

@Data
public class RecibidaRequest {

	private String turno;
	private String responsableRecepcion;
	private String nombreRemitente;
	private Date fechaRecepcion; 
	private byte[] documento;
	private Date fechaTurnado;
	private String tipoDocumento;
	private String nombreDocumento;
	
	private Date fechaDocumento;
	private String asunto;
	private String nombreDestinatario;
	private Integer existeAnexo;
	private Integer numeroAnexos;
	private String tipoAnexo;
	private String ubicacionAnexo;
	private Date fechaRequeridaRespuesta;
	private String instruccionesAdicionales;
	private String solucion;
	private Date fechaSolucion;
	private Expediente expediente;
}