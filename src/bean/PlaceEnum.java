package bean;

import bean.place.*;

public enum PlaceEnum {
	HOUSE(House.class, "房产"), COUPON(Coupon.class, "赠送点券点"), BANK(Bank.class, "银行"), CARDPRIZE(
			CardPrize.class, "赠送道具店"), LOTTERY(Lottery.class, "彩票点"), NEWS(
			News.class, "新闻点"), SHOP(Shop.class, "道具店"), SPACE(Space.class, "空地"),HOSPITAL(Hospital.class,"医院");

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
