package utils;

public class AssertUtils {

	/**
	 * Check if expected equals actual
	 *
	 * @param expected
	 * @param actual
	 * @throws AssertionError
	 */
	public static void assertEquals(final Object expected, final Object actual) {
		if (!expected.equals(actual)) {
			String string = ", but got: ";
			throw new AssertionError("Expected: " + expected + string + actual);
		}
	}

	private AssertUtils() {
	}

}
