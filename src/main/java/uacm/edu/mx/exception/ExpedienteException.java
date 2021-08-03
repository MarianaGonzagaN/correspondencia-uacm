package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpedienteException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5281921231705097795L;

	public ExpedienteException() {
        super();
    }

    public ExpedienteException(String message) {
        super(message);
    }

    public ExpedienteException(String message, Throwable cause) {
        super(message, cause);
    }

}
