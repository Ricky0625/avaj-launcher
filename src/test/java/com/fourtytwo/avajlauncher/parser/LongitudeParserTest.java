package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

public class LongitudeParserTest extends TestRunner {

	private final LongitudeParser parser;

	public LongitudeParserTest() {
		parser = new LongitudeParser();
	}

	public void testValidPositiveLongitude() throws ParsingException {
		parser.parse("25");
	}

	public void testValidNegativeLongitude() throws ParsingException {
		parser.parse("-23");
	}

	public void expectThrowsExceedMaxLongitude() throws ParsingException {
		parser.parse("123346");
	}

	public void expectThrowsExceedMinLongitude() throws ParsingException {
		parser.parse("-235234");
	}

	public void testMaxLongitude() throws ParsingException {
		parser.parse("180");
	}

	public void testMinLongitude() throws ParsingException {
		parser.parse("-180");
	}

}
