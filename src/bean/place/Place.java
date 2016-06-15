package bean.place;

import java.util.*;

import controller.EventSession;
import bean.PlaceEnum;
import bean.item.*;
import util.IO;

public abstract class Place {
	private LinkedList<Item> items = new LinkedList<Item>();
	private int type = -1;

	Place() {

	}

	Place(int type) {
		this.type = type;
	}

	public String getDescription() {
		return "¿‡–Õ:" + PlaceEnum.values()[getType()].getDescription();
	};

	public abstract EventSession event(EventSession session);


	public LinkedList<Item> getItems() {
		/*
		 * if(items.isEmpty()||(items.size()==1&&items.getFirst() instanceof
		 * RoadBlock)) return this.symbol; Item it=items.getFirst(); if(it
		 * instanceof RoadBlock) it=items.get(1);
		 */
		// Item i = items.stream().filter(item -> (item instanceof RoadBlock))
		// .findFirst().orElse(null);
		// return items.stream().filter(item -> !(item instanceof RoadBlock))
		// .map(item -> item.getSymbol()).findFirst().orElse(this.symbol);
		return items;
		// return symbol;
	}

	public void put(Item item) {
		this.items.addLast(item);
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		if (this.type >= 0)
			return;
		this.type = type;
	}
}
