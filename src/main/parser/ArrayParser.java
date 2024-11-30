package parser;

import exceptions.ParsingException;

public interface ArrayParser<T> {
	T parse(String[] array) throws ParsingException;
}
