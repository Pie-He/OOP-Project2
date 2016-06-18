package bean.place;

import controller.Session;
import bean.PlaceEnum;
import bean.item.Player;
import util.*;

public class Bank extends Place {

	public Bank() {
		super(PlaceEnum.BANK.ordinal());
	}

	@Override
	public Session event(Session session) {
		Player p = session.getPlayer("player");
		int money = session.getInteger("money");
		p.addCash(-money);
		p.addDeposit(money);// ´æÇ®ÎªÕý
		return null;
	}

}
