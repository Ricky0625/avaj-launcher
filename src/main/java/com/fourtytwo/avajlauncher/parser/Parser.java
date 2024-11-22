package parser;

import exceptions.ParsingException;

public interface Parser<T> {
	T parse(String content) throws ParsingException;
}
