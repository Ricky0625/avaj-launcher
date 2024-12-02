package parser;

import exceptions.ParsingException;

public class IntegerParser implements Parser<Integer> {

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

	private void checkIntegerOverflow(final long number) throws ParsingException {
		if (number > Integer.MAX_VALUE) {
			throw new ParsingException("Integer Max overflow!");
		} else if (number < Integer.MIN_VALUE) {
			throw new ParsingException("Integer Min overflow!");
		}
	}

	private Integer parseInteger(final String content) throws ParsingException {
		try {
			final long number = Long.parseLong(content);
			checkIntegerOverflow(number);
			return (int) number;
		} catch (final Exception e) {
			throw new ParsingException("Invalid number format: " + content);
		}
	}

}
