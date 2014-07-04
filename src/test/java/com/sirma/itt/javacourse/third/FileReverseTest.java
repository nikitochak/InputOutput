package com.sirma.itt.javacourse.third;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

/**
 * Tester for the FileReverse class.
 * 
 * @author Nikolay Ch
 * 
 */
public class FileReverseTest {

	private Scanner scan;
	private Scanner inFile;

	/**
	 * Tests the reversing of the file characters. Reads once from the file
	 * before it is reversed and reverses here. After that reverses the file by
	 * the method and compares the results.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testReverseFile() throws IOException {
		FileReverse fileRev = new FileReverse();
		inFile = new Scanner(new FileReader("C:/asdf/test.txt"));
		String string = "";

		while (inFile.hasNext()) {
			string += inFile.next();
		}
		String debugRev = "";
		for (int i = string.length() - 1; i >= 0; i--) {
			debugRev += string.charAt(i);
		}

		fileRev.reverseFile("C:/asdf/test.txt");
		scan = new Scanner(new FileReader("C:/asdf/test.txt"));
		String revByMethod = scan.next();

		assertEquals(debugRev, revByMethod);
		scan.close();
		inFile.close();
	}
}
