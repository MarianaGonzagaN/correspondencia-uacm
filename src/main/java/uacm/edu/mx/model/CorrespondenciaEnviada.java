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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="correspondencia_enviada")
@Getter 
@Setter
@NoArgsConstructor
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
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_responsable_recepcion_acuse",referencedColumnName = "id")
	private CatalogoValores idResponsableRecepcionAcuse;

	

}
