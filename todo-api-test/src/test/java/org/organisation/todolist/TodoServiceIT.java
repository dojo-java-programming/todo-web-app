package org.organisation.todolist;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.organisation.todolist.domain.Todo;

public class TodoServiceIT {
	private String baseUri = "http://localhost:8080/api/v1.0";

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
			.body("id", equalTo("1"), 
					"title", equalTo("Read 'The Clean Coder: A Code of Conduct for Professional Programmers'"));
	}

	@Test
	public void add() throws Exception {
		given()
			.contentType(MediaType.APPLICATION_JSON)
			.body(new Todo(10, "Read Refactoring"))
		.when()
			.post(baseUri + "/todos")
		.then()
			.statusCode(200)
			.log();

		given()
		.when()
			.get(baseUri + "/todos/10")
		.then()
			.statusCode(200)
			.contentType(MediaType.APPLICATION_JSON)
			.body("id", equalTo("10"));
	}

//	@Test
//	public void update() throws Exception {
//		given()
//		.when()
//			.put()
//		.then()
//			.body();
//	}
//
//	@Test
//	public void remove() throws Exception {
//		
//	}

}
