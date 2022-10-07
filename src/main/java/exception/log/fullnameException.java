package exception.log;

public class fullnameException extends Exception{
	
	public fullnameException(String describe) {
		super(describe);
	}
	
	public fullnameException(Throwable cause) {
		super(cause);
	}

	public fullnameException(String message, Throwable cause) {
		super(message, cause);
	}

	public fullnameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	
}
