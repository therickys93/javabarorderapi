package it.therickys93.javabarorderapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Products implements Sendable {

	private String method;
	private String endpoint;
	
	public Products(){
		this.method = "GET";
		this.endpoint = "/v1/products";
	}
	
	@Override
	public String endpoint() {
		return this.endpoint;
	}

	@Override
	public JsonObject toJson() {
		return null;
	}

	@Override
	public String method() {
		return this.method;
	}

	public static List<Product> parseProducts(String products) {
		List<Product> productsList = new ArrayList<Product>();
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(products).getAsJsonArray();
		Iterator<JsonElement> iterator = array.iterator();
		String name;
		while(iterator.hasNext()){
			name = iterator.next().getAsString();
			productsList.add(new Product(name, 0));
		}
		return productsList;
	}

}
