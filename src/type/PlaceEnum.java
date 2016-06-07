package type;

import type.place.*;
public enum PlaceEnum {
	HOUSE(House.class, "��"), COUPON(Coupon.class, "ȯ"), BANK(Bank.class, "��"), CARDPRIZE(
			CardPrize.class, "��"), LOTTERY(Lottery.class, "��"), NEWS(
			News.class, "��"), SHOP(Shop.class, "��"), SPACE(Space.class, "��");

	private Class<? extends Place> c;
	private String symbol;

	PlaceEnum(Class<? extends Place> c, String symbol) {
		this.c = c;
		this.symbol = symbol;
	}

	public Class<? extends Place> getRealClass() {
		return c;
	}

	public String getSymbol() {
		return symbol;
	}

}
