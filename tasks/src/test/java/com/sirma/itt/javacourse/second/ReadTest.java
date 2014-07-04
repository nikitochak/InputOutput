package com.sirma.itt.javacourse.second;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * Tests the method in the class Read.
 * 
 * @author Nikolay Ch
 * 
 */
public class ReadTest {
	private Read testRead;
	private InputStream inStreamTest;
	private InputStream inFromSavedByMeth;
	private Scanner scanTest;
	private Scanner scanTestMeth;
	private String allBeforeMeth;
	private String allAfterMeth;

	/**
	 * Tests the method for reading from an Input Stream and saving in a file.
	 * First makes a file with some content. After that saves this content in
	 * the other file by the method. Then reads the contents of the both files
	 * and saves them in two strings. At last compares the strings.
	 * 
	 * @throws IOException
	 *             when there is an error in the input or output streams
	 */
	@Test
	public void testReadAndSave() throws IOException {
		// reads from the first file and saves it from the second
		inStreamTest = new FileInputStream("C:/asdf/test2.txt");
		testRead = new Read(inStreamTest);
		testRead.readAndSave();

		// reads the content of the first file and saves it in a string
		allBeforeMeth = "";
		String line = "";
		inStreamTest = new FileInputStream("C:/asdf/test2.txt");
		scanTest = new Scanner(inStreamTest);
		line = scanTest.nextLine();
		while (!line.equals(".")) {
			line = scanTest.nextLine();
			allBeforeMeth += line;
			if (!line.equals(".")) {
				allBeforeMeth += "\n";
			}
		}

		// reads from the second file and saves it in another string
		inFromSavedByMeth = new FileInputStream(
				"C:/Users/Admin/Sirma/InputOutput/tasks/test.txt");

		scanTestMeth = new Scanner(inFromSavedByMeth);
		String line2 = "";
		allAfterMeth = "";
		while (!line2.equals(".")) {
			line2 = scanTestMeth.nextLine();
			allAfterMeth += line2;
			if (!line2.equals(".")) {
				allAfterMeth += "\n";
			}
		}

		assertEquals(allBeforeMeth, allAfterMeth);

		inStreamTest.close();
		inFromSavedByMeth.close();
		scanTest.close();
		scanTestMeth.close();
	}
}
