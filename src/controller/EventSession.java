package controller;

import java.util.HashMap;

@SuppressWarnings("serial")
public class EventSession extends HashMap<String, Object>{
	
	public EventSession(){
		super();
	}
	
	public EventSession(String key,Object value){
		this.put(key, value);
	}
	
}
