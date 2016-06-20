package bean.place;


import controller.Session;
import bean.item.Player;
import bean.other.Prop;

public class Shop extends Place {

	public Shop() {
		super(PlaceEnum.SHOP.ordinal());
	}

	@Override
	public Session event(Session session) {
		int[] num = session.getIntegers("propsNum");
		int coupon = session.getInteger("coupon");
		Player p = session.getPlayer("player");
		p.setCoupon(coupon);
		for (int i = 0; i < num.length; i++) {
			Prop prop = Prop.values()[i];
			p.setPropAmount(prop, num[i]);
		}
		return null;
	}
}
