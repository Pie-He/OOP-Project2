package type.place;

import type.*;
import type.item.Player;
import util.IO;

public class CardPrize extends Place {
	public CardPrize() {

	}

	public CardPrize(int x, int y, String symbol) {
		super(x, y, symbol, "���͵��ߵ�");
	}

	@Override
	public boolean event(Player p) {
		super.event(p);
		int random = (int) (Math.random() * Prop.values().length);
		Prop prop = Prop.values()[random];
		IO.printString("��ϲ����á�" + prop.toText() + "��1����");
		p.addProp(prop);
		return true;
	}
}
