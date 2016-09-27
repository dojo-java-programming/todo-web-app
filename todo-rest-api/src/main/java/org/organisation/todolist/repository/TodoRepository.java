package org.organisation.todolist.repository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.organisation.todolist.domain.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodoRepository {
	private Logger logger = LoggerFactory.getLogger(TodoRepository.class);
	private final Map<Long, Todo> todos = new LinkedHashMap<>();


	public void add(final Todo todo) {
		logger.info("Add '" + todo.getId() + "'  '" + todo.getTitle() + "'");
		todos.put(todo.getId(), todo);
	}

	public void remove(final long id) {
		logger.info("Remove '" + id + "'");
		if (todos.containsKey(Long.valueOf(id))) {
			todos.remove(Long.valueOf(id));
		}
		else {
			logger.info("Not a known id '" + id + "'");
		}
	}

	public Collection<Todo> getAll() {
		logger.info("Get all");
		return todos.values();
	}

	public Todo get(long id) {
		logger.info("Get '" + id + "'");
		if (! todos.containsKey(Long.valueOf(id))) {
			return null;
		}

		return todos.get(Long.valueOf(id));
	}

}
