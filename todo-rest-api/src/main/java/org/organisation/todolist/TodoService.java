package org.organisation.todolist;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Request;
//import javax.ws.rs.core.UriInfo;

import org.organisation.todolist.domain.Todo;
import org.organisation.todolist.repository.SimpleTodoRepository;
import org.organisation.todolist.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/todos")
public class TodoService {
	private Logger logger = LoggerFactory.getLogger(TodoService.class);
	private static TodoRepository repo = new SimpleTodoRepository(); //null;//CsvTodoRepository.create();

	// TODO Make private ?
//	@Context
//	UriInfo uriInfo;
//	@Context
//	Request request;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Todo> getAll() {
		logger.info("getAll()");
		return repo.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Todo getById(@PathParam("id") long id) {
		logger.info("getById( " + id + " )");
		Todo todo = repo.get(id);
		logger.info("Found Todo '" + todo.getId() + "'  '" + todo.getTitle() +  "'");
		return todo;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search")
	public Todo searchById(@FormParam("id") String idStr) {
		return getById(Long.parseLong(idStr));
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void add(@FormParam("id") String idStr,
		      @FormParam("title") String title,
		      @FormParam("description") String description,
		      @Context HttpServletResponse servletResponse) throws IOException {
		Todo todo = new Todo();
		todo.setId(Long.valueOf(idStr));
		todo.setTitle(title);
		todo.setDescription(description);
		repo.add(todo);

		servletResponse.setStatus(HttpServletResponse.SC_CREATED);
		servletResponse.flushBuffer();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(final Todo todo,
		      @Context HttpServletResponse servletResponse) throws IOException {
		logger.info("Add TODO entry!!");
		repo.add(todo);
		
		servletResponse.setStatus(HttpServletResponse.SC_CREATED);
		servletResponse.flushBuffer();
	}

	@PUT
	public void update() {
		throw new RuntimeException("Not yet implemented!");
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void remove(@PathParam("id") long id, @Context HttpServletResponse servletResponse) throws IOException {
		repo.remove(id);

		servletResponse.setStatus(HttpServletResponse.SC_OK);
		servletResponse.flushBuffer();
	}

}
