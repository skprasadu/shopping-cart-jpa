package com.example.jdbcdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jdbcdemo.model.Cart;
import com.example.jdbcdemo.model.Item;

@SpringBootTest
public class ShoppingCartServiceImplTest {
	
	@Autowired
	CartService service;
	
	@Test
	public void testCreateProject() {
		
		Cart e = new Cart(1l, "nv");
		
		service.create(e);
		
		Cart e1 = service.getById(1l);
		
		assertEquals("nv", e1.getName());
		
	}
	
	@Test
	public void testUpdateProject() {
		
		Cart e = new Cart(2l, "nv1");
		
		service.create(e);
		
		e.setName("nv2");
		
		service.update(e);
		
		Cart e1 = service.getById(2l);
		
		assertEquals("nv2", e1.getName());
	}
	
	@Test
	public void testDeleteProject() {
		
		Cart e = new Cart(3l, "nv1");
		
		service.create(e);
		
		Cart e1 = service.getById(3l);
		
		assertEquals("nv1", e1.getName());
		
		service.deleteById(3l);
		
		e1 = service.getById(3l);
		
		assertEquals(null, e1);
	}
	
	@Test
	public void testUpdateProjectAndEmployees() throws IllegalAccessException, IllegalArgumentException, NoSuchMethodException, SecurityException, InvocationTargetException {
		
		Cart p = new Cart(4l, "nv1");
		
		Item e = new Item(1l, "kp");
		
		//p.getEmployees().add(e);
		
		Method fieldGetter = p.getClass().getMethod("getItems");
		List<Item> employees = (List<Item>) fieldGetter.invoke(p);
		
		assertNotNull(employees);
		employees.add(e);
		
		service.create(p);
		
		Cart p1 = service.getById(4l);
		
		p1.setName("nv2");
		Method fieldGetter1 = p1.getClass().getMethod("getItems");
		List<Item> employees1 = (List<Item>) fieldGetter1.invoke(p1);
		assertNotNull(employees1);

		employees1.get(0).setName("kp1");
		
		service.update(p1);
		
		Cart p2 = service.getById(4l);
		assertEquals("nv2", p2.getName());

		Method fieldGetter2 = p2.getClass().getMethod("getItems");
		List<Item> employees2 = (List<Item>) fieldGetter2.invoke(p2);
		assertEquals("kp1", employees2.get(0).getName());
	}

}
