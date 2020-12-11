package com.todo.dao;

import org.springframework.data.repository.CrudRepository;

import com.todo.entity.Todo;

public interface TodoRepository extends CrudRepository <Todo,Integer> {
	public Todo findById(int id);

}
