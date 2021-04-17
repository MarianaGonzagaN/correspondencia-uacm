package uacm.edu.mx.data;

import java.util.List;

import lombok.Data;

@Data
public class CatalogoResponse {

	private Long id;
    private String nombre;
    private List<CatalogoValorResponse> valores;

	public CatalogoResponse() {
		super();
	}
}
