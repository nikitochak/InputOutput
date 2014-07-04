package com.sirma.itt.javacourse.sixth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Static class which has two methods one for serializing and saving an object
 * in a file and one for reading the object from the file.
 * 
 * @author Nikolay Ch
 * 
 */
public class Serializator {

	private static Logger logger = LoggerFactory.getLogger(Serializator.class);

	/**
	 * Saves a serialized object in a file specified by the path.
	 * 
	 * @param path
	 *            the path to the file
	 * @param object
	 *            the object of a class that can be serialized
	 * @throws IOException
	 */
	public static void saveObject(String path, DataClass object)
			throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;
		try {
			fileOut = new FileOutputStream(path);
			out = new ObjectOutputStream(fileOut);

		} catch (IOException i) {
			logger.warn("Mistake");

		} finally {
			out.writeObject(object);
			out.close();
			fileOut.close();

		}
	}

	/**
	 * Reads an serialized object from the file specified by the path parameter
	 * and return the deserialized object.
	 * 
	 * @param path
	 *            the path where the file is
	 * @return the deserialized object
	 * @throws ClassNotFoundException
	 *             when the class is not found in the file
	 */
	public static DataClass getObject(String path)
			throws ClassNotFoundException {
		DataClass object = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream inStream = new ObjectInputStream(fileIn);
			object = (DataClass) inStream.readObject();
			inStream.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			logger.warn("Employee class not found");
			throw new ClassNotFoundException("");
		}
		return object;
	}
}
