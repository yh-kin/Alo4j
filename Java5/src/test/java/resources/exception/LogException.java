package resources.exception;

public class LogException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LogException(String message) {
		super(message);
	}
}
