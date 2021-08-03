package uacm.edu.mx.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.CorrespondenciaRecibida;
import uacm.edu.mx.model.Fondo;

@Getter
@Setter
public class ExpedienteResponse {
	private Long idExpediente;
	private Date fechaApertura; 
	private String nombreExpediente;
	private Fondo idFondo;
	private CatalogoValores idSeccion; 
	private CatalogoValores idSubSeccion; 
	private CatalogoValores idSerie; 
	private CatalogoValores idSubSerie; 
	private String carpetaFisica;
	private Set<CorrespondenciaRecibida> corrRecibidas = new HashSet<>();
	


	public ExpedienteResponse() {
		super();
	}



	public ExpedienteResponse(Long idExpediente, Date fechaApertura, String nombreExpediente, Fondo idFondo,
			CatalogoValores idSeccion, CatalogoValores idSubSeccion, CatalogoValores idSerie,
			CatalogoValores idSubSerie, String carpetaFisica, Set<CorrespondenciaRecibida> corrRecibidas) {
		super();
		this.idExpediente = idExpediente;
		this.fechaApertura = fechaApertura;
		this.nombreExpediente = nombreExpediente;
		this.idFondo = idFondo;
		this.idSeccion = idSeccion;
		this.idSubSeccion = idSubSeccion;
		this.idSerie = idSerie;
		this.idSubSerie = idSubSerie;
		this.carpetaFisica = carpetaFisica;
		this.corrRecibidas = corrRecibidas;
	}
	
	
	

}
