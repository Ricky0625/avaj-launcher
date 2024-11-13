package abstractions;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import utils.LoggerUtils;

public abstract class TestRunner {

	private final String TEST_CASE_PREFIX = "test";

	public void runAllTests() {
		final List<Method> testCases = getTestCases();

		LoggerUtils.info("Running tests in " + this.getClass().getName());

		if (testCases.isEmpty()) {
			LoggerUtils.info("No tests to run.");
			return;
		}

		for (final Method testCase : testCases) {
			try {
				testCase.invoke(this);
				LoggerUtils.testCase(testCase.getName(), true);
			} catch (final Exception e) {
				LoggerUtils.testCase(testCase.getName(), false);
				e.printStackTrace();
			}
		}

		// TODO: count how many pass and fail
		System.out.println();
	}

	private List<Method> getTestCases() {
		final Class<?> childClass = this.getClass();
		final Method[] methods = childClass.getDeclaredMethods();
		final List<Method> testCases = new ArrayList<>();

		for (final Method method : methods) {
			if (method.getName().startsWith(TEST_CASE_PREFIX)) {
				testCases.add(method);
			}
		}

		return testCases;
	}

}
