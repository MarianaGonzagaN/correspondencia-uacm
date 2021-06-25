package uacm.edu.mx.data;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import uacm.edu.mx.model.CatalogoValores;
import uacm.edu.mx.model.Direccion;

@Data
public class FondoResponse {
	
	private Long id;
	private String nombre;
	private String telefono;
	private Date fechaCreacion; 
	private Direccion direccion;
	
	public FondoResponse() {
		super();
	}
	
	
}
