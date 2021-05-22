package uacm.edu.mx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter 
@Setter 
public class Correspondencia {
	
	@Id
	@Column(name="referencia_documento")
	private String referenciaDocumento; 
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_documento",referencedColumnName = "id")
	private CatalogoValores idTipoDocumento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_documento")
	private Date fechaDocumento;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_medio",referencedColumnName = "id")
	private CatalogoValores idMedio;
	
	@Column(name="asunto")
	private String asunto;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_area_recibe",referencedColumnName = "id")
	private CatalogoValores idAreaRecibe;
	
	@Column(name="nombre_destinatario")
	private String nombreDestinatario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cargo_destinatario",referencedColumnName = "id")
	private CatalogoValores idCargoDestinatario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prioridad",referencedColumnName = "id")
	private CatalogoValores idPrioridad;
	
	@Column(name="existe_anexo")
	private Integer existeAnexo;
	
	@Column(name="numero_anexos")
	private Integer numeroAnexos;
	
	@Column(name="tipo_anexo")
	private String tipoAnexo;
	

	@Column(name="ubicacion_anexo")
	private String ubicacionAnexo;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_requerida_respuesta")
	private Date fechaRequeridaRespuesta;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_instruccion",referencedColumnName = "id")
	private CatalogoValores idInstruccion; 
	
	@Column(name="instrucciones_adicionales")
	private String instruccionesAdicionales;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_estatus",referencedColumnName = "id")
	private CatalogoValores idEstatus;
	
	@Column(name="solucion")
	private String solucion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_solucion")
	private Date fechaSolucion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_expediente",referencedColumnName = "id_expediente")
	private Expediente expediente;

	
	

}
