package parser;

import abstractions.TestRunner;
import coords.CoordinateParser;
import coords.Coordinates;
import exceptions.BaseException;
import exceptions.ParsingException;
import exceptions.TestFailureException;

public class CoordinateParserTest extends TestRunner {

	private final CoordinateParser parser;

	public CoordinateParserTest() {
		parser = new CoordinateParser();
	}

	private String[] createTestCase(final String longitude, final String latitude, final String height) {
		String[] arr = new String[] { longitude, latitude, height };
		return arr;
	}

	public void expectThrowsInvalidArgs() throws ParsingException {
		parser.parse(new String[] { "1", "2" });
	}

	public void expectThrowsNullLongitude() throws ParsingException {
		parser.parse(createTestCase(null, "0", "0"));
	}

	public void expectThrowsNullLatitude() throws ParsingException {
		parser.parse(createTestCase("0", null, "0"));
	}

	public void expectThrowsNullHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", null));
	}

	public void expectThrowsEmptyLongitude() throws ParsingException {
		parser.parse(createTestCase("", "0", "0"));
	}

	public void expectThrowsEmptyLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "", "0"));
	}

	public void expectThrowsEmptyHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", ""));
	}

	public void testValidPositiveLongitude() throws ParsingException {
		parser.parse(createTestCase("25", "0", "0"));
	}

	public void expectThrowsNegativeLongitude() throws ParsingException {
		parser.parse(createTestCase("-78", "0", "0"));
	}

	public void testValidPositiveLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "67", "0"));
	}

	public void expectThrowsNegativeLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "-47", "0"));
	}

	public void testValidHeightValue() throws ParsingException {
		parser.parse(createTestCase("0", "0", "36"));
	}

	public void expectThrowsNegativeHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", "-10"));
	}

	public void testMinHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", "0"));
	}

	public void testMaxHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", "100"));
	}

	public void testCapHeightAt100() throws BaseException {
		Coordinates coord = parser.parse(createTestCase("0", "0", "777"));
		if (coord.getHeight() != 100) {
			throw new TestFailureException("Height didn't cap at 100!");
		}
	}

	public void expectThrowsNonNumericLongitude() throws ParsingException {
		parser.parse(createTestCase("abc", "0", "0"));
	}

	public void expectThrowsNonNumericLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "abc", "0"));
	}

	public void expectThrowsNonNumericHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", "abc"));
	}

}
