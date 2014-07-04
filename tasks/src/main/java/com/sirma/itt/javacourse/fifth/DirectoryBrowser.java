package com.sirma.itt.javacourse.fifth;

import java.io.File;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Has Path field, File field, File array and method for checking if the path
 * indicates to a file or directory.
 * 
 * @author Nikolay Ch
 * 
 */
public class DirectoryBrowser {
	private static Path pathTo;
	private static File directory;
	private static File[] listOfFiles;

	/**
	 * Creates a Path from a string. Verifies and if the path is indicating to
	 * file returns file. If the path indicates to a directory returns all its
	 * attributes.
	 * 
	 * @param path
	 *            the string in which the path is
	 * @return none - if the path is false; file - if the path is indicating to
	 *         a file; all names of attributes - if the path indicates a
	 *         directory
	 * 
	 */
	public static String listContent(String path) {

		pathTo = FileSystems.getDefault().getPath(path);
		if (Files.isRegularFile(pathTo)) {
			return "file";
		} else if (Files.isDirectory(pathTo)) {
			String output = "";
			directory = new File(path);
			listOfFiles = directory.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				output += listOfFiles[i].getName();
				output += "\n";
			}

			return output;
		} else {
			return "none";
		}

	}

}
