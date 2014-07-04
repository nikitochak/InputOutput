package com.sirma.itt.javacourse.first;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class that reads strings, numbers and floats from the console.
 * 
 * @author Nikolay Ch
 */

public class ConsoleReader {
	private static BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
	static Logger logger = LoggerFactory.getLogger(ConsoleReader.class);

	/**
	 * Reads a line of input and converts it into an integer. If it is not an
	 * integer allows the customer to enter new number.
	 * 
	 * @return the integer that the user typed
	 * @throws IOException
	 *             when there is an error in the reading of the input stream
	 */
	public static int readInt() throws IOException {
		String inputString = reader.readLine();
		int num = 0;
		try {
			num = Integer.parseInt(inputString);
		} catch (NumberFormatException e) {
			logger.warn("Your input is not a number. Please enter a number. ");
			readInt();
		}
		return num;
	}

	/**
	 * Reads a line of input and converts it into a float number. If the input
	 * is not a float number allows the customer to insert new number.
	 * 
	 * @return the number that the user typed
	 * @throws IOException
	 *             when an error is catched in the read of the console
	 */
	public static float readFloat() throws IOException {
		String inputString = reader.readLine();
		float floatNum = 0;
		try {
			floatNum = Float.parseFloat(inputString);
		} catch (NumberFormatException e) {
			logger.warn("Please insert a float number.");
			readFloat();
		}
		return floatNum;
	}

	/**
	 * Reads a String until its correct.
	 * 
	 * @return the String of input that the user typed
	 */

	public static String readString() {
		String inputLine = "";

		try {
			inputLine = reader.readLine();
		} catch (IOException e) {
			logger.warn("Sorry there is a mistake. Please enter new String.");
			readString();
		}

		return inputLine;
	}

	/**
	 * Reads the line of the input and returns a character.
	 * 
	 * @return the first character of the line
	 */
	public static char readChar() {
		String inputLine = "";
		char character;
		try {
			inputLine = reader.readLine();
		} catch (IOException e) {
			logger.warn("Sorry there is a mistake. Please enter new String.");
			readString();
		}
		character = inputLine.charAt(0);
		return character;
	}

	/**
	 * Closes the reader.
	 * 
	 * @throws IOException
	 *             when a error is occurred in closing
	 */
	public static void close() throws IOException {
		reader.close();
	}
}
