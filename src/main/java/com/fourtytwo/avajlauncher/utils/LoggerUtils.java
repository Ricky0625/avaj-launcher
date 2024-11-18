package utils;

public class LoggerUtils {

	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static void info(final String message) {
		System.out.println(BLUE + "[INFO]	" + message + RESET);
	}

	public static void warn(final String message) {
		System.out.println(YELLOW + "[WARN]	" + message + RESET);
	}

	public static void error(final String message) {
		System.out.println(RED + "[ERR]	" + message + RESET);
	}

	public static void debug(final String message) {
		System.out.println(CYAN + "[DBG]	" + message + RESET);
	}

	public static void testCase(final String message, boolean pass) {
		if (pass) {
			System.out.print(GREEN + "	[PASS]");
		} else {
			System.out.print(RED + "	[FAIL]");
		}
		System.out.println(" " + message + RESET);
	}

	public static void testCase(final String message, boolean pass, final String context) {
		if (pass) {
			System.out.print(GREEN + "	[PASS]");
		} else {
			System.out.print(RED + "	[FAIL]");
		}
		System.out.print(" " + message);
		if (context != null) {
			System.out.print(": " + context);
		}
		System.out.println(RESET);
	}

	public static void testResult(final int total, final int passed, final int failed) {
		System.out.println("	" + GREEN + total + " test cases. +" + passed + " -" + failed + RESET + "\n");
	}

	public static void log(final String color, final String tag, final String message) {
		System.out.print(color);
		if (tag != null) {
			System.out.printf("[%s]	", tag);
		}
		System.out.println(message + RESET);
	}

	private LoggerUtils() {
	}
}
