package com.sirma.itt.javacourse.sixth;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.javacourse.sixth.DataClass;
import com.sirma.itt.javacourse.sixth.Serialize;

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
	 */
	@Test
	public void testGetObject() throws ClassNotFoundException {
		DataClass object = new DataClass();
		object.setName("Gogo");
		object.setNumber(22);
	
		Serialize.saveObject("C:/asdf/serial.txt", object);// serializes the
															// object by the
															// method saveObject
		DataClass deser;
		deser = Serialize.getObject("C:/asdf/serial.txt");// deserializes the
												          // object by the
														  // method getObject
														  // in new instance

		assertEquals(object.getName(), deser.getName());// compares both name
														// fields
		assertEquals(object.getNumber(), deser.getNumber());// compares both
															// number fields
	}

}
