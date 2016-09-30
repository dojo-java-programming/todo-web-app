package org.organisation.todolist.domain;

import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TodoTest {
	@Rule
	public ExpectedException expExcep = ExpectedException.none();


	@Test
	public void createBySetters() throws Exception {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setTitle("Title");
		todo.setDescription("Description");

		assertEquals(1, todo.getId());
		assertEquals("Title", todo.getTitle());
		assertEquals("Description", todo.getDescription());
	}

	@Test
	public void createByConstructor() throws Exception {
		Todo todo = new Todo(1, "Title", "Description");

		assertEquals(1, todo.getId());
		assertEquals("Title", todo.getTitle());
		assertEquals("Description", todo.getDescription());
	}

	@Test
	public void createNoDescription() throws Exception {
		Todo todo = new Todo(1, "Title");

		assertEquals(1, todo.getId());
		assertEquals("Title", todo.getTitle());
		assertNull(todo.getDescription());
	}

	@Test
	public void createTitleNull() throws Exception {
		expExcep.expect(IllegalArgumentException.class);
		expExcep.expectMessage(new IsEqual<String>("Argument 'title' should not be null."));

		new Todo(1, null);
	}

}
