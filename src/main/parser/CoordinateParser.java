package parser;

import base.Coordinates;
import exceptions.ParsingException;

public class CoordinateParser implements ArrayParser<Coordinates> {

	private final int MAX_HEIGHT = 100;
	private final PositiveNumberParser positiveNumberParser = new PositiveNumberParser();

	@Override
	public Coordinates parse(String[] array) throws ParsingException {
		if (array == null) {
			throw new ParsingException("CoordinateParser: input cannot be null!");
		}

		if (array.length != 3) {
			throw new ParsingException(
					"CoordinateParser: Expected 3 field for longitude, latitude & height but got " + array.length);
		}

		int longitude = positiveNumberParser.parse(array[0]);
		int latitude = positiveNumberParser.parse(array[1]);
		// cap height
		int height = Math.min(positiveNumberParser.parse(array[2]), MAX_HEIGHT);

		return new Coordinates(longitude, latitude, height);
	}

}
