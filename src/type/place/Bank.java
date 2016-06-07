package type.place;

import type.item.Player;
import util.*;

public class Bank extends Place {

	public Bank() {

	}

	public Bank(int x, int y, String symbol) {
		super(x, y, symbol, "����");
	}

	@Override
	public boolean event(Player p) {
		super.event(p);
		IO.printString("�����ֽ�:" + p.getCash() + " �������д��:" + p.getDeposit());
		int money = IO.getSaveOrDrawMoney();// ������Ǯ ����ȡǮ
		if (money == 0)
			return true;
		if (!p.addCash(-money)) {
			IO.printString(Const.CASH_NOT_ENOUGH);
			return true;
		}
		if (!p.addDeposit(money)) {
			IO.printString(Const.DEPO_NOT_ENOUGH);
			return true;
		}
		IO.printString(Const.SUCCESS);
		return true;
	}

}
