package bean.place;

import controller.EventSession;
import bean.PlaceEnum;
import bean.item.Player;
import util.*;

public class Bank extends Place {

	public Bank() {
		super(PlaceEnum.BANK.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		Player p=(Player) session.get("player");
		int money = (int) session.get("money");
		p.addCash(-money);
		p.addDeposit(money);
		return null;
	}

}
