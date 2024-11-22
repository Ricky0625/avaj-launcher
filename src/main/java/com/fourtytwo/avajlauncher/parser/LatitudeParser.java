package parser;

import exceptions.ParsingException;

public class LatitudeParser extends IntegerParser {

	@Override
	public Integer parse(String content) throws ParsingException {
		return validateLatitude(super.parse(content));
	}

	private Integer validateLatitude(final Integer latitude) throws ParsingException {
		if (latitude < -90 || latitude > 90) {
			throw new ParsingException("Invalid latitute value! [-90, 90]. Received: " + latitude);
		}
		return latitude;
	}

}
