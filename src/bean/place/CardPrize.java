package bean.place;

import controller.EventSession;
import bean.*;
import bean.item.Player;
import util.IO;

public class CardPrize extends Place {

	public CardPrize() {
		super(PlaceEnum.CARDPRIZE.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		Player p = (Player) session.get("player");
		int random = (int) (Math.random() * Prop.values().length);
		Prop prop = Prop.values()[random];
		p.addProp(prop);
		EventSession response = new EventSession("message", "¹§Ï²£¡»ñµÃ¡°"
				+ prop.toText() + "¡±1¸ö£¡");
		return response;

	}
}
