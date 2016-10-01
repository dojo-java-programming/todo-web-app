package org.organisation.todolist.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.junit.Test;
import org.organisation.todolist.domain.Todo;


public class TodoRepositoryTest {

	@Test
	public void getAll() throws Exception {
		TodoRepository repo = SimpleTodoRepository.create();
		
		Collection<Todo> todos = repo.getAll();
		assertNotNull(todos);
		assertEquals(3, todos.size());
	}

	@Test
	public void getById() throws Exception {
		TodoRepository repo = SimpleTodoRepository.create();
		
		Todo todo = repo.get(2);
		assertNotNull(todo);
		assertEquals(2, todo.getId());
		assertEquals("Read 'The Clean Coder: A Code of Conduct for Professional Programmers'", todo.getTitle());
		assertNull(todo.getDescription());
	}

	@Test
	public void getByIdNull() throws Exception {
		TodoRepository repo = SimpleTodoRepository.create();
		
		Todo todo = repo.get(12);
		assertNull(todo);
	}

	@Test
	public void remove() throws Exception {
		TodoRepository repo = SimpleTodoRepository.create();
		repo.remove(2);

		assertEquals(2, repo.getAll().size());
	}

	@Test
	public void removeNull() throws Exception {
		TodoRepository repo = SimpleTodoRepository.create();
		repo.remove(12);
	}

}
