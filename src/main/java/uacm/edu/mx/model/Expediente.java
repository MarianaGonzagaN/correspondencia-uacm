package uacm.edu.mx.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author gonza
 *
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Entity
@Table(name = "expediente",uniqueConstraints={@UniqueConstraint(columnNames={"nombre_expediente"})})
public class Expediente  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4693740868837056121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_expediente")
	private Long idExpediente;

	@NotBlank(message = "fecha de apertura es requerido")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_apertura",nullable = false)
	private Date fechaApertura;

	@NotBlank(message = "el nombre es requerido")
	@Size(max = 100)
	@Column(name = "nombre_expediente",nullable = false, length = 100)
	private String nombreExpediente;

	@NotBlank(message = "el fondo es requerido")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fondo", referencedColumnName = "id",nullable = false)
	private Fondo idFondo;

	@NotBlank(message = "la sección es requerida")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_seccion", referencedColumnName = "id",nullable = false)
	private CatalogoValores idSeccion;

	@NotBlank(message = "la subsección es requerida")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_subseccion", referencedColumnName = "id",nullable = false)
	private CatalogoValores idSubSeccion;

	@NotBlank(message = "la serie es requerida")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_serie", referencedColumnName = "id",nullable = false)
	private CatalogoValores idSerie;

	@NotBlank(message = "la subserie es requerida")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_subserie", referencedColumnName = "id",nullable = false)
	private CatalogoValores idSubSerie;

	@NotBlank(message = "la carpeta física es requerida")
	@Column(name = "carpeta_fisica",nullable = false)
	private String carpetaFisica;

	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExpediente" , cascade =
	  CascadeType.ALL) 
	  private Set<CorrespondenciaRecibida> corrRecibidas = new
	  HashSet<>();
	 

		/*
		 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "idExpediente") private
		 * Set<CorrespondenciaEnviada> corrEnviadas = new HashSet<>();
		 */
	 

	public Expediente(Long idExpediente) {
		super();
		this.idExpediente = idExpediente;
	}

}
