import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import parser.PositiveNumberParser;
import types.AircraftType;
import utils.LoggerUtils;

public class ScenarioGenerator {

	private static final Set<String> ALLOWED_FLAGS = new HashSet<>();

	private static final String TEST_CASE_TEMPLATE = "%s %s %s %s %s";
	private static String OUTPUT_FILE_NAME = "scenario.txt";
	private static int DEFAULT_SIMULATION_COUNT = 5;
	private static int DEFAULT_TEST_CASES_COUNT = 10;
	private static int NUMBER_LIMIT = 500;
	private static final String[] ADJECTIVES = {
			"Speedy", "Stealthy", "Mighty", "Crispy", "Zesty", "Cringe", "Fluffy", "Crunchy", "Spicy", "Savory"
	};
	private static final String[] FOOD_NAMES = {
			"Taco", "Pizza", "Burger", "Noodle", "Tofu", "Dumpling", "Waffle", "Sushi", "Bagel", "Donut", "Pancake"
	};

	private static File outputFile;
	private static final Random random = new Random();
	private static final PositiveNumberParser pnParser = new PositiveNumberParser();

	static {
		ALLOWED_FLAGS.add("-c");
		ALLOWED_FLAGS.add("-t");
		ALLOWED_FLAGS.add("-l");
		ALLOWED_FLAGS.add("-f");
		ALLOWED_FLAGS.add("-h");
	}

	public static void main(String[] args) {

		try {
			Map<String, String> parsedArgs = parseArgs(args);

			if (parsedArgs.containsKey("-c")) {
				DEFAULT_SIMULATION_COUNT = pnParser.parse(parsedArgs.get("-c"));
			}

			if (parsedArgs.containsKey("-t")) {
				DEFAULT_TEST_CASES_COUNT = pnParser.parse(parsedArgs.get("-t"));
			}

			if (parsedArgs.containsKey("-l")) {
				NUMBER_LIMIT = pnParser.parse(parsedArgs.get("-l"));
			}

			if (parsedArgs.containsKey("-f")) {
				OUTPUT_FILE_NAME = parsedArgs.get("-f");
			}

			if (parsedArgs.containsKey("-h") && parsedArgs.size() == 1) {
				showHelpMenu();
				return;
			}

			// need to be aware that the output is actually redirect to the file from now on
			prepareOutputFile();
			generateScenarios();

			LoggerUtils.info("File generated! Name: " + OUTPUT_FILE_NAME + "\n");
		} catch (Exception ex) {
			LoggerUtils.error(ex.getMessage());
		}

	}

	private static Map<String, String> parseArgs(String[] args) {
		Map<String, String> flags = new HashMap<>();
		for (int i = 0; i < args.length; i++) {
			String arg = args[i];
			// check the combination "-c value"
			if (arg.startsWith("-")) {
				if (!ALLOWED_FLAGS.contains(arg)) {
					showHelpMenu();
					throw new IllegalArgumentException("Unknown flag: " + arg);
				}

				if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
					flags.put(arg, args[i + 1]);
					i++;
				} else {
					flags.put(arg, null);
				}

			}
		}

		return flags;
	}

	private static void showHelpMenu() {
		LoggerUtils.log("Available flags:\n");
		LoggerUtils.log("-c:\n  Number of simulation count. Default is " + DEFAULT_SIMULATION_COUNT + ".\n");
		LoggerUtils.log("-t:\n  Number of test cases. Default is " + DEFAULT_TEST_CASES_COUNT + ".\n");
		LoggerUtils.log("-l:\n  Limit of the random POSTIVE number. Default is " + NUMBER_LIMIT + ".\n");
		LoggerUtils.log("-f:\n  Name of the output file. Default is " + OUTPUT_FILE_NAME + ".\n");
		LoggerUtils.log("-h:\n  Show helps.\n");
	}

	private static void prepareOutputFile() throws IOException {
		outputFile = new File(OUTPUT_FILE_NAME);
		if (outputFile.exists()) {
			outputFile.delete();
		}
		outputFile.createNewFile();

		// redirect any system.out call to the output file from now on
		System.setOut(new PrintStream(new FileOutputStream(outputFile)));
	}

	private static AircraftType getRandomAircraftType() {
		AircraftType[] values = AircraftType.values();
		return values[random.nextInt(values.length)];
	}

	private static String getRandomName() {
		return ADJECTIVES[random.nextInt(ADJECTIVES.length)] + FOOD_NAMES[random.nextInt(FOOD_NAMES.length)];
	}

	private static int getRandomPositiveNumber() {
		// shift range to [1, NUMBER_LIMIT]
		return random.nextInt(NUMBER_LIMIT) + 1;
	}

	private static String getRandomTestCase() {
		return String.format(
				TEST_CASE_TEMPLATE,
				getRandomAircraftType().toString(),
				getRandomName(),
				getRandomPositiveNumber(),
				getRandomPositiveNumber(),
				getRandomPositiveNumber());
	}

	private static void generateScenarios() {
		LoggerUtils.log("" + DEFAULT_SIMULATION_COUNT);
		while (DEFAULT_TEST_CASES_COUNT-- > 0) {
			LoggerUtils.log(getRandomTestCase());
		}
		// return back print out to normal
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}

}
