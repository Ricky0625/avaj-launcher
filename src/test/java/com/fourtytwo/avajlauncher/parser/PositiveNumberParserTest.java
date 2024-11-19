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

	public void expectThrowsNull() throws ParsingException {
		parser.parse(null);
	}

	public void expectThrowsEmpty() throws ParsingException {
		parser.parse("");
	}

	public void expectThrowsOnlyWhitespaces() throws ParsingException {
		parser.parse("	\n\t");
	}

	public void expectThrowsNonNumeric() throws ParsingException {
		parser.parse("abc+-!@#$%^&*(){}[]|~`'\";:,./?\\");
	}

	public void testNumeric() throws ParsingException {
		parser.parse("0123456789");
	}

	public void testPositiveNumeric() throws ParsingException {
		parser.parse("+123");
	}

	public void expectThrowsNegativeNumeric() throws ParsingException {
		parser.parse("-123");
	}

	public void expectThrowsMultiplePositiveSignNumeric() throws ParsingException {
		parser.parse("++123");
	}

	public void expectThrowsMultipleNegativeSignNumeric() throws ParsingException {
		parser.parse("--123");
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

	public void testNumericWithSpace() throws ParsingException {
		parser.parse("   +123    ");
	}

	public void expectThrowsMultipleNumericString() throws ParsingException {
		parser.parse("  123  123 123  123");
	}

	public void expectThrowsNumericConcat() throws ParsingException {
		parser.parse("   +123+456  ");
	}

}
