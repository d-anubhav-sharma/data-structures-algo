package com.logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DGson{
	
	private Gson gson;
	private static DGson dgson;

	private DGson(){
		gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
	}
	
	public String stringify(Object object) {
		return gson.toJson(object);
	}
	
	public <T> T parseJson(String json, Class<T> className) {
		return gson.fromJson(json, className);
	}
	
	public static DGson dgson() {
		if(dgson==null) {
			dgson = new DGson();
		}
		return dgson;
	}
	
}
