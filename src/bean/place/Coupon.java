package bean.place;

import controller.EventSession;
import bean.PlaceEnum;
import bean.item.Player;
import util.IO;

public class Coupon extends Place {

	public Coupon() {
		super(PlaceEnum.COUPON.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		Player p = (Player) session.get("player");
		int coupon = ((int) (Math.random() * 20) * 5 + 5);
		p.addCoupon(coupon);
		return new EventSession("coupon", coupon);
	}
}
