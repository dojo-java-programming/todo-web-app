`master` [![Build Status](https://travis-ci.org/dojo-java-programming/todo-web-app.svg?branch=master)](https://travis-ci.org/dojo-java-programming/todo-web-app)


# To Do List - REST API


## Jetty

### Running from Jetty in Eclipse

	GET  http://localhost:8080/
	GET  http://localhost:8080/api/v1.0/todos
	GET  http://localhost:8080/api/v1.0/todos/2
	
	POST  http://localhost:8080/api/v1.0/todos
	body:
	{
		"id": #,
		"title": "some title",
		"description": "some description"
	}
	
	DELETE  http://localhost:8080/api/v1.0/todos/2


### Running from Jetty in IntelliJ


	GET  http://localhost:8080/todo-rest-api-parent-pom/
	GET  http://localhost:8080/todo-rest-api-parent-pom/api/v1.0/todos
	GET  http://localhost:8080/todo-rest-api-parent-pom/api/v1.0/todos/2
	
	POST  http://localhost:8080/todo-rest-api-parent-pom/api/v1.0/todos
	body:
	{
		"id": #,
		"title": "some title",
		"description": "some description"
	}
	
	DELETE  http://localhost:8080/todo-rest-api-parent-pom/api/v1.0/todos/2
