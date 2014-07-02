package com.sirma.itt.javacourse.first;

import java.io.Console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class which reads from the console different types data.
 * 
 * @author Nikolay Ch
 * 
 */
public class Read {
	private static Console cnsl;
	final static Logger logger = LoggerFactory.getLogger(Read.class);

	/**
	 * Initializes the scanner and the console.
	 */

	private static void initialize() {
		cnsl = System.console();

	}

	/**
	 * Reads from the console a string.
	 * 
	 * @return the read from the console string
	 */
	public static String readString() {
		initialize();
		logger.info("Enter a string.");
		String string = "";

		string = cnsl.readLine();

		return string;
	}

	/**
	 * Reads an integer from the console and returns it.
	 * 
	 * @return the read integer
	 */
	public static int readInt() {
		initialize();
		logger.info("Enter an integer.");
		String output = cnsl.readLine();
		int outputInt = 0;
		try {
			outputInt = Integer.parseInt(output);
		} catch (Exception e) {
			logger.warn("Please enter integer.");
			readInt();
		}
		return outputInt;
	}

	/**
	 * Reads an float from the console and returns it
	 * 
	 * @return the read float
	 */
	public static float readFloat() {
		initialize();
		logger.info("Enter a float.");
		String output = cnsl.readLine();
		float outputFloat = 0;
		try {
			outputFloat = Float.parseFloat(output);
		} catch (Exception e) {
			readFloat();
		}
		return outputFloat;
	}

	/**
	 * Reads a char from the console.
	 * 
	 * @return the read char
	 */
	public static char readChar() {
		initialize();
		logger.info("Enter an string.");
		String outputChar = cnsl.readLine();
		return outputChar.charAt(0);
	}
}
