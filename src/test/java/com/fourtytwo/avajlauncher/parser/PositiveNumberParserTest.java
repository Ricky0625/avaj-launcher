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

	public void expectThrowsIntMaxPlusOne() throws ParsingException {
		// overflow, become Integer.MIN_VALUE
		final int intMaxPlusOne = Integer.MAX_VALUE + 1;
		parser.parse(String.valueOf(intMaxPlusOne));
	}

	public void expectThrowsIntMin() throws ParsingException {
		final int intMin = Integer.MIN_VALUE;
		parser.parse(String.valueOf(intMin));
	}

	public void testIntMinMinusOne() throws ParsingException {
		// overflow, become Integer.MAX_VALUE
		final int intMinMinusOne = Integer.MIN_VALUE - 1;
		parser.parse(String.valueOf(intMinMinusOne));
	}

}
