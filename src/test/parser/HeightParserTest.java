package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

public class HeightParserTest extends TestRunner {

	private final HeightParser parser;

	public HeightParserTest() {
		parser = new HeightParser();
	}

	public void testValidHeightValue() throws ParsingException {
		parser.parse("36");
	}

	public void expectThrowsNegativeHeight() throws ParsingException {
		parser.parse("-10");
	}

	public void testMinHeight() throws ParsingException {
		parser.parse("0");
	}

	public void testMaxHeight() throws ParsingException {
		parser.parse("100");
	}

	public void expectThrowsExceedMaxHeight() throws ParsingException {
		parser.parse("101");
	}

}
