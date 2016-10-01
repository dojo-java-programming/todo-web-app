package org.organisation.todolist;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.organisation.todolist.domain.Todo;

public class TodoServiceTest {

	@Test
	public void getAll() throws Exception {
		TodoService service = new TodoService();
		Collection<Todo> todos = service.getAll();

		assertNotNull(todos);
		assertEquals(3, todos.size());
	}

	@Test
	public void getById() throws Exception {
		TodoService service = new TodoService();
		Todo todo = service.getById(2);

		assertNotNull(todo);
		assertEquals(2, todo.getId());
		assertEquals("Read 'The Clean Coder: A Code of Conduct for Professional Programmers'", todo.getTitle());
	}

}
