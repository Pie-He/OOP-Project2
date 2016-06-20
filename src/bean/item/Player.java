package bean.item;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import bean.other.Prop;
import bean.other.Stock;
import bean.place.House;

public class Player extends Item {
	private String name;
	private int cash;// 玩家现金
	private int deposit;// 玩家存款
	private int coupon;// 玩家点券
	// private int step;
	private int direction;
	private java.util.Map<Prop, Integer> props;
	private PriorityQueue<House> houses;
	private EnumMap<Stock, Integer> stocks = new EnumMap<Stock, Integer>(
			Stock.class);

	// private int stopRound = 0;

	public Player() {
		this.cash = 20000;
		this.deposit = 5000;
		this.coupon = 1000;
		this.props = new HashMap<Prop, Integer>(20);
		for (Prop prop : Prop.values()) {
			props.put(prop, 100);
		}
		this.direction = 1;
		this.setPoi(0);
		houses = new PriorityQueue<House>(20);
		// mov=new Removable();
	}

	public Player(String name, PersonType type) {
		this();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public boolean addCash(int cash) {
		if (this.cash + cash < 0)
			return false;
		return (this.cash += cash) >= 0;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int plDeposit) {
		this.deposit = plDeposit;
	}

	public boolean addDeposit(int deposit) {
		if (this.deposit + deposit < 0)
			return false;
		return (this.deposit += deposit) >= 0;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int plCoupon) {
		this.coupon = plCoupon;
	}

	public boolean addCoupon(int coupon) {
		if (this.coupon + coupon < 0)
			return false;
		return (this.coupon += coupon) >= 0;
	}

	public Integer addProp(Prop p) {
		int num = this.props.get(p) + 1;
		return this.props.put(p, num);
	}

	public void setPropAmount(Prop prop, int num) {
		this.props.put(prop, num);
	}

	public Prop removeProp(Prop p) {
		int num = this.props.get(p) - 1;
		this.props.put(p, num);
		return p;
	}

	public Prop removeProp(int index) {
		List<Prop> list = new ArrayList<Prop>();
		for (Entry<Prop, Integer> entry : props.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				list.add(entry.getKey());
			}
		}
		Prop p = list.get(index);
		return this.removeProp(p);
	}

	public int getpropNum() {
		int size = 0;
		for (Entry<Prop, Integer> entry : props.entrySet()) {
			size += entry.getValue();
		}
		return size;
	}

	public int getpropNum(Prop prop) {
		return props.get(prop);
	}

	public int getProperty() {
		return this.getCash() + this.getDeposit() + this.getHouseProperty();
	}

	public int walk(int mapLength) {
		this.poi = (this.poi + this.direction + mapLength) % mapLength;
		return this.poi;
	}

	public int getDirection() {
		return direction;
	}

	public void reverse() {
		this.direction = -this.direction;
	}

	public int getPrePoi(int dis, int length) {
		return (this.poi + this.direction * dis + length) % length;
	}

	public int getHouseAmount() {
		return this.houses.size();
	}

	public void addHouse(House house) {
		this.houses.add(house);
	}

	public int getHouseProperty() {
		return houses.stream().mapToInt(i -> i.getPrice()).sum();
	}

	public Collection<House> getStreet(String str) {
		return houses.stream().filter(i -> i.getStreet().equals(str))
				.collect(Collectors.toList());
	}

	public House sellHouse() {
		return this.houses.poll();
	}

	public boolean isInView(Player p, int range, int length) {
		if (Math.abs(this.poi - p.poi) <= range
				|| Math.abs(this.poi - p.poi) >= length - range)
			return true;
		return false;
	}

	public void addStock(Stock stock, int num) {
		int l = this.stocks.containsKey(stock) ? this.stocks.get(stock) : 0;
		this.stocks.put(stock, l + num);
	}

	public boolean removeStock(Stock stock, int num) {
		int l = this.stocks.containsKey(stock) ? this.stocks.get(stock) : 0;
		if (num > l)
			return false;
		this.stocks.put(stock, l - num);
		if (stocks.get(stock) == 0)
			stocks.remove(stock);
		return true;
	}

	public int getStockAmount(Stock s) {
		return this.stocks.containsKey(s) ? this.stocks.get(s) : 0;
	}

	public void fail() {
		House house;
		while ((house = this.houses.poll()) != null) {
			house.destroy();
		}
		this.cash = 0;
		this.coupon = 0;
		this.deposit = 0;
		this.props.clear();
		this.name += "(failed)";
	}

	public String getSymbol() {
		return this.name;
	}

	public PersonType getType() {
		return (PersonType) type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	public String toString() {
		return this.getName();
	}
}
