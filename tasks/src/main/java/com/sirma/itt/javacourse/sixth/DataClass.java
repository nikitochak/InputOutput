package com.sirma.itt.javacourse.sixth;

/**
 * Class with some data. It can be serialized.
 * 
 * @author Nikolay Ch
 */
@SuppressWarnings("serial")
public class DataClass implements java.io.Serializable {
	private String name;
	private int number;

	/**
	 * Getter for the field name.
	 * 
	 * @return the value of the field
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the field number.
	 * 
	 * @return the value of the field
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Setter for the field name.
	 * 
	 * @param name
	 *            the value for the field
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter for the private field number.
	 * 
	 * @param number
	 *            the value for the field
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}