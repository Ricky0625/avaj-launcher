package utils;

import java.lang.reflect.Method;

public class TestCase {

	private final Method method;
	private final boolean expectException;

	public TestCase(Method method, boolean expectException) {
		this.method = method;
		this.expectException = expectException;
	}

	public Method getMethod() {
		return method;
	}

	public boolean getExpectException() {
		return expectException;
	}
}
