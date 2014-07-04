package com.sirma.itt.javacourse.second;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads from the console and saves in a file.
 * 
 * @author Nikolay Ch
 * 
 */
public class Read {
	private static Logger logger = LoggerFactory.getLogger(Read.class);
	private static Scanner scan;
	private static PrintWriter writer;

	/**
	 * Constructor for the class. Initializes the scanner with an InputStream.
	 * 
	 * @param inStream
	 *            the input stream
	 */
	public Read(InputStream inStream) {
		scan = new Scanner(inStream);
	}

	/**
	 * Reads line by line from the console and saves it in a file.
	 * 
	 * @throws IOException
	 */
	public void readAndSave() throws IOException {
		writer = new PrintWriter("test.txt");

		String line = "";

		while (!line.equals(".")) {
			try {
				line = scan.nextLine();
			} catch (Exception e) {
				line = null;
				logger.warn("Please do not make mistakes.");
			} finally {
				if (line != null) {
					writer.write(line);
					if (!line.equals(".")) {
						writer.println();
					}
				}
			}
		}
		scan.close();
		writer.close();
	}
}
