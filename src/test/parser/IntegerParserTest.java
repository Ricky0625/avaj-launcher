package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;
import utils.LoggerUtils;

public class IntegerParserTest extends TestRunner {

	private final IntegerParser parser;

	public IntegerParserTest() {
		parser = new IntegerParser();
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

	public void testNegativeNumeric() throws ParsingException {
		parser.parse("-123");
	}

	public void expectThrowsMultiplePositiveSignNumeric() throws ParsingException {
		parser.parse("++123");
	}

	public void expectThrowsMultipleNegativeSignNumeric() throws ParsingException {
		parser.parse("--123");
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

	public void expectThrowsIntMaxPlusOne() throws ParsingException {
		final long intMaxPlusOne = (long) Integer.MAX_VALUE + 1;
		parser.parse(String.valueOf(intMaxPlusOne));
	}

	public void expectThrowsIntMinMinusOne() throws ParsingException {
		final long intMinMinusOne = (long) Integer.MIN_VALUE - 1;
		parser.parse(String.valueOf(intMinMinusOne));
	}
}
