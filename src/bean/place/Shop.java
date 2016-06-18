package bean.place;

import java.util.List;

import controller.Session;
import bean.PlaceEnum;
import bean.Prop;
import bean.item.Player;
import util.Const;
import util.IO;

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
			for (int j = 0; j < num[i]; j++) {
				p.addProp(prop);
			}
		}
		return null;
	}
}
