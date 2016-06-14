package bean.place;

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
	public boolean event(Player p) {
		super.event(p);
		while (true) {
			IO.printString("ÄúÓÐ" + p.getCoupon() + "µãÈ¯");
			int choice = IO.getBuyProp();
			if (choice < 0)
				break;
			Prop prop = Prop.values()[choice];
			if (p.addCoupon(-prop.getPrice()))
				p.addProp(prop);
			else
				IO.printString(Const.COUPON_NOT_ENOUGH);
		}
		return true;
	}
}
