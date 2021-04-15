package uacm.edu.mx.data;

import java.util.List;

import lombok.Data;
import uacm.edu.mx.model.CatalogoValores;

@Data
public class CatalogoResponse {

	private Long id;
    private String nombre;
    private List<CatalogoValores> valores;

	public CatalogoResponse() {
		super();
	}
}
