package uacm.edu.mx.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RecibidaResponse {

	private Long id;
	private String turno;
	private String responsableRecepcion;
	private String nombreRemitente;
	private Date fechaRecepcion; 
	private byte[] documento;
	private Date fechaTurnado;
	private String tipoDocumento;
	private String nombreDocumento;
	
}
