package exceptions;

import abstractions.BaseException;

public class TestFailureException extends BaseException {

	public TestFailureException(String msg) {
		super(msg);
	}

	public TestFailureException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
