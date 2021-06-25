package uacm.edu.mx.data;

import lombok.Data;

@Data
public class CatalogoRequest {

    private String nombre;

	public CatalogoRequest() {
		super();
	}

	public CatalogoRequest(String nombre) {
		super();
		this.nombre = nombre;
	}
    
}
