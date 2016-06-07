package type.place;

import type.item.Player;
import util.IO;

public class Coupon extends Place{
	public Coupon(){
		
	}
	public Coupon(int x, int y, String symbol) {
		super(x,y,symbol,"���͵�ȯ��");
	}
	@Override
	public boolean event(Player p) {
		super.event(p);
		int coupon=((int)(Math.random()*20)*5+5);
		IO.printString("��ϲ����� "+coupon+"��ȯ��");
		p.addCoupon(coupon);
		return true;
	}
}
