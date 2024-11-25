package parser;

import exceptions.ParsingException;

public class LongitudeParser extends IntegerParser {

	@Override
	public Integer parse(String content) throws ParsingException {
		return validateLongitude(super.parse(content));
	}

	private Integer validateLongitude(final Integer longitude) throws ParsingException {
		if (longitude < -180 || longitude > 180) {
			throw new ParsingException("Invalid longitude value! [-180, 180]. Received: " + longitude);
		}
		return longitude;
	}

}
