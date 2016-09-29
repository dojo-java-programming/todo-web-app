package org.organisation.todolist.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TodoTest {

	@Test
	public void create() throws Exception {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setTitle("Title");
		todo.setDescription("Description");

		assertEquals(1, todo.getId());
		assertEquals("Title", todo.getTitle());
		assertEquals("Description", todo.getDescription());
	}

}
