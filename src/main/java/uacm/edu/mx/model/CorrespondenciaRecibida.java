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
@Table(name = "correspondencia_recibida")
@Getter 
@Setter
@NoArgsConstructor
public class CorrespondenciaRecibida extends Correspondencia {

	@Column(name="turno",nullable = false)
	private String turno;
	
	@Column(name="responsable_recepcion")
	private String responsableRecepcion;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_area_envia",referencedColumnName = "id")
	private CatalogoValores idAreaEnvia;
	
	@Column(name="nombre_remitente")
	private String nombreRemitente;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cargo_remitente",referencedColumnName = "id")
	private CatalogoValores idCargoRemitente;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_recepcion",nullable = false)
	private Date fechaRecepcion; 
	
	@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] documento;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_turnado_a",referencedColumnName = "id")
	private CatalogoValores idTurnadoA;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_turnado",nullable = false)
	private Date fechaTurnado;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="nombre_documento")
	private String nombreDocumento;
}
