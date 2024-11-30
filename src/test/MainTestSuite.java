import abstractions.TestRunner;
import parser.AircraftTypeParserTest;
import parser.CoordinateParserTest;
import parser.FileSourceTest;
import parser.IntegerParserTest;
import parser.PositiveNumberParserTest;
import parser.ScenarioParserTest;
import utils.LoggerUtils;

public class MainTestSuite {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		try {
			// Register all the TestRunner classes here
			TestRunner[] runners = {
					new FileSourceTest(),
					new IntegerParserTest(),
					new PositiveNumberParserTest(),
					new AircraftTypeParserTest(),
					new ScenarioParserTest(),
					new CoordinateParserTest(),
			};

			for (TestRunner runner : runners) {
				LoggerUtils.info("Running [" + runner.getClass().getName() + "] test cases");
				runner.runAllTests();
				System.out.println();
			}
		} catch (Exception ex) {
			LoggerUtils.error("Failed to initialize TestRunner");
			ex.printStackTrace();
		}
	}

}
