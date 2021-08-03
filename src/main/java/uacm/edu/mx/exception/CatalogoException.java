package uacm.edu.mx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CatalogoException extends RuntimeException{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4477123742431773390L;

	public CatalogoException() {
        super();
    }

    public CatalogoException(Long id) {
        super("No se pudo encontrar el catalogo con id:"+id);
    }

	/*
	 * public CatalogoException(String message, Throwable cause) { super(message,
	 * cause); }
	 */
}
