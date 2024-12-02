package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

/**
 * PositiveNumberParserTest
 */
public class PositiveNumberParserTest extends TestRunner {

	private final PositiveNumberParser parser;

	public PositiveNumberParserTest() {
		parser = new PositiveNumberParser();
	}

	public void testSixTwoFive() throws ParsingException {
		parser.parse("625");
	}

	public void expectThrowsNegativeSixTwoFive() throws ParsingException {
		parser.parse("-625");
	}

	public void testIntMax() throws ParsingException {
		final int intMax = Integer.MAX_VALUE;
		parser.parse(String.valueOf(intMax));
	}

}
