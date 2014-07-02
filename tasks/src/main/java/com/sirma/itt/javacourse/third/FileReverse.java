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

	private Scanner br = null;
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
		br = new Scanner(new FileReader(path));
		String line = null;
		getFromFile = new StringBuffer("");
		while (br.hasNext()) {
			line = br.next();
			if (br.hasNext()) {
				// line += "\n";
			}

			getFromFile.append(line);

		}
		br.close();
		// reverses the buffer
		getFromFile.reverse();
		System.out.println(getFromFile.toString());

		// rewrites in the file
		FileWriter fwrite = new FileWriter(path);
		fwrite.write(getFromFile.toString());
		fwrite.close();
	}

}