package uacm.edu.mx.data;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.Fondo;

@Data
@NoArgsConstructor
public class ExpedienteResponse {
	private Integer id;
	private Date fechaApertura; 
	private String nombreExpediente;
	private Fondo idFondo;
	private CatalogoValores idSeccion; 
	private CatalogoValores idSubSeccion; 
	private CatalogoValores idSerie; 
	private CatalogoValores idSubSerie; 
	private String carpetaFisica;
	

}
