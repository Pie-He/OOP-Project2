package bean.place;

import bean.*;
import bean.item.Player;
import util.IO;

public class CardPrize extends Place {

	public CardPrize() {
		super(PlaceEnum.CARDPRIZE.ordinal());
	}

	@Override
	public boolean event(Player p) {
		super.event(p);
		int random = (int) (Math.random() * Prop.values().length);
		Prop prop = Prop.values()[random];
		IO.printString("¹§Ï²£¡»ñµÃ¡°" + prop.toText() + "¡±1¸ö£¡");
		p.addProp(prop);
		return true;
	}
}
