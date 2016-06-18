package bean.place;

import controller.Session;
import bean.*;
import bean.item.Player;
import util.IO;

public class CardPrize extends Place {

	public CardPrize() {
		super(PlaceEnum.CARDPRIZE.ordinal());
	}

	@Override
	public Session event(Session session) {
		Player p = session.getPlayer("player");
		int random = (int) (Math.random() * Prop.values().length);
		Prop prop = Prop.values()[random];
		p.addProp(prop);
		Session response = new Session("prop", prop);
		return response;

	}
}
