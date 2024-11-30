package parser;

import abstractions.TestRunner;
import exceptions.ParsingException;

public class CoordinateParserTest extends TestRunner {

	private final CoordinateParser parser;

	public CoordinateParserTest() {
		parser = new CoordinateParser();
	}

	private String[] createTestCase(final String longitude, final String latitude, final String height) {
		String[] arr = new String[] { longitude, latitude, height };
		// System.out.println(arr[0] + "," + arr[1] + "," + arr[2]);
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

	public void testValidNegativeLongitude() throws ParsingException {
		parser.parse(createTestCase("-78", "0", "0"));
	}

	public void expectThrowsExceedMaxLongitude() throws ParsingException {
		parser.parse(createTestCase("123123", "0", "0"));
	}

	public void expectThrowsExceedMinLongitude() throws ParsingException {
		parser.parse(createTestCase("-123123", "0", "0"));
	}

	public void testMaxLongitude() throws ParsingException {
		parser.parse(createTestCase("180", "0", "0"));
	}

	public void testMinLongitude() throws ParsingException {
		parser.parse(createTestCase("-180", "0", "0"));
	}

	public void testValidPositiveLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "67", "0"));
	}

	public void testValidNegativeLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "-47", "0"));
	}

	public void expectThrowsExceedMaxLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "100", "0"));
	}

	public void expectThrowsExceedMinLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "-7979", "0"));
	}

	public void testMaxLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "90", "0"));
	}

	public void testMinLatitude() throws ParsingException {
		parser.parse(createTestCase("0", "-90", "0"));
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

	public void expectThrowsExceedMaxHeight() throws ParsingException {
		parser.parse(createTestCase("0", "0", "101"));
	}

}
