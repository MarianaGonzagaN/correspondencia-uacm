package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecibidaException extends RuntimeException{
	
    public RecibidaException() {
        super();
    }

    public RecibidaException(String message) {
        super(message);
    }

    public RecibidaException(String message, Throwable cause) {
        super(message, cause);
    }

}
