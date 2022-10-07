package exception.log;

public class addressException extends Exception {

	public addressException(String message) {
		super(message);
	}

	public addressException(Throwable cause) {
		super(cause);
	}

	public addressException(String message, Throwable cause) {
		super(message, cause);
	}

	public addressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
