package com.example.jdbcdemo.service;

import com.example.jdbcdemo.model.Cart;

public interface CartService {

	void create(Cart cart);

	Cart getById(Long id);

	void update(Cart e);

	void deleteById(long l);

}
