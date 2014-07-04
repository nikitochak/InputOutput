package com.sirma.itt.javacourse.first;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Scanner;

import org.junit.Test;

/**
 * 
 * Tests the methods in the ConsoleReader class
 * 
 * @author Nikolay Ch
 * 
 */
public class ConsoleReaderTest {

	private Scanner scan;

	/**
	 * Tests the methods for reading different types. Changes the static field
	 * BufferedReader with a reflection. Then reads from file and compares the
	 * results.
	 * 
	 * @throws NoSuchFieldException
	 *             when its tried to access a file that is non existing
	 * @throws SecurityException
	 *             when the security manager indicates a security violation
	 * @throws IllegalArgumentException
	 *             when a method has been passed an illegal or inappropriate
	 *             argument
	 * @throws IllegalAccessException
	 *             when an application tries to reflectively create an instance
	 *             (other than an array), set or get a field, or invoke a
	 *             method, but the currently executing method does not have
	 *             access to the definition of the specified class, field,
	 *             method or constructor
	 * @throws IOException
	 *             an I/O exception of some sort has occurred
	 */
	@Test
	public void testRead() throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, IOException {
		
		
		InputStream inStream = new FileInputStream("C:/asdf/test2.txt");
		InputStream inForScan = new FileInputStream("C:/asdf/test2.txt");
		
		Field field = ConsoleReader.class.getDeclaredField("reader");
		field.setAccessible(true);

		field.set(field.get(null), new BufferedReader(new InputStreamReader(
				inStream)));

		scan = new Scanner(inForScan);
		String line = "";
		String stringFile = scan.nextLine();
		line = scan.nextLine();
		int intFile = Integer.parseInt(line);
		line = scan.nextLine();
		float floatFile = Float.parseFloat(line);
		line = scan.nextLine();
		char character = line.charAt(0);

		assertEquals(stringFile, ConsoleReader.readString());
		assertEquals(intFile, ConsoleReader.readInt());
		assertEquals(floatFile, ConsoleReader.readFloat(), 2);
		assertEquals(character, ConsoleReader.readChar());
		
		inStream.close();
		inForScan.close();
		scan.close();
		ConsoleReader.close();
	}

}
