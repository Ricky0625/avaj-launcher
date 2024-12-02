package utils;

import abstractions.TestRunner;
import exceptions.TestFailureException;

public class FileSourceTest extends TestRunner {

	private final String TEST_FILE_NAME = "onetwo.txt";
	private final String EMPTY_FILE = "empty.txt";
	private final String MODDED_FILE = "mod.txt";

	public FileSourceTest() throws Exception {
		try {
			testLoadFile();
		} catch (final Exception ex) {
			throw ex;
		}
	}

	public void expectThrowsFileNotFound() throws Exception {
		try (FileSource notFoundSource = new FileSource("notfound.txt")) {
		}
	}

	public void testLoadFile() throws Exception {
		FileSource source = new FileSource(getTestFilePath(TEST_FILE_NAME).toString());

		if (!source.getCurrentLine().equals("one")) {
			source.close();
			throw new TestFailureException("First line is not 'one'!");
		}

		// advance to next line, the next call of getCurrentLine will be the latest line
		source.nextLine();
		if (!source.getCurrentLine().equals("two")) {
			source.close();
			throw new TestFailureException("Call nextLine does not advance to next line!");
		}

		if (source.nextLine()) {
			source.close();
			throw new TestFailureException("Did not reach EOF");
		}

		source.close();
	}

	public void expectThrowsEmptyFile() throws Exception {
		FileSource source = new FileSource(getTestFilePath(EMPTY_FILE).toString());
		source.close();
	}

	public void expectThrowsPermissionDenied() throws Exception {
		FileSource source = new FileSource(getTestFilePath(MODDED_FILE).toString());
		source.close();
	}

}
