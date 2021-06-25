package uacm.edu.mx.data;

import java.util.Date;

import lombok.Data;
import uacm.edu.mx.model.Direccion;


@Data
public class FondoRequest {

	private String nombre;
	private String telefono;
	private Date fechaCreacion; 
	private Direccion direccion;
	public FondoRequest() {
		super();
	}

	
}
