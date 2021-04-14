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
		
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_documento")
	private Date fechaDocumento;
	
	@Column(name="asunto")
	private String asunto;
	
	@Column(name="nombre_destinatario")
	private String nombreDestinatario;
	
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
	
		
	@Column(name="instrucciones_adicionales")
	private String instruccionesAdicionales;
	
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

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getNombreDestinatario() {
		return nombreDestinatario;
	}

	public void setNombreDestinatario(String nombreDestinatario) {
		this.nombreDestinatario = nombreDestinatario;
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

	public String getInstruccionesAdicionales() {
		return instruccionesAdicionales;
	}

	public void setInstruccionesAdicionales(String instruccionesAdicionales) {
		this.instruccionesAdicionales = instruccionesAdicionales;
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
