package parser;

import java.util.Arrays;

import base.Scenario;
import exceptions.ParsingException;

public class ScenarioParser implements Parser<Scenario> {

	// parser
	private AircraftTypeParser aircraftTypeParser;
	private CoordinateParser coordinateParser;

	private static final int EXPECT_TOKEN_COUNT = 5;

	public ScenarioParser(AircraftTypeParser aTypeParser, CoordinateParser cParser) {
		aircraftTypeParser = aTypeParser;
		coordinateParser = cParser;
	}

	@Override
	public Scenario parse(String content) throws ParsingException {
		String[] tokens = splitToken(content);

		validateTokenCount(tokens);

		return new Scenario(
				aircraftTypeParser.parse(tokens[0]),
				tokens[1],
				coordinateParser.parse(Arrays.stream(tokens, 2, 5).toArray(String[]::new)));
	}

	private String[] splitToken(String content) throws ParsingException {
		content = content.trim();

		if (content.isEmpty()) {
			throw new ParsingException("Empty scenario line found!");
		}
		// split by all whitespaces
		return content.split("\\s+");
	}

	private void validateTokenCount(final String[] tokens) throws ParsingException {
		if (tokens.length != EXPECT_TOKEN_COUNT) {
			throw new ParsingException("Invalid format: TYPE NAME LONGITUDE LATITUDE HEIGHT");
		}
	}

}
