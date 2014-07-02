package com.sirma.itt.javacourse.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads from the console and saves in a file.
 * 
 * @author Nikolay Ch
 * 
 */
public class Read {
	private static Scanner sc = new Scanner(System.in);
	private static PrintWriter fw;

	/**
	 * Reads line by line from the console and saves it in a file.
	 * 
	 * @throws IOException
	 */
	public static void readAndSave() throws IOException {
		fw = new PrintWriter("test.txt");

		String line = "";

		while (!line.equals(".")) {
			try {
				line = sc.nextLine();
				if (!line.equals(".")) {
					fw.println();
				}
			} catch (Exception e) {

				fw.close();
			}
			fw.write(line);
		}

		fw.close();
	}
}
