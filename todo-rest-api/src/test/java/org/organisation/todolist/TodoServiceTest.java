package org.organisation.todolist;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.organisation.todolist.domain.Todo;

public class TodoServiceTest {
	@Mock
	private HttpServletResponse httpServletResponse;


	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void getAll() throws Exception {
		TodoService service = new TodoService();
		Collection<Todo> todos = service.getAll();

		assertNotNull(todos);
		assertEquals(4, todos.size());
	}

	@Test
	public void getById() throws Exception {
		TodoService service = new TodoService();
		Todo todo = service.getById(2);

		assertNotNull(todo);
		assertEquals(2, todo.getId());
		assertEquals("Read 'The Clean Coder: A Code of Conduct for Professional Programmers'", todo.getTitle());
	}

	@Test
	public void searchById() throws Exception {
		TodoService service = new TodoService();
		Todo todo = service.searchById("1");
		assertEquals(1, todo.getId());
		assertEquals("Read 'Domain-Driven Design Reference: Definitions and Pattern Summaries'", todo.getTitle());
	}

	@Test
	public void add() throws Exception {
		TodoService service = new TodoService();
		service.add("6", "Read 'Kotlin in Action'", null, httpServletResponse);
		
		Todo todo = service.getById(6);
		assertEquals(6, todo.getId());
		assertEquals("Read 'Kotlin in Action'", todo.getTitle());
	}

	@Test
	public void addByArguments() throws Exception {
		TodoService service = new TodoService();
		service.add(new Todo(5, "Read 'Angular 2 Development with TypeScript'"), httpServletResponse);

		assertEquals(4, service.getAll().size());
		Todo todo = service.getById(5);
		assertEquals(5, todo.getId());
		assertEquals("Read 'Angular 2 Development with TypeScript'", todo.getTitle());
	}

	@Test(expected = RuntimeException.class)
	public void update() throws Exception {
		new TodoService().update();
	}

	@Test
	public void remove() throws Exception {
		new TodoService().remove(3, httpServletResponse);
	}

}
