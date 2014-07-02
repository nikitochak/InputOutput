package com.siema.itt.javacourse.sixth;

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
public class Serialize {

	private static Logger logger = LoggerFactory.getLogger(Serialize.class);

	/**
	 * Saves a serialized object in a file specified by the path.
	 * 
	 * @param path
	 *            the path to the file
	 * @param object
	 *            the object of a class that can be serialized
	 */
	public static void saveObject(String path, DataClass object) {
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

			out.writeObject(object);
			out.close();
			fileOut.close();

		} catch (IOException i) {
			i.printStackTrace();
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
