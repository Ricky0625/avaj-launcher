package abstractions;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import utils.TestCase;
import utils.LoggerUtils;

public abstract class TestRunner {

	private final String TEST_CASE_PREFIX = "test";
	private final String TEST_CASE_WITH_EXCEPTION_PREFIX = "expectThrows";
	private final static String TEST_RESOURCES_DIR = "src/test/resources";

	public TestRunner() {
		LoggerUtils.log("", null, "🐻 Init " + getClass().getName());
	}

	public void runAllTests() {
		final List<TestCase> testCases = getTestCases();
		int total = 0, passed = 0, failed = 0;

		if (testCases.isEmpty()) {
			LoggerUtils.info("No tests to run.");
			return;
		}

		total = testCases.size();

		for (final TestCase testCase : testCases) {

			final Method method = testCase.getMethod();
			final boolean expectException = testCase.getExpectException();
			final String methodName = method.getName();

			try {
				method.invoke(this);

				if (expectException) {
					LoggerUtils.testCase(methodName, false);
					failed++;
				} else {
					LoggerUtils.testCase(methodName, true);
					passed++;
				}
			} catch (final Exception e) {
				if (expectException) {
					LoggerUtils.testCase(methodName, true);
					passed++;
				} else {
					LoggerUtils.testCase(method.getName(), false, e.getCause().getMessage());
					failed++;
				}
			}
		}

		LoggerUtils.testResult(total, passed, failed);
	}

	private List<TestCase> getTestCases() {
		final Class<?> childClass = this.getClass();
		final Method[] methods = childClass.getDeclaredMethods();
		final List<TestCase> testCases = new ArrayList<>();

		for (final Method method : methods) {
			if (method.getName().startsWith(TEST_CASE_PREFIX)) {
				testCases.add(new TestCase(method, false));
			} else if (method.getName().startsWith(TEST_CASE_WITH_EXCEPTION_PREFIX)) {
				testCases.add(new TestCase(method, true));
			}
		}

		return testCases;
	}

	public static Path getTestFilePath(String filename) {
		return Paths.get(TEST_RESOURCES_DIR, filename);
	}

}
