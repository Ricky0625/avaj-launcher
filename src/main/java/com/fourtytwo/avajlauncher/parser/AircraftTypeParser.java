package parser;

import exceptions.ParsingException;
import types.AircraftType;

public class AircraftTypeParser implements Parser<AircraftType> {

	@Override
	public AircraftType parse(String content) throws ParsingException {
		try {
			return AircraftType.fromString(content);
		} catch (IllegalArgumentException ex) {
			throw new ParsingException("Invalid AircraftType: " + content);
		}
	}

}
