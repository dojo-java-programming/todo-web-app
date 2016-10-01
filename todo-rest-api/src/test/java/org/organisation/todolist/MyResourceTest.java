package org.organisation.todolist;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyResourceTest {

	@Test
	public void create() throws Exception {
		String text = new MyResource().getIt();

		assertNotNull(text);
		assertEquals("Got it!", text);
	}

}
