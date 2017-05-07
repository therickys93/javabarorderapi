package it.therickys93.javabarorderapi;

import com.google.gson.JsonObject;

public class Product {

	private String name;
	private int quantity;
	
	public Product(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String name() {
		return this.name;
	}

	public int quantity() {
		return this.quantity;
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Product={name="+ this.name + ", quantity=" + this.quantity + "}";
		return response;
	}

	public JsonObject toJson() {
		JsonObject product = new JsonObject();
		product.addProperty("name", this.name);
		product.addProperty("quantity", this.quantity);
		return product;
	}

}
