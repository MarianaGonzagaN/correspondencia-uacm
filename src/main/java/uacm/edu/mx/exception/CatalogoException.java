package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatalogoException extends RuntimeException{
	
    public CatalogoException() {
        super();
    }

    public CatalogoException(String message) {
        super(message);
    }

    public CatalogoException(String message, Throwable cause) {
        super(message, cause);
    }

}
