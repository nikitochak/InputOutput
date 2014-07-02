package com.sirma.itt.javacourse.fifth;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the class DirectoryBrowser.
 * 
 * @author Nikolay Ch
 * 
 */
public class DirectoryBrowserTest {

	/**
	 * Tests listContent method. First the path is invalid so it must rerun
	 * none. Second the path indicates to a file so it must return file. And at
	 * last the path indicates to a directory where there is only one folder
	 * named sirma.
	 */
	@Test
	public void testListContent() {

		assertEquals("none", DirectoryBrowser.listContent("Ivan/Dragan"));
		assertEquals("file", DirectoryBrowser.listContent("C:/asc_rdflag"));
		assertEquals("asdf\ntest.txt\n",

		DirectoryBrowser.listContent("C:/asdf"));

	}

}
