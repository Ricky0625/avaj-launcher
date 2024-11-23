import abstractions.TestRunner;
import parser.AircraftTypeParserTest;
import parser.FileSourceTest;
import parser.HeightParserTest;
import parser.IntegerParserTest;
import parser.LatitudeParserTest;
import parser.LongitudeParserTest;
import parser.PositiveNumberParserTest;
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
					new LatitudeParserTest(),
					new LongitudeParserTest(),
					new AircraftTypeParserTest(),
					new HeightParserTest(),
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
