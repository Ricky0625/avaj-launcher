package parser;

import exceptions.ParsingException;

public class PositiveNumberParser extends IntegerParser {

	@Override
	public Integer parse(String content) throws ParsingException {
		return validatePositiveNumber(super.parse(content));
	}

	private Integer validatePositiveNumber(final Integer number) throws ParsingException {
		if (number < 0) {
			throw new ParsingException("Number cannot be negative: " + number.toString());
		}
		return number;
	}

}
