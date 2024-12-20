package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exceptions.ParsingException;

public class FileSource implements AutoCloseable {

	private final BufferedReader reader;
	private String currentLine;

	/**
	 * Initialize FileSource and read the first line to currentLine
	 * 
	 * @param fileName
	 * @throws IOException
	 * @throws ParsingException If the file is empty
	 */
	public FileSource(final String fileName) throws IOException, ParsingException {
		this.reader = new BufferedReader(new FileReader(fileName));
		advance();
		if (getCurrentLine() == null) {
			throw new ParsingException("Empty file!");
		}
	}

	public String getCurrentLine() {
		return currentLine;
	}

	/**
	 * Use this for the read-get loop
	 * 
	 * @return true if not EOF, false if EOF
	 */
	public boolean nextLine() {
		try {
			advance();
		} catch (final IOException ex) {
			// hmmmm...
			return false;
		}
		return currentLine != null;
	}

	private void advance() throws IOException {
		currentLine = reader.readLine();
	}

	@Override
	public void close() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}

}
