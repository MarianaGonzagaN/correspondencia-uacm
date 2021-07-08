package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnviadaException extends RuntimeException{
	
    public EnviadaException() {
        super();
    }

    public EnviadaException(String message) {
        super(message);
    }

    public EnviadaException(String message, Throwable cause) {
        super(message, cause);
    }

}
