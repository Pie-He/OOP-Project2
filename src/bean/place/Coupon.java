package bean.place;

import bean.item.Player;
import util.IO;

public class Coupon extends Place{

	public Coupon() {
		super("赠送点券点");
	}
	@Override
	public boolean event(Player p) {
		super.event(p);
		int coupon=((int)(Math.random()*20)*5+5);
		IO.printString("恭喜！获得 "+coupon+"点券！");
		p.addCoupon(coupon);
		return true;
	}
}
