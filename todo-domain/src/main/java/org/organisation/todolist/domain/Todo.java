package org.organisation.todolist.domain;

import org.apache.commons.lang3.StringUtils;

public class Todo {
	private long id;
	private String title;
	private String description;


	public Todo() {
		super();
	}


	public Todo(final long id, final String title, final String description) {
		this();
		final String titleCln = StringUtils.trimToNull(title);
		if (titleCln == null) {
			throw new IllegalArgumentException("Argument 'title' should not be null.");
		}

		this.id = id;
		this.title = titleCln;
		this.description = StringUtils.trimToNull(description);
	}
	public Todo(int id, final String title) {
		this(id, title, null);
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
