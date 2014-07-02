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

	private BufferedReader br;

	/**
	 * Tests the method for transferring. Makes an instance of the
	 * transferObject class. Invokes the method and keeps in a string the
	 * result, reading from file. After that reads the file again and keeps the
	 * characters after the offset to the exerted length. In the end compares the two strings.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testTransfer() throws IOException {

		String path = "C:/Users/Admin/Sirma/InputOutput/tasks/src/test/resources/com/sirma/itt/javacourse/fourth/testfile";
		InputStream in = new FileInputStream(path);
		OutputStream ot = new ByteArrayOutputStream(1024);

		TransferObject to = new TransferObject(in, ot);
		to.transfer(10, 5);

		String fromMethod = to.outStream.toString();
		String testString = "";
		br = new BufferedReader(new FileReader(path));
		for (int i = 0; i < 15; i++) {
			int c = br.read();
			char s = (char) c;
			if (i >= 5) {
				testString += s;
			}
		}
		assertEquals(testString, fromMethod);

	}

}
