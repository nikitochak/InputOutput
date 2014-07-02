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
	DirectoryBrowser db = new DirectoryBrowser();

	/**
	 * Tests listContent method. First the path is invalid so it must rerun
	 * none. Second the path indicates to a file so it must return file. And at
	 * last the path indicates to a directory where there is only one folder
	 * named sirma.
	 */
	@Test
	public void testListContent() {

		assertEquals("none", db.listContent("Ivan/Dragan"));
		assertEquals(
				"file",
				db.listContent("C:/Users/Admin/Sirma/InputOutput/tasks/src/test/resources/com/sirma/itt/javacourse/fourth/testfile"));
		assertEquals(
				"sirma\n",

				db.listContent("C:/Users/Admin/Sirma/InputOutput/tasks/src/test/resources/com"));

	}

}
