package com.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.todo.entity.Todo;
import com.todo.service.TodoService;

@RestController
public class Todocontroller {

	@Autowired
	TodoService todoService;
	
	
	
	//To get all todo activity
	@GetMapping("/todos")	
	public ResponseEntity<List<Todo>> getTodos()
	{
	List<Todo> todos=(List<Todo>)this.todoService.getAllTodos();	
	if(todos.size()<=0)
	{
	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	return ResponseEntity.status(HttpStatus.CREATED).body(todos);	
	}
	
	
	
	
	//To get knowledge about a single todo activity
	//we need to pass the id of the particular activity to know about the particular activity
	@GetMapping("/todos/{id}")
	public ResponseEntity<Todo> getTodos(@PathVariable("id") int id)
	{
		Todo todo=this.todoService.getTodoById(id);
		if(todo==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(todo));
	}

	
	
	
	//To add a todoactivity
	//we pass data in JSON format
	@PostMapping("/todos")
	public ResponseEntity<Todo> addtodos(@RequestBody Todo activity)
	{Todo p=null;
		try {
			p=this.todoService.addTodos(activity);
			return ResponseEntity.of(Optional.of(p));
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	
	
	
	//To Delete a todo activity
	//we need to pass id of product to be deleted
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("id") int id)
	{
	try {
		this.todoService.deleteTodo(id);;
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}	
	catch(Exception e)
	{
	e.printStackTrace();
	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	}

	
	
	
	//To Update an activity
	//we need to pass the id of the activity need to be updated
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodos(@RequestBody Todo todo,@PathVariable("id") int id)
	{
		try {
			
			this.todoService.update(todo, id);
			return ResponseEntity.ok().body(todo);
			
		}
		catch(Exception e)
		{e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
