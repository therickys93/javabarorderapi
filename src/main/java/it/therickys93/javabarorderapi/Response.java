package it.therickys93.javabarorderapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Response {

	private boolean ok;
	
	public static Response parseSuccess(String string) {
		JsonParser parser = new JsonParser();
		JsonObject status = parser.parse(string).getAsJsonObject();
		boolean ok = status.get("success").getAsBoolean();
		return new Response(ok);
	}
	
	private Response(boolean ok){
		this.ok = ok;
	}

	public boolean ok() {
		return this.ok;
	}

	public static List<Order> parseOrders(String ordersToParse) {
		List<Order> orders = new ArrayList<Order>();
		JsonParser parser = new JsonParser();
		JsonArray ordini = parser.parse(ordersToParse).getAsJsonArray();
		Iterator<JsonElement> iteratorOrdini = ordini.iterator();
		while(iteratorOrdini.hasNext()){
			JsonObject ordine = iteratorOrdini.next().getAsJsonObject();
			int id = ordine.get("id").getAsInt();
			int table = ordine.get("table").getAsInt();
			boolean done = ordine.get("done").getAsBoolean();
			JsonArray prodotti = ordine.get("products").getAsJsonArray();
			Iterator<JsonElement> iteratorProdotti = prodotti.iterator();
			Product[] products = new Product[prodotti.size()];
			int index = 0;
			while(iteratorProdotti.hasNext()){
				JsonObject prodotto = iteratorProdotti.next().getAsJsonObject();
				String name = prodotto.get("name").getAsString();
				int quantity = prodotto.get("quantity").getAsInt();
				Product product = new Product(name, quantity);
				products[index] = product;
				index++;
			}
			Order order = new Order(id, table, done, products);
			orders.add(order);
		}
		return orders;
	}

	public static List<Product> parseProducts(String productsToParse) {
		List<Product> productsList = new ArrayList<Product>();
		JsonParser parser = new JsonParser();
		JsonArray array = parser.parse(productsToParse).getAsJsonArray();
		Iterator<JsonElement> iterator = array.iterator();
		String name;
		while(iterator.hasNext()){
			name = iterator.next().getAsString();
			productsList.add(new Product(name, 0));
		}
		return productsList;
	}

}
