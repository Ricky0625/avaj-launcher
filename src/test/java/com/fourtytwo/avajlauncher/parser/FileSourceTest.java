package parser;

import java.io.IOException;

import abstractions.TestRunner;

public class FileSourceTest extends TestRunner {

	public void expectThrowsFileNotFound() throws IOException {
		FileSource source = new FileSource("notfound.txt");
	}

}
