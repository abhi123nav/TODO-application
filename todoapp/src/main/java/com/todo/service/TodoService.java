package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.todo.dao.TodoRepository;

import com.todo.entity.Todo;

@Service
public class TodoService {

	
	@Autowired
	Todo todoRepository;

	public List<Todo> getAllTodos()
	{
		List<Todo> list=(List<Todo>) ((CrudRepository<Todo, Integer>) this.todoRepository).findAll();
		return list;
	}


	//get single product
	public Todo getTodoById(int id)
	{
		Todo product=null;
		try {
			product=((TodoRepository) this.todoRepository).findById(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return product;
	}
	//POST
	public Todo addTodos(Todo p)
	{
		Todo result=((CrudRepository<Todo, Integer>) todoRepository).save(p);
		return result;
	}


	//Delete
	public void deleteTodo(int id)
	{
		((CrudRepository<Todo, Integer>) this.todoRepository).deleteById(id);
	}
	//update
	public void update(Todo product,int id)
	{
		product.setId(id);
	((CrudRepository<Todo, Integer>) this.todoRepository).save(product);	
	}
}
