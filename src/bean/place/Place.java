package bean.place;

import java.util.*;

import bean.item.*;
import util.IO;

public abstract class Place {
	private LinkedList<Item> items = new LinkedList<Item>();
	private String type;

	Place() {

	}

	Place(String type) {
		this.type = type;
	}

	public String getDescription() {
		return "ÀàÐÍ:" + getType();
	};

	public boolean event(Player p) {
		IO.printString(this.getDescription());
		return true;
	};

	public Item getTop() {
		/*
		 * if(items.isEmpty()||(items.size()==1&&items.getFirst() instanceof
		 * RoadBlock)) return this.symbol; Item it=items.getFirst(); if(it
		 * instanceof RoadBlock) it=items.get(1);
		 */
		// Item i = items.stream().filter(item -> (item instanceof RoadBlock))
		// .findFirst().orElse(null);
		// return items.stream().filter(item -> !(item instanceof RoadBlock))
		// .map(item -> item.getSymbol()).findFirst().orElse(this.symbol);
		return items.stream().filter(item -> item != null).findAny()
				.orElse(null);
		// return symbol;
	}

	public void put(Item item) {
		this.items.addFirst(item);
	}

	public boolean isBlock() {
		return this.items.stream().filter(item -> item instanceof RoadBlock)
				.findAny().map(item -> true).orElse(false);
	}

	public boolean remove(Player p) {
		return this.items.remove(p);
	}

	public boolean removeBlock() {
		Item it = this.items.stream().filter(item -> item instanceof RoadBlock)
				.findAny().orElse(null);
		return items.remove(it);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (this.type != null)
			return;
		this.type = type;
	}
}
