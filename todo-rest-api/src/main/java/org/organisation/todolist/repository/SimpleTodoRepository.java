package org.organisation.todolist.repository;

import org.organisation.todolist.domain.Todo;

public class SimpleTodoRepository extends TodoRepository {


	public SimpleTodoRepository() {
		super();

		add(new Todo(1, "Read 'Domain-Driven Design Reference: Definitions and Pattern Summaries'"));
		add(new Todo(2, "Read 'The Clean Coder: A Code of Conduct for Professional Programmers'"));
		add(new Todo(3, "Read 'Design Patterns: Elements of Reusable Object-Oriented Software'"));
	}


	public static TodoRepository create() {
		return new SimpleTodoRepository();
	}
	
}
