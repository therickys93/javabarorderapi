package it.therickys93.javabarorderapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Response {

	private boolean ok;
	
	public static Response parseResponse(String string) {
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

}
