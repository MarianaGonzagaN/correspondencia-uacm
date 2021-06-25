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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull
	@Size(min = 8, max = 9)
	@Column(name="turno")
	private String turno;
	
	@NotNull
	@Size(max = 80)
	@Column(name="responsable_recepcion")
	private String responsableRecepcion;
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_area_envia",referencedColumnName = "id")
	private CatalogoValores idAreaEnvia;
	
	@NotNull
	@Size(max = 80)
	@Column(name="nombre_remitente")
	private String nombreRemitente;
	
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_cargo_remitente",referencedColumnName = "id")
	private CatalogoValores idCargoRemitente;
	
	@NotNull
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
	@Column(name="fecha_turnado")
	private Date fechaTurnado;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="nombre_documento")
	private String nombreDocumento;
}
