package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

public class ScenarioParserTest extends TestRunner {

	private final ScenarioParser parser;

	public ScenarioParserTest() {
		parser = new ScenarioParser(
				new AircraftTypeParser(),
				new LongitudeParser(),
				new LatitudeParser(),
				new HeightParser());
	}

	public void expectThrowsEmptyScenarioLine() throws ParsingException {
		parser.parse("");
	}

	public void expectThrowsNotEnoughToken() throws ParsingException {
		parser.parse("a b c");
	}

	public void expectThrowsInvalidFivetoken() throws ParsingException {
		parser.parse(" a b c d   e ");
	}

	public void expectThrowsInvalidType() throws ParsingException {
		parser.parse("BOEING737 test 20 20 20");
	}

	public void expectThrowsInvalidLongtitude() throws ParsingException {
		parser.parse("Baloon test 270 20 20");
	}

	public void expectThrowsInvalidLatitude() throws ParsingException {
		parser.parse("Baloon test 20 -270 20");
	}

	public void expectThrowsInvalidHeight() throws ParsingException {
		parser.parse("Baloon test 20 80 101");
	}

	public void testValidScenario() throws ParsingException {
		parser.parse("JetPlane J1 23 44 32");
	}

}
