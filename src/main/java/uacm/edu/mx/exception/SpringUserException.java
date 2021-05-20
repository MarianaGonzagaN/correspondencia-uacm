package uacm.edu.mx.exception;

public class SpringUserException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpringUserException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringUserException(String exMessage) {
        super(exMessage);
    }
}
