package exception.log;

public class usernameException extends Exception {


	public usernameException(String message) {
		super(message);
	}

	public usernameException(Throwable cause) {
		super(cause);
	}

	public usernameException(String message, Throwable cause) {
		super(message, cause);
	}

	public usernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
