package bean.place;

import java.util.LinkedList;
import java.util.List;

import controller.EventSession;
import bean.Manager;
import bean.PlaceEnum;
import bean.item.Player;
import util.Const;
import util.IO;

public class House extends Place implements Comparable<House> {
	// private int price;
	final private static int MAXLEVEL = 5;
	private int initialPrice;
	private int level;
	private String name;
	private Player owner;

	// private Street street;

	public House() {
		this.level = 1;
	}

	public House(int initialPrice, String name) {
		super(PlaceEnum.HOUSE.ordinal());
		this.name = name;
		this.initialPrice = initialPrice;
		this.level = 1;
	}

	@Override
	public int compareTo(House arg0) {
		return this.getPrice() - arg0.getPrice();
	}

	public int getInitialPrice() {
		return this.initialPrice;
	}

	public void setInitialPrice(int initialPrice) {
		if (this.initialPrice != 0)
			return;
		this.initialPrice = initialPrice;
	}

	public int getPrice() {
		return this.initialPrice * this.level;
	}

	public int upgradePrice() {
		return this.initialPrice / 2;
	}

	public int getLevel() {
		return this.level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (this.name != null)
			return;
		this.name = name;
	}

	public String getStreet() {
		return this.name.substring(0, name.length() - 1);
	}

	@Override
	public String getDescription() {
		return super.getDescription()
				+ "\n"
				+ "名称:"
				+ name
				+ "\n"
				+ "初始价格:"
				+ this.initialPrice
				+ "元"
				+ "\n"
				+ "当前等级:"
				+ this.level
				+ "级"
				+ "\n"
				+ "拥有者:"
				+ (this.owner == null ? Const.HOUSE_NOT_OWNER : this.owner
						.getName()) + "\n";
	}

	@Override
	public EventSession event(EventSession session) {
		// super.event(p);
		Player p = (Player) session.get("player");
		String[] message = null;
		if (this.owner == null) {
			message = this.sell(p);
		} else if (this.owner == p) {
			message = this.levelUp();
		} else {
			List<String> l = this.charge(p);
			message = l.toArray(new String[l.size()]);
		}
		// return
		EventSession repsonse = new EventSession("message", message);
		return repsonse;
	}

	public void destroy() {
		this.owner = null;
	}

	private String[] sell(Player p) {
		if (!p.addCash(-this.getPrice())) {
			return new String[] { Const.CASH_NOT_ENOUGH.toString() };
		} else {
			p.addHouse(this);
			this.owner = p;
			return new String[] { Const.SUCCESS.toString() };
		}
	}

	private String[] levelUp() {

		if (this.level >= MAXLEVEL) {
			return new String[] { Const.HOUSE_MAX_LEVEL.toString() };
		}
		if (!owner.addCash(-this.initialPrice / 2)) {
			return new String[] { Const.CASH_NOT_ENOUGH.toString() };

		}
		return new String[] { Const.SUCCESS.toString() };
	}

	private List<String> charge(Player p) {
		List<String> strs = new LinkedList<String>();
		int fee = this.getFee();
		strs.add("缴交过路费" + fee + "元给" + owner.getName());
		owner.addCash(fee);
		if (p.addCash(-fee))
			return strs;
		strs.add(Const.HOUSE_CASH_NOT_ENOUGH.toString());
		fee -= p.getCash();
		p.setCash(0);
		if (p.addDeposit(-fee))
			return strs;
		strs.add(Const.HOUSE_DEPO_NOT_ENOUGH.toString());
		fee -= p.getDeposit();
		p.setDeposit(0);
		while (fee > 0) {
			House house = p.sellHouse();
			if (house == null) {
				owner.addCash(-fee);
				strs.add("支付不起过路费，破产！");
				Manager.getInstance().fail(p);
				return strs;
			}
			house.owner = null;
			if ((fee -= house.getPrice()) <= 0) {
				p.addCash(-fee);
				break;
			}
		}
		return strs;
	}

	private int getFee() {
		return owner.getStreet(this.getStreet()).stream()
				.mapToInt(i -> i.getPrice()).sum()
				/ 10 + this.getPrice() / 5;
	}

	public Player getOwner() {
		return owner;
	}

}
