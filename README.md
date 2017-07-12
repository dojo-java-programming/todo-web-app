`master` [![Build Status](https://travis-ci.org/dojo-java-programming/todo-web-app.svg?branch=master)](https://travis-ci.org/dojo-java-programming/todo-web-app)
[![codecov.io](https://codecov.io/github/dojo-java-programming/todo-web-app/coverage.svg?branch=master)](https://codecov.io/github/dojo-java-programming/todo-web-app?branch=master)


# To Do List - REST API


## Jetty


### Running from Jetty in Eclipse

	curl  -X GET  http://localhost:8080/
	curl  -X GET  http://localhost:8080/api/v1.0/todos
	curl  -X GET  http://localhost:8080/api/v1.0/todos/2
	
	curl  -X POST  http://localhost:8080/ -d "{
		"id": #,
		"title": "some title",
		"description": "some description"
	}"
	
	curl  -X DELETE  http://localhost:8080/api/v1.0/todos/2

    curl  -X POST  -H "Content-Type=application/x-www-form-urlencoded"  http://localhost:8080/api/v1.0/todos  -d "id=6&title=Read%20Books&description=do-it"
    

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
