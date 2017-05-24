package it.therickys93.javabarorderapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Order {

	private static final String PRODUCTS = "products";
	private static final String DONE = "done";
	private static final String TABLE = "table";
	private static final String ID = "id";
	private int id;
	private int table;
	private boolean done;
	private Product[] products;
	
	public Order(int id, int table, boolean done, Product[] products) {
		this.id = id;
		this.table = table;
		this.done = done;
		this.products = products;
	}

	public int id() {
		return this.id;
	}

	public int table() {
		return this.table;
	}

	public boolean done() {
		return this.done;
	}

	public Product[] products() {
		return this.products;
	}

	@Override
	public String toString() {
		String response = "";
		response += "Order={id=" + this.id + ", table=" + this.table + ", done=" + this.done;
		response += ", products=[";
		for(int index = 0; index < this.products.length; index++){
			if(index == this.products.length - 1) {
				// non mettere la virgola finale
				response += this.products[index].toString() + "";
			} else {
				response += this.products[index].toString() + ", ";
			}
		}
		response += "]}";
		return response;
	}

	public JsonObject toJson() {
		JsonObject order = new JsonObject();
		order.addProperty(ID, this.id);
		order.addProperty(TABLE, this.table);
		order.addProperty(DONE, this.done);
		JsonArray products = new JsonArray();
		for(int index = 0; index < this.products.length; index++){
			products.add(this.products[index].toJson());
		}
		order.add(PRODUCTS, products);
		return order;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}
	
}
