package exceptions;

public class TestFailureException extends BaseException {

	public TestFailureException(String msg) {
		super(msg);
	}

	public TestFailureException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
