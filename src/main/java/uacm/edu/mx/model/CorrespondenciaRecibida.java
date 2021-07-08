package uacm.edu.mx.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;



@Data
@Entity
@Table(name = "correspondencia_recibida")
public class CorrespondenciaRecibida extends Correspondencia {

	@NotBlank(message = "el turno es requerido")
	@Size(min = 8, max = 9)
	@Column(name="turno", nullable=false)
	private String turno;
	
	@NotBlank(message = "el responsable de recepción es requerido")
	@Size(max = 100)
	@Column(name="responsable_recepcion",nullable = false, length = 100)
	private String responsableRecepcion;
	
	@NotBlank(message = "área remitente es requerida")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_area_remitente",referencedColumnName = "id", nullable = false)
	private CatalogoValores idAreaRemitente;
	
	@NotBlank(message = "el nombre del remitente es requerido")
	@Size(max = 100)
	@Column(name="nombre_remitente",nullable = false, length= 100)
	private String nombreRemitente;
	
	@NotBlank(message = "el cargo del remitente es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cargo_remitente",referencedColumnName = "id", nullable = false)
	private CatalogoValores idCargoRemitente;
	
	@NotBlank(message = "la fecha de recepción es requerido")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_recepcion",nullable = false)
	private Date fechaRecepcion; 
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] documento;

	@NotBlank(message = "el turnado es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_turnado_a",referencedColumnName = "id", nullable = false)
	private CatalogoValores idTurnadoA;
	
	@NotBlank(message = "la fecha de turnado es requerida")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_turnado",nullable = false)
	private Date fechaTurnado;
	
	@Column(name="tipo_documento_recibido")
	private String tipoDocumentoRecibido;
	
	@Column(name="nombre_documento_recibido")
	private String nombreDocumentoRecibido;
}
