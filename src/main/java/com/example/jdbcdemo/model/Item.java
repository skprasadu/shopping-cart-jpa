package com.example.jdbcdemo.model;

public class Item {
	
	public Item() {
		
	}
	
	public Item(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private Long id;
	private String name;
	
}
