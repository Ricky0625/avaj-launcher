package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileSource {

	private final BufferedReader reader;
	private String currentLine;

	/**
	 * Initialize FileSource and read the first line to currentLine
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public FileSource(final String fileName) throws IOException {
		this.reader = new BufferedReader(new FileReader(fileName));
		advance();
	}

	public String getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(final String currentLine) {
		this.currentLine = currentLine;
	}

	/**
	 * Use this for the read-get loop
	 * 
	 * @return true if not EOF, false if EOF
	 * @throws IOException
	 */
	public boolean nextLine() throws IOException {
		advance();
		return currentLine != null;
	}

	private void advance() throws IOException {
		currentLine = reader.readLine();
	}

	public void close() throws IOException {
		if (reader != null) {
			reader.close();
		}
	}

}
