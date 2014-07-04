package com.sirma.itt.javacourse.third;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reverses the content of a file.
 * 
 * @author Nikolay Ch
 * 
 */
public class FileReverse {

	private Scanner buffRead = null;
	private StringBuffer getFromFile;

	/**
	 * Reads from file in a buffer, reverses the buffer and writes the reversed
	 * buffer in the file.
	 * 
	 * @param path
	 *            the path where the file is
	 * @throws IOException
	 */
	public void reverseFile(String path) throws IOException {
		// reads from the file
		buffRead = new Scanner(new FileReader(path));
		String line = null;
		getFromFile = new StringBuffer("");
		while (buffRead.hasNext()) {
			line = buffRead.next();
			if (buffRead.hasNext()) {
				// line += "\n";
			}

			getFromFile.append(line);

		}
		buffRead.close();
		// reverses the buffer
		getFromFile.reverse();

		// rewrites in the file
		FileWriter fwrite = new FileWriter(path);
		fwrite.write(getFromFile.toString());
		fwrite.close();
		buffRead.close();
	}

}