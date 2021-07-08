package uacm.edu.mx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@MappedSuperclass
public class Correspondencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_correspondencia")
	private Long idCorrespondencia;
	
	@NotBlank(message = "la referencia de documento es requerida")
	@Size(max = 255)
	@Column(name="referencia",unique=true,nullable = false, length = 255)
	private String referenciaDocumento; 
	
	@NotBlank(message = "el tipo de documento es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_documento",referencedColumnName = "id",nullable = false)
	private CatalogoValores idTipoDocumento;
	
	@NotBlank(message = "fecha de docuemento es requerida")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_documento",nullable = false)
	private Date fechaDocumento;
	
	@NotBlank(message = "el medio es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_medio",referencedColumnName = "id", nullable = false)
	private CatalogoValores idMedio;
	
	@NotBlank(message = "el asunto es requerido")
	@Size(max = 255)
	@Column(name="asunto",nullable = false, length = 255)
	private String asunto;
	
	@NotBlank(message = "área destinataria es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_area_destinataria",referencedColumnName = "id", nullable = false)
	private CatalogoValores idAreaDestinataria;
	
	@NotBlank(message = "nombre del destinatario es requerido")
	@Size(max = 100)
	@Column(name="nombre_destinatario", nullable = false, length = 100)
	private String nombreDestinatario;
	
	@NotBlank(message = "cargo del destinatario es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cargo_destinatario",referencedColumnName = "id", nullable = false)
	private CatalogoValores idCargoDestinatario;
	
	@NotBlank(message = "la prioridad es requerida")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prioridad",referencedColumnName = "id", nullable = false)
	private CatalogoValores idPrioridad;
	
	
	@NotBlank(message = "existe anexo es requerido")
	@Column(name="existe_anexo",nullable = false)
	private Integer existeAnexo;
	
	@Column(name="numero_anexos", nullable = true)
	private Integer numeroAnexos;
	
	@Size(max = 100)
	@Column(name="tipo_anexo", nullable = true, length = 100)
	private String tipoAnexo;
	
	@Size(max = 100)
	@Column(name="ubicacion_anexo", nullable = true , length = 100)
	private String ubicacionAnexo;
	
	@NotBlank(message = "fecha requerida de respuesta es obligatoria")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_requerida_respuesta", nullable = false)
	private Date fechaRequeridaRespuesta;
	
	@NotBlank(message = "la instrucción es obligatoria")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_instruccion",referencedColumnName = "id", nullable = false)
	private CatalogoValores idInstruccion; 
	
	@Size(max=255)
	@Column(name="instrucciones_adicionales", nullable =true, length = 255)
	private String instruccionesAdicionales;
	
	@NotBlank(message = "el estatus es obligatorio")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_estatus",referencedColumnName = "id", nullable = false)
	private CatalogoValores idEstatus;
	
	@Size(max=255)
	@Column(name="solucion",nullable =true, length = 255)
	private String solucion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_solucion",nullable =true)
	private Date fechaSolucion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_expediente",referencedColumnName = "id_expediente", nullable = false)
	private Expediente idExpediente;

}
