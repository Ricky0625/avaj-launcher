package parser;

import java.util.HashMap;
import java.util.Map;

import base.Scenario;
import exceptions.ParsingException;
import types.AircraftType;

public class ScenarioParser implements Parser<Scenario> {

	private final Map<Integer, Parser<?>> parsers = new HashMap<>();
	private static final int EXPECT_TOKEN_COUNT = 5;

	public ScenarioParser(
			AircraftTypeParser aTypeParser,
			LongitudeParser loParser,
			LatitudeParser laParser,
			HeightParser hParser) {
		parsers.put(0, aTypeParser);
		parsers.put(2, loParser);
		parsers.put(3, laParser);
		parsers.put(4, hParser);
	}

	@Override
	public Scenario parse(String content) throws ParsingException {
		String[] tokens = splitToken(content);
		Object[] parsedTokens;

		validateTokenCount(tokens);
		parsedTokens = validateTokens(tokens);
		return new Scenario(
				(AircraftType) parsedTokens[0],
				(String) parsedTokens[1],
				(Integer) parsedTokens[2],
				(Integer) parsedTokens[3],
				(Integer) parsedTokens[4]);
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

	private Object[] validateTokens(final String[] tokens) throws ParsingException {
		Object[] parsedTokens = new Object[tokens.length];

		for (int i = 0; i < tokens.length; i++) {
			if (parsers.containsKey(i)) {
				parsedTokens[i] = parsers.get(i).parse(tokens[i]);
			} else {
				parsedTokens[i] = tokens[i];
			}
		}

		return parsedTokens;
	}

}
