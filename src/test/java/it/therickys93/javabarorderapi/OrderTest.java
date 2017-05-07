package it.therickys93.javabarorderapi;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testOne() {
		assertEquals(1,1);
	}
	
	@Test
	public void testTwo() {
		Product[] products = {new Product("brioches", 2), new Product("cappuccino", 3)};
		Order order = new Order(102, 20, false, products);
		assertEquals(102, order.id());
		assertEquals(20, order.table());
		assertFalse(order.done());
		assertEquals("brioches", order.products()[0].name());
		assertEquals(3, order.products()[1].quantity());
	}
	
	@Test
	public void testThree() {
		Product[] products = {new Product("brioches", 2), new Product("cappuccino", 3)};
		Order order = new Order(102, 20, false, products);
		assertEquals("Order={id=102, table=20, done=false, products="
				+ "[Product={name=brioches, quantity=2}, Product={name=cappuccino, quantity=3}]}", order.toString());
	}
	
	@Test
	public void testFour() {
		Product[] products = {new Product("acqua", 2), new Product("bibite", 3)};
		Order order = new Order(102, 20, false, products);
		assertEquals("{\"id\":102,\"table\":20,\"done\":false,"
				+ "\"products\":[{\"name\":\"acqua\",\"quantity\":2},"
				+ "{\"name\":\"bibite\",\"quantity\":3}]}", order.toJson().toString());
	}
	
}
