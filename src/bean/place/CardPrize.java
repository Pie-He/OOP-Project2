package bean.place;

import bean.*;
import bean.item.Player;
import util.IO;

public class CardPrize extends Place {

	public CardPrize() {
		super("���͵��ߵ�");
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
