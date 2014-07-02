package com.sirma.itt.javacourse.fourth;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * Tests the TransferObject class. Makes an instance from it and tests the
 * method for transferring.
 * 
 * @author Nikolay Ch
 * 
 */
public class TransferObjectTest {

	private BufferedReader buffRead;

	/**
	 * Tests the method for transferring. Makes an instance of the
	 * transferObject class. Invokes the method and keeps in a string the
	 * result, reading from file. After that reads the file again and keeps the
	 * characters after the offset to the exerted length. In the end compares
	 * the two strings.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testTransfer() throws IOException {

		String path = "C:/asdf/test.txt";
		InputStream input = new FileInputStream(path);
		OutputStream output = new ByteArrayOutputStream(1024);

		TransferObject to = new TransferObject(input, output);
		to.transfer(10, 5);

		String fromMethod = to.outStream.toString();
		String testString = "";
		buffRead = new BufferedReader(new FileReader(path));
		for (int i = 0; i < 15; i++) {
			int charInByte = buffRead.read();
			char character = (char) charInByte;
			if (i >= 5) {
				testString += character;
			}
		}
		assertEquals(testString, fromMethod);

	}

}
