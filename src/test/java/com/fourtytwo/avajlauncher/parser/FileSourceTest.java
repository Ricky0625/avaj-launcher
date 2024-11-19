package parser;

import java.io.IOException;

import abstractions.TestRunner;
import exceptions.TestFailureException;

public class FileSourceTest extends TestRunner {

	private FileSource source;
	private final String TEST_FILE_NAME = "onetwo.txt";

	public FileSourceTest() throws IOException {
		try {
			testLoadFile();
		} catch (final Exception ex) {
			throw ex;
		}
	}

	public void expectThrowsFileNotFound() throws IOException {
		try (FileSource notFoundSource = new FileSource("notfound.txt")) {
		}
	}

	public void testLoadFile() throws IOException {
		source = new FileSource(getTestFilePath(TEST_FILE_NAME).toString());
	}

	public void testGetFirstLine() throws TestFailureException {
		if (!source.getCurrentLine().equals("one")) {
			throw new TestFailureException("First line is not 'one'!");
		}
	}

	public void testGetSecondLine() throws TestFailureException {
		// advance to next line, the next call of getCurrentLine will be the latest line
		source.nextLine();
		if (!source.getCurrentLine().equals("two")) {
			throw new TestFailureException("Call nextLine does not advance to next line!");
		}
	}

	public void testEOF() throws TestFailureException {
		if (source.nextLine()) {
			throw new TestFailureException("Did not reach EOF");
		}
	}

	public void testCloseFile() throws IOException {
		source.close();
	}

}
