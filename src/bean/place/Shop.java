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
		List<Prop> props=(List<Prop>) session.get("props");
		int money=(int) session.get("cost");
		Player p = (Player) session.get("player");
		p.addCoupon(-money);
		props.stream().forEach(p::addProp);
		return null;
	}
}
