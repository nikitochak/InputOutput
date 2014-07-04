package com.sirma.itt.javacourse.sixth;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests the serizlization.
 * 
 * @author Nikolay Ch
 * 
 */
public class SerizlizeTest {

	/**
	 * Tests the methods for serializing an object and deserializing.
	 * 
	 * @throws ClassNotFoundException
	 *             when the class is not found in the file.
	 * @throws IOException
	 *             when an error occurs
	 */
	@Test
	public void testGetObject() throws ClassNotFoundException, IOException {
		DataClass object = new DataClass();
		object.setName("Gogo");
		object.setNumber(22);

		Serializator.saveObject("C:/asdf/serial.txt", object);// serializes the
																// object by the
																// method
																// saveObject
		DataClass deser;
		deser = Serializator.getObject("C:/asdf/serial.txt");// deserializes the
																// object by the
																// method
																// getObject
																// in new
																// instance

		assertEquals(object.getName(), deser.getName());// compares both name
														// fields
		assertEquals(object.getNumber(), deser.getNumber());// compares both
															// number fields
	}

}
