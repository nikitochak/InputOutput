package com.sirma.itt.javacourse.fourth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Has two fields of type InputStream and OutputStream. Has a method for
 * transferring from InputStream to OutputStream
 * 
 * @author Nikolay Ch
 * 
 */
public class TransferObject {
	private InputStream inStream;
	private OutputStream outStream;

	/**
	 * The constructor for the class which initializes the Input and Output
	 * streams.
	 * 
	 * @param inStream
	 *            the Input stream
	 * @param outStream
	 *            the Output Stream
	 */
	public TransferObject(InputStream inStream, OutputStream outStream) {
		this.inStream = inStream;
		this.outStream = outStream;
	}

	/**
	 * Method which transfers the characters from input stream to output stream.
	 * Returns the number of the successfully transfered characters.
	 * 
	 * @param numberOfBytes
	 *            defines how bytes must be transfered
	 * @param offset
	 *            defines the number of bytes which must be skipped before the
	 *            start of the transfer
	 * @return the number of the bytes transfered successfully
	 * @throws IOException
	 */
	public int transfer(int numberOfBytes, int offset) throws IOException {
		int countOfSuccess = numberOfBytes;
		byte[] buffer = new byte[1024];
		int getByte = 0;
		for (int i = 0; getByte != -1; i++) {
			getByte = inStream.read();
			buffer[i] = (byte) getByte;
		}
		// int counter = offset;

		try {
			outStream.write(buffer, offset, numberOfBytes);
		} catch (IOException e) {
			countOfSuccess--;
		}
		inStream.close();
		outStream.close();
		return countOfSuccess;
	}

	/**
	 * Getter for the OutputStream field.
	 * 
	 * @return the value of the field
	 */
	public OutputStream getOut() {
		return this.outStream;
	}

	/**
	 * Getter for the inStream field.
	 * 
	 * @return the value of the field
	 */
	public InputStream getIn() {
		return this.inStream;
	}
}
