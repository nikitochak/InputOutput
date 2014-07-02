package com.sirma.itt.javacourse.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads different types by the methods declared in Read class.
 * 
 * @author Nikolay Ch
 * 
 */
public class Main {

	final static Logger logger = LoggerFactory.getLogger(Main.class);

	static String readString = "";
	static int readInt;
	static float readFloat;
	static char readChar;

	/**
	 * Reads the different types.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		readChar = Read.readChar();
		logger.info(readChar + "");

		readString = Read.readString();
		logger.info(readString);

		readInt = Read.readInt();
		logger.info(readInt + "");

		readFloat = Read.readFloat();
		logger.info(readFloat + "");
	}

}
