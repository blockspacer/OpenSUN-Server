package pl.cwanix.opensun.utils.files;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class SUNFileReader extends Reader {

	private static final String COMMENT_PREFIX = "//";
	private static final String DELIMITER = "\\t";

	private final BufferedReader in;
	private Map<String, Integer> header;
	private String[] currentLine;
	private int currentLineIndex;
	private int currentElementIndex;

	public SUNFileReader(String filePath, boolean loadHeader) throws IOException {
		this.in = new BufferedReader(new FileReader(filePath));

		if (loadHeader) {
			loadHeader();
		}
	}

	public SUNFileReader(String filePath) throws IOException {
		this(filePath, false);
	}

	public int read(char[] chars, int i, int i1) throws IOException {
		return in.read(chars, i, i1);
	}

	public boolean readLine() throws IOException {
		String line;
		boolean changed = false;

		while ((line = in.readLine()) != null) {
			++currentLineIndex;
			String tempLine;

			if (StringUtils.isNotBlank(line) && !(tempLine = line.trim()).startsWith(COMMENT_PREFIX)) {
				currentLine = tempLine.split(DELIMITER);
				currentElementIndex = 0;
				changed = true;

				break;
			}
		}

		return changed;
	}

	public String readNextStringValue() {
		return currentLine[currentElementIndex++];
	}

	public int readNextIntValue() {
		return Integer.parseInt(currentLine[currentElementIndex++]);
	}

	public byte readNextByteValue() {
		return Byte.parseByte(currentLine[currentElementIndex++]);
	}

	public String readNextStringValue(String key) {
		return currentLine[header.get(key)];
	}

	public int readNextIntValue(String key) {
		return Integer.parseInt(currentLine[header.get(key)]);
	}

	public int readNextByteValue(String key) {
		return Byte.parseByte(currentLine[header.get(key)]);
	}

	public void close() throws IOException {
		in.close();
	}

	private void loadHeader() throws IOException {
		header = new HashMap<>();

		readLine();

		for (int i = 0; i < currentLine.length; i++) {
			header.put(currentLine[i], i);
		}
	}
}
