package org.organisation.todolist.repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.organisation.todolist.domain.Todo;

public class TodoRepository {
	private final Map<Long, Todo> todos = new LinkedHashMap<>();


	public void add(final Todo todo) {
		todos.put(todo.getId(), todo);
	}

	public void remove(final long id) {
		if (todos.containsKey(Long.valueOf(id))) {
			todos.remove(Long.valueOf(id));
		}
	}

	public Collection<Todo> getAll() {
		return todos.values();
	}

	public Todo get(long id) {
		if (! todos.containsKey(Long.valueOf(id))) {
			return null;
		}

		return todos.get(Long.valueOf(id));
	}

}
