package com.techblazer.rest.webservices.todo;

import java.net.URI;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {
	
	private Logger log = Logger.getLogger(TodoController.class);
	
	@Autowired
	private TodoServiceStub todoServiceStub;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(String username) {
		return todoServiceStub.findAll();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable("username") String username, @PathVariable("id") long id) {
		return todoServiceStub.findById(id);
	}	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username") String username, @PathVariable("id") long id) {
		Todo todo = todoServiceStub.deleteById(id);
		log.info(todo);
		if(todo != null) {
			return ResponseEntity.noContent().build();
		} 
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("username") String username, @PathVariable("id") long id, @RequestBody Todo todo) {
		Todo todoUpdated = todoServiceStub.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> updateTodo(@PathVariable("username") String username, @RequestBody Todo todo) {
		Todo createdTodo = todoServiceStub.save(todo);
		
		// return url as response instead of the body
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	

}
