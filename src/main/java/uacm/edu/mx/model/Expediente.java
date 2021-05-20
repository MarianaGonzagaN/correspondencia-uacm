package uacm.edu.mx.model;

import java.util.Date;
import java.util.List;

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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="expediente")
@Getter 
@Setter
@NoArgsConstructor
public class Expediente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_expediente")
	private int idExpediente; 
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_apertura")
	private Date fechaApertura; 
	
	@Column(name="nombre_expediente")
	private String nombreExpediente;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_fondo",referencedColumnName = "id")
	private Fondo idFondo;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expediente")
	private List<CorrespondenciaRecibida> corrRecibidas;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expediente")
	private List<CorrespondenciaEnviada> corrEnviadas;
	

}
