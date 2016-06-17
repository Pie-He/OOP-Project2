package bean.place;

import java.util.List;

import controller.EventSession;
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
	public EventSession event(EventSession session) {
		int[] num = (int[]) session.get("propsNum");
		int coupon = (int) session.get("coupon");
		Player p = (Player) session.get("player");
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
