package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

public class AircraftTypeParserTest extends TestRunner {

	private final AircraftTypeParser parser;

	public AircraftTypeParserTest() {
		parser = new AircraftTypeParser();
	}

	public void testValidAircraftType() throws ParsingException {
		parser.parse("Helicopter");
		parser.parse("helicopter");
		parser.parse("Baloon");
		parser.parse("BaLOOn");
		parser.parse("JETPLANE");
		parser.parse("JeTpLaNe");
	}

	public void expectThrowsInvalidAircraftType() throws ParsingException {
		parser.parse("Boeing373");
	}

}
