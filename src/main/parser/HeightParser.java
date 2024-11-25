package parser;

import exceptions.ParsingException;

public class HeightParser extends IntegerParser {

	@Override
	public Integer parse(String content) throws ParsingException {
		return validateHeight(super.parse(content));
	}

	public Integer validateHeight(final Integer height) throws ParsingException {
		if (height < 0 || height > 100) {
			throw new ParsingException("Invalid height value! [0-100]. Received: " + height);
		}
		return height;
	}

}
