package bean;

import bean.place.*;

public enum PlaceEnum {
	HOUSE(House.class, "����"), COUPON(Coupon.class, "���͵�ȯ��"), BANK(Bank.class, "����"), CARDPRIZE(
			CardPrize.class, "���͵��ߵ�"), LOTTERY(Lottery.class, "��Ʊ��"), NEWS(
			News.class, "���ŵ�"), SHOP(Shop.class, "���ߵ�"), SPACE(Space.class, "�յ�"),HOSPITAL(Hospital.class,"ҽԺ");

	private Class<? extends Place> c;
	private String description;

	PlaceEnum(Class<? extends Place> c, String description) {
		this.c = c;
		this.description = description;
	}

	public Class<? extends Place> getRealClass() {
		return c;
	}

	public String getDescription() {
		return description;
	}

}
