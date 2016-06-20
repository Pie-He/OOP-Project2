package bean.place;

import controller.Session;
import bean.item.Player;

public class Coupon extends Place {

	public Coupon() {
		super(PlaceEnum.COUPON.ordinal());
	}

	@Override
	public Session event(Session session) {
		Player p = session.getPlayer("player");
		int coupon = ((int) (Math.random() * 20) * 5 + 5);
		p.addCoupon(coupon);
		return new Session("coupon", coupon);
	}
}
