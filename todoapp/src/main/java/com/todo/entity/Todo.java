package com.todo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private	int id;
	String name;
	String pname;
	
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(int id, String name, String pname) {
		super();
		this.id = id;
		this.name = name;
		this.pname = pname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
}
