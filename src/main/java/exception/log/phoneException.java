package exception.log;

public class phoneException extends Exception {


	public phoneException(String message) {
		super(message);
	}

	public phoneException(Throwable cause) {
		super(cause);
	}

	public phoneException(String message, Throwable cause) {
		super(message, cause);
	}

	public phoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
