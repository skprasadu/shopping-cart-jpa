package com.example.jdbcdemo.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	public Cart() {

	}

	public Cart(Long id, String name) {
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

	//TODO: uncomment this to make 1 stretch test testUpdateProjectAndEmployees
	/*private List<Item> items = new ArrayList<>();

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}*/
}
