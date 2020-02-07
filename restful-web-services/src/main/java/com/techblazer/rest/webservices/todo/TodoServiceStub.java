package com.techblazer.rest.webservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TodoServiceStub {
	
	private static List<Todo> todos = new ArrayList<Todo>();	
	private static int idCounter = 0;
	
	// a static list of item a stub database
	static {
		todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "Larry Cole", "Angular 7", new Date(), false));
		todos.add(new Todo(++idCounter, "Henry Jordan", "Html", new Date(), false));
		todos.add(new Todo(++idCounter, "Theopilus Max", "Learn Java Programming", new Date(), true));
		todos.add(new Todo(++idCounter, "Dele Mike", "SQL Server", new Date(), false));
		todos.add(new Todo(++idCounter, "in28minutes", "Restful Web Service", new Date(), false));		
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo == null ) return null;
		
		if(todos.remove(todo)) {
			return todo;
		}
		
		return null;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		for (Todo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		
		if(todo.getId() == -1 || todo.getId() == 0) {
			//todo doesn't exist
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			//todo already exist
			deleteById(todo.getId());
			todos.add(todo);
			
		}
		
		return todo;
	}
	

}
