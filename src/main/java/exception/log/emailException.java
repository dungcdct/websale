package exception.log;

public class emailException extends Exception {

	public emailException(String message) {
		super(message);
	}

	public emailException(Throwable cause) {
		super(cause);
	}

	public emailException(String message, Throwable cause) {
		super(message, cause);
	}

	public emailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

