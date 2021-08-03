package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FondoException extends RuntimeException{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FondoException(Long id) {
        super("No se encontro el fondo con id: "+ id );
    }


}
