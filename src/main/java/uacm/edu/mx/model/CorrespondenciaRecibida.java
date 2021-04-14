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

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="correspondencia_recibida")
public class CorrespondenciaRecibida extends CorrespondenciaBaseEntity {
	
	
	@Column(name="turno",nullable = false)
	private String turno;
	
	@Column(name="responsable_recepcion")
	private String responsableRecepcion;
	
	@Column(name="nombre_remitente")
	private String nombreRemitente;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_recepcion",nullable = false)
	private Date fechaRecepcion; 
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] documento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_turnado",nullable = false)
	private Date fechaTurnado;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="nombre_documento")
	private String nombreDocumento;

	

	

	public CorrespondenciaRecibida() {
		
	}



	public String getTurno() {
		return turno;
	}



	public void setTurno(String turno) {
		this.turno = turno;
	}



	public String getResponsableRecepcion() {
		return responsableRecepcion;
	}



	public void setResponsableRecepcion(String responsableRecepcion) {
		this.responsableRecepcion = responsableRecepcion;
	}

	public String getNombreRemitente() {
		return nombreRemitente;
	}



	public void setNombreRemitente(String nombreRemitente) {
		this.nombreRemitente = nombreRemitente;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}



	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}



	public byte[] getDocumento() {
		return documento;
	}



	public void setDocumento(byte[] documento) {
		this.documento = documento;
	}

	public Date getFechaTurnado() {
		return fechaTurnado;
	}



	public void setFechaTurnado(Date fechaTurnado) {
		this.fechaTurnado = fechaTurnado;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public String getNombreDocumento() {
		return nombreDocumento;
	}



	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}



	

	
}
