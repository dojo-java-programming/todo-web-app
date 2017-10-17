package org.organisation.todolist;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.organisation.todolist.domain.Todo;

public class TodoServiceIT {
    // Eclipse Jetty
	//private String baseUri = "http://localhost:8080/api/v1.0";
    // Eclipse Tomcat
    private String baseUri = "http://localhost:8080/todo-rest-api/api/v1.0";
    // IntelliJ Jetty
    //private String baseUri = "http://localhost:8080/todo-rest-api-parent-pom/api/v1.0";	

	@Test
	public void getAll() throws Exception {
		given()
		.when()
			.get(baseUri + "/todos")
		.then()
			.statusCode(200)
			.contentType(MediaType.APPLICATION_JSON)
			.log();
//			.body("id", Matchers.hasItems(Long.valueOf(1), Long.valueOf(2)));

	}

	@Test
	public void getById() throws Exception {
		given()
		.when()
			.get(baseUri + "/todos/2")
		.then()
			.statusCode(200)
			.contentType(MediaType.APPLICATION_JSON)
			.body("id", equalTo(Integer.valueOf(2)),
					"title", equalTo("Read 'The Clean Coder: A Code of Conduct for Professional Programmers'"));
	}

	@Test
	public void add() throws Exception {
		given()
			.contentType(MediaType.APPLICATION_JSON)
//			.body(asJson(new Todo(10, "Read Refactoring")))
			.body(new Todo(10, "Read Refactoring"))
		.when()
			.post(baseUri + "/todos")
		.then()
			.statusCode(201)
			.log();

		given()
		.when()
			.get(baseUri + "/todos/10")
		.then()
			.statusCode(200)
			.contentType(MediaType.APPLICATION_JSON)
			.body("id", equalTo(Integer.valueOf(10)));
	}

//	@Test
//	public void update() throws Exception {
//		given()
//		.when()
//			.put()
//		.then()
//			.body();
//	}

	@Test
	public void remove() throws Exception {
		given()
		.when()
			.delete(baseUri + "/todos/1")
		.then()
			.statusCode(200);
	}

	public StringBuilder asJson(final Todo todo) {
		StringBuilder bldr = new StringBuilder();
		append(bldr, "{");
		append(bldr, "    \"id\": \"" + todo.getId() + "\"");
		append(bldr, "    \"title\": \"" + todo.getTitle() + "\"");
		if (todo.getDescription() != null) {
			append(bldr, "    \"description\": \"" + todo.getDescription() + "\"");
		}
		append(bldr, "}");
		return bldr;
	}

	private void append(final StringBuilder bldr, final String text) {
		bldr.append(text).append("\n");
	}

}
