package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

public class LatitudeParserTest extends TestRunner {

	private final LatitudeParser parser;

	public LatitudeParserTest() {
		parser = new LatitudeParser();
	}

	public void testValidPositiveLatitude() throws ParsingException {
		parser.parse("25");
	}

	public void testValidNegativeLatitude() throws ParsingException {
		parser.parse("-23");
	}

	public void expectThrowsExceedMaxLatitude() throws ParsingException {
		parser.parse("123346");
	}

	public void expectThrowsExceedMinLatitude() throws ParsingException {
		parser.parse("-235234");
	}

	public void testMaxLatitude() throws ParsingException {
		parser.parse("90");
	}

	public void testMinLatitude() throws ParsingException {
		parser.parse("-90");
	}

}
