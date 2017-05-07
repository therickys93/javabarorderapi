package it.therickys93.javabarorderapi;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Order {

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
		order.addProperty("id", this.id);
		order.addProperty("table", this.table);
		order.addProperty("done", this.done);
		JsonArray products = new JsonArray();
		for(int index = 0; index < this.products.length; index++){
			products.add(this.products[index].toJson());
		}
		order.add("products", products);
		return order;
	}
	
}
