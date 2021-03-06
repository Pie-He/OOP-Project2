package controller;

import java.util.HashMap;

import bean.item.Player;

@SuppressWarnings("serial")
public class Session extends HashMap<String, Object> {

	public Session() {
		super();
	}

	public Session(String key, Object value) {
		this.put(key, value);
	}

	public Player getPlayer(String key) {
		return (Player) this.get(key);
	}

	public String getString(String key) {
		return (String) this.get(key);
	}

	public String[] getStrings(String key) {
		return (String[]) this.get(key);
	}

	public int getInteger(String key) {
		return (int) this.get(key);
	}

	public int[] getIntegers(String key) {
		return (int[]) this.get(key);
	}

	public boolean getBool(String key) {
		return (boolean) this.get(key);
	}

	public Object get(String key){
		return super.get(key);
	}
	public Object put(String key, Object value) {
		return super.put(key, value);
	}
}
