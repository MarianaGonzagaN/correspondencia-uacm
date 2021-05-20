package uacm.edu.mx.auth.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
	
	private String email;
	private String nombreCompleto;
    private String matricula;
    private String carrera;
    private String plantel;
    private String turno;
    private String urlFoto;
    private String genero;
    private Date fechaNacimiento;

}
