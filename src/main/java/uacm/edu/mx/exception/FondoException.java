package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FondoException extends RuntimeException{
	
	public FondoException() {
        super();
    }

    public FondoException(String message) {
        super(message);
    }

    public FondoException(String message, Throwable cause) {
        super(message, cause);
    }

}
