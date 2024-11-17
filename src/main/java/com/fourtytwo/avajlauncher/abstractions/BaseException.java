package abstractions;

/**
 * BaseException: Parent for the custom exceptions
 */
public abstract class BaseException extends Exception {

	public BaseException(String msg) {
		super(msg);
	}

	public BaseException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
