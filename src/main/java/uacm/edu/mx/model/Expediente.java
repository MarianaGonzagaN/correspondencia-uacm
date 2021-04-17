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


@Entity
@Table(name="expediente")
public class Expediente {
	
	@Id
	@SequenceGenerator(name="expediente_id_expediente_seq",
    sequenceName="expediente_id_expediente_seq",
    allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="expediente_id_expediente_seq")
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
	

	public Expediente() {
		
	}

	public int getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(int idExpediente) {
		this.idExpediente = idExpediente;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getNombreExpediente() {
		return nombreExpediente;
	}

	public void setNombreExpediente(String nombreExpediente) {
		this.nombreExpediente = nombreExpediente;
	}

	public Fondo getIdFondo() {
		return idFondo;
	}

	public void setIdFondo(Fondo idFondo) {
		this.idFondo = idFondo;
	}

	
	public List<CorrespondenciaRecibida> getCorrRecibidas() {
		return corrRecibidas;
	}

	public void setCorrRecibidas(List<CorrespondenciaRecibida> corrRecibidas) {
		this.corrRecibidas = corrRecibidas;
	}

	public List<CorrespondenciaEnviada> getCorrEnviada() {
		return corrEnviadas;
	}

	public void setCorrEnviada(List<CorrespondenciaEnviada> corrEnviada) {
		this.corrEnviadas = corrEnviada;
	}
	
	

}
