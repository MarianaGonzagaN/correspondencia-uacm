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

@MappedSuperclass
public class CorrespondenciaBaseEntity {
	
	@Id
	@Column(name="referencia_documento")
	private String referenciaDocumento; 
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_tipo_documento",referencedColumnName = "id")
	private TipoDocumento idTipoDocumento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_documento")
	private Date fechaDocumento;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_medio",referencedColumnName = "id")
	private Medio idMedio;
	
	@Column(name="asunto")
	private String asunto;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_area_recibe",referencedColumnName = "id")
	private Area idAreaRecibe;
	
	@Column(name="nombre_destinatario")
	private String nombreDestinatario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cargo_destinatario",referencedColumnName = "id")
	private Cargo idCargoDestinatario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_prioridad",referencedColumnName = "id")
	private Prioridad idPrioridad;
	
	@Column(name="existe_anexo")
	private Integer existeAnexo;
	
	@Column(name="numero_anexos")
	private Integer numeroAnexos;
	
	@Column(name="tipo_anexo")
	private String tipoAnexo;
	

	@Column(name="ubicacion_anexo",nullable = false)
	private String ubicacionAnexo;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_requerida_respuesta",nullable = false)
	private Date fechaRequeridaRespuesta;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_instruccion",referencedColumnName = "id")
	private Instruccion idInstruccion; 
	
	@Column(name="instrucciones_adicionales")
	private String instruccionesAdicionales;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_estatus",referencedColumnName = "id")
	private Estatus idEstatus;
	
	@Column(name="solucion")
	private String solucion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_solucion")
	private Date fechaSolucion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_expediente",referencedColumnName = "id_expediente")
	private Expediente expediente;

	public String getReferenciaDocumento() {
		return referenciaDocumento;
	}

	public void setReferenciaDocumento(String referenciaDocumento) {
		this.referenciaDocumento = referenciaDocumento;
	}

	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Medio getIdMedio() {
		return idMedio;
	}

	public void setIdMedio(Medio idMedio) {
		this.idMedio = idMedio;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Area getIdAreaRecibe() {
		return idAreaRecibe;
	}

	public void setIdAreaRecibe(Area idAreaRecibe) {
		this.idAreaRecibe = idAreaRecibe;
	}

	public String getNombreDestinatario() {
		return nombreDestinatario;
	}

	public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario = nombreDestinatario;
	}

	public Cargo getIdCargoDestinatario() {
		return idCargoDestinatario;
	}

	public void setIdCargoDestinatario(Cargo idCargoDestinatario) {
		this.idCargoDestinatario = idCargoDestinatario;
	}

	public Prioridad getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(Prioridad idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public Integer getExisteAnexo() {
		return existeAnexo;
	}

	public void setExisteAnexo(Integer existeAnexo) {
		this.existeAnexo = existeAnexo;
	}

	public Integer getNumeroAnexos() {
		return numeroAnexos;
	}

	public void setNumeroAnexos(Integer numeroAnexos) {
		this.numeroAnexos = numeroAnexos;
	}
	
	public String getTipoAnexo() {
		return tipoAnexo;
	}

	public void setTipoAnexo(String tipoAnexo) {
		this.tipoAnexo = tipoAnexo;
	}

	public String getUbicacionAnexo() {
		return ubicacionAnexo;
	}

	public void setUbicacionAnexo(String ubicacionAnexo) {
		this.ubicacionAnexo = ubicacionAnexo;
	}


	public Date getFechaRequeridaRespuesta() {
		return fechaRequeridaRespuesta;
	}

	public void setFechaRequeridaRespuesta(Date fechaRequeridaRespuesta) {
		this.fechaRequeridaRespuesta = fechaRequeridaRespuesta;
	}

	public Instruccion getIdInstruccion() {
		return idInstruccion;
	}

	public void setIdInstruccion(Instruccion idInstruccion) {
		this.idInstruccion = idInstruccion;
	}

	public String getInstruccionesAdicionales() {
		return instruccionesAdicionales;
	}

	public void setInstruccionesAdicionales(String instruccionesAdicionales) {
		this.instruccionesAdicionales = instruccionesAdicionales;
	}

	public Estatus getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Estatus idEstatus) {
		this.idEstatus = idEstatus;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public Date getFechaSolucion() {
		return fechaSolucion;
	}

	public void setFechaSolucion(Date fechaSolucion) {
		this.fechaSolucion = fechaSolucion;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	

	
	
	
	

}
