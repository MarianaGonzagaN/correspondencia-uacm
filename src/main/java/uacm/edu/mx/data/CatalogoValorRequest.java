package uacm.edu.mx.data;

import lombok.Data;

@Data
public class CatalogoValorRequest {

	private String nombre;
	private String descripcion;
	
	public CatalogoValorRequest() {
		super();
	}
		
}
