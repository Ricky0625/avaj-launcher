package parser;

import exceptions.ParsingException;

public class PositiveNumberParser implements Parser<Integer> {

	@Override
	public Integer parse(String content) throws ParsingException {
		content = content.trim();
		validateContent(content);
		return parseInteger(content);
	}

	private void validateContent(final String content) throws ParsingException {
		if (content == null || content.isEmpty()) {
			throw new ParsingException("Invalid content to be parsed: " + content);
		}
	}

	private Integer parseInteger(final String content) throws ParsingException {
		try {
			final Integer number = Integer.parseInt(content);
			validateNumber(number);
			return number;
		} catch (final Exception e) {
			throw new ParsingException("Invalid number format: " + content);
		}
	}

	private void validateNumber(final Integer number) throws ParsingException {
		if (number < 0) {
			throw new ParsingException("Number cannot be negative: " + number.toString());
		}
	}

}
