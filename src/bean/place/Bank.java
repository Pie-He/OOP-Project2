package bean.place;

import bean.PlaceEnum;
import bean.item.Player;
import util.*;

public class Bank extends Place {

	public Bank() {
		super(PlaceEnum.BANK.ordinal());
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
