package exceptions;

import abstractions.BaseException;

public class ParsingException extends BaseException {

	public ParsingException(String msg) {
		super(msg);
	}

	public ParsingException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
