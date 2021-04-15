package uacm.edu.mx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="correspondencia_enviada")
public class CorrespondenciaEnviada extends Correspondencia{
	
	@Column(name="respuesta_turno")
	private String respuestaTurno;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_envio")
	private Date fechaEnvio;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] documentoEnviado;
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] documentoRecibido;

	public CorrespondenciaEnviada() {
		
	}


	public String getRespuestaTurno() {
		return respuestaTurno;
	}


	public void setRespuestaTurno(String respuestaTurno) {
		this.respuestaTurno = respuestaTurno;
	}


	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}


	public byte[] getDocumentoEnviado() {
		return documentoEnviado;
	}


	public void setDocumentoEnviado(byte[] documentoEnviado) {
		this.documentoEnviado = documentoEnviado;
	}


	public byte[] getDocumentoRecibido() {
		return documentoRecibido;
	}


	public void setDocumentoRecibido(byte[] documentoRecibido) {
		this.documentoRecibido = documentoRecibido;
	}


}
