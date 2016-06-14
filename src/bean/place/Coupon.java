package bean.place;

import bean.PlaceEnum;
import bean.item.Player;
import util.IO;

public class Coupon extends Place{

	public Coupon() {
		super(PlaceEnum.COUPON.ordinal());
	}
	@Override
	public boolean event(Player p) {
		super.event(p);
		int coupon=((int)(Math.random()*20)*5+5);
		IO.printString("πßœ≤£°ªÒµ√ "+coupon+"µ„»Ø£°");
		p.addCoupon(coupon);
		return true;
	}
}
