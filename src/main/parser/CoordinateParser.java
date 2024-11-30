package parser;

import base.Coordinates;
import exceptions.ParsingException;

public class CoordinateParser implements ArrayParser<Coordinates> {

	// parse Longitude, Latitude & Height
	@Override
	public Coordinates parse(String[] array) throws ParsingException {
		if (array.length != 3) {
			throw new ParsingException("CoordinateParser: Invalid amount of field to be parsed!");
		}

		return new Coordinates(parseLongitude(array[0]), parseLatitude(array[1]), parseHeight(array[2]));
	}

	private int parseLongitude(String field) throws ParsingException {
		int longitude = parseInteger(field);

		if (longitude < -180 || longitude > 180) {
			throw new ParsingException("Invalid longitude value! [-180, 180]. Received: " + longitude);
		}

		return longitude;
	}

	private int parseLatitude(final String field) throws ParsingException {
		int latitude = parseInteger(field);

		if (latitude < -90 || latitude > 90) {
			throw new ParsingException("Invalid latitute value! [-90, 90]. Received: " + latitude);
		}

		return latitude;
	}

	private int parseHeight(final String field) throws ParsingException {
		int height = parseInteger(field);

		if (height < 0 || height > 100) {
			throw new ParsingException("Invalid height value! [0, 100]. Received: " + height);
		}

		return height;
	}

	private int parseInteger(final String field) throws ParsingException {
		if (field == null || field.isEmpty()) {
			throw new ParsingException("Invalid content to be parsed: " + field);
		}

		try {
			final int number = Integer.parseInt(field);
			return number;
		} catch (final Exception e) {
			throw new ParsingException("Invalid number format: " + field);
		}
	}

}
