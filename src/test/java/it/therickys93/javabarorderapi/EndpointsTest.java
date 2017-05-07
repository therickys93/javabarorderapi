package it.therickys93.javabarorderapi;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class EndpointsTest {

	@Test
	public void testOne() {
		assertEquals(1, 1);
	}
	
	@Test
	public void testTwo() {
		Status status = new Status();
		assertEquals("GET", status.method());
		assertEquals("/v1/status", status.endpoint());
	}
	
	@Test
	public void testThree() {
		Response status = Response.parseResponse("{\"success\":true}");
		assertTrue(status.ok());
		status = Response.parseResponse("{\"success\":false}");
		assertFalse(status.ok());
	}
	
	@Test
	public void testFour() {
		DeleteProductAll product = new DeleteProductAll();
		assertEquals("POST", product.method());
		assertEquals("/v1/deleteProductAll", product.endpoint());
	}
	
	@Test
	public void testFive() {
		InsertProduct product = new InsertProduct("cioccolata con panna");
		assertEquals("POST", product.method());
		assertEquals("/v1/insertProduct/cioccolata con panna", product.endpoint());
	}
	
	@Test
	public void testSix() {
		DeleteProduct product = new DeleteProduct("cioccolata con panna");
		assertEquals("POST", product.method());
		assertEquals("/v1/deleteProduct/cioccolata con panna", product.endpoint());
	}
	
	@Test
	public void testSeven() {
		Products products = new Products();
		assertEquals("GET", products.method());
		assertEquals("/v1/products", products.endpoint());
	}
	
	@Test
	public void testEight() {
		List<Product> products = Products.parseProducts(productsJson());
		assertEquals(32, products.size());
	}
	
	private String productsJson(){
		return "[\"acqua\",\"bibite\",\"caffe al ginseng\",\"caffe americano\",\"caffe d\'orzo\",\"caffe decaffeinato\",\"caffe decaffeinato shakerato\",\"caffe espresso\",\"caffe freddo\",\"caffe latte\",\"caffe shakerato\",\"cappuccino\",\"cappuccino al ginseng\",\"cappuccino d\'orzo\",\"cappuccino decaffeinato\",\"cappuccino freddo\",\"ciambella\",\"cioccolata\",\"cioccolata con panna\",\"crema di caffe\",\"crostata\",\"frullati vari\",\"insalatone\",\"latte bianco\",\"latte macchiato\",\"panini assortiti\",\"spremuta\",\"succhi di frutta\",\"the ed infusi\",\"the freddo\",\"toast\",\"tramezzini assortiti\"]";
	}
	
	@Test
	public void testNine() {
		Product[] products = {new Product("acqua", 2), new Product("bibite", 3)};
		Order order = new Order(102, 20, false, products);
		InsertOrder insertOrder = new InsertOrder(order);
		assertEquals("POST", insertOrder.method());
		assertEquals("/v1/insertOrder", insertOrder.endpoint());
		assertNotNull(insertOrder.toJson());
	}
	
	@Test
	public void testTen() {
		Product[] products = {new Product("acqua", 2), new Product("bibite", 3)};
		Order order = new Order(102, 20, false, products);
		CompleteOrder completeOrder = new CompleteOrder(order);
		assertEquals("POST", completeOrder.method());
		assertEquals("/v1/completeOrder", completeOrder.endpoint());
		assertNotNull(completeOrder.toJson());
	}
	
	@Test
	public void testEleven() {
		Product[] products = {new Product("acqua", 2), new Product("bibite", 3)};
		Order order = new Order(102, 20, false, products);
		PayOrder payOrder = new PayOrder(order);
		assertEquals("POST", payOrder.method());
		assertEquals("/v1/payOrder", payOrder.endpoint());
		assertNotNull(payOrder.toJson());
	}
	
	@Test
	public void testTwelve() {
		Orders orders = new Orders();
		assertEquals("GET", orders.method());
		assertEquals("/v1/orders", orders.endpoint());
	}
	
	@Test
	public void testThirteen() {
		Payments payments = new Payments();
		assertEquals("GET", payments.method());
		assertEquals("/v1/payments", payments.endpoint());
	}
	
}
