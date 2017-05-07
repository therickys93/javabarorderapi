package it.therickys93.javabarorderapi;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductTest {

	@Test
	public void testOne() {
		assertEquals(1,1);
	}
	
	@Test
	public void testTwo() {
		Product product = new Product("cioccolata con panna", 2);
		assertEquals("cioccolata con panna", product.name());
		assertEquals(2, product.quantity());
	}
	
	@Test
	public void testThree() {
		Product product = new Product("cioccolata con panna", 2);
		assertEquals("Product={name=cioccolata con panna, quantity=2}", product.toString());
	}
	
	@Test
	public void testFour() {
		Product product = new Product("acqua", 2);
		assertEquals("{\"name\":\"acqua\",\"quantity\":2}", product.toJson().toString());
	}
	
}
