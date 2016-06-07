package util;

public enum Const {
	//common
	CASH_NOT_ENOUGH("�ֽ���!"), 
	DEPO_NOT_ENOUGH("�������!"), 
	MONEY_NOT_ENOUGH("��Ǯ���㣡"),
	SUCCESS("�ɹ�!"), 
	BUY_OR_NOT("�Ƿ���Ҫ����"),
	COUPON_NOT_ENOUGH("��ȯ���㣡"),
	GAME_OVER("��Ϸ������"),
	WIN("��ʤ��"),
	FAIL("ʧ��!"),
	READY("��׼���ã�"),
	
	//house	
	HOUSE_NOT_OWNER("(�ɹ�����״̬)"),
	HOUSE_MAX_LEVEL("����߼���"),
	HOUSE_LEVELUP_OR_NOT("�Ƿ�������"),
	HOUSE_CASH_NOT_ENOUGH("�ֽ��㣬���д��ֿۣ�"),
	HOUSE_DEPO_NOT_ENOUGH("���д��㣬�������صֿۣ�"),
	
	//lottery
	LOTTERY_BUT_OR_NOT("�Ƿ�Ҫ֧��2000Ԫ���Ʊ��"), 
	LOTTERY_SUCCESS("��ϲ�н���"),
	
	//news
	NEWS_DEPO_PRIZE("���мӷ��������ÿ���˵õ����10%"),
	NEWS_DEPO_FINE("�����˽��ɲƲ�˰10%"),
	NEWS_CARD_PRIZE("ÿ���˵õ�һ�ſ�Ƭ"),
	NEWS_MAXHOUSE("���������һ����! "),
	NEWS_MINHOUSE("������������������ "),
	
	//time
	TIME_DEPO_PRIZE("�µ׷��Ŵ�����Ϣ������"),
	TIME_INTERESTS("�����Ϣ"),
	TIME_BANK_CLOSE("��ĩ���У�"),
	
	//block
	BLOCK_NO("ǰ����·�ϣ�"),
	BLOCK_EXSITED("��λ���ѷ���·��"),
	BLOCK_YES("����·�ϣ�"),
	//search
	SEARCH("�����������ѯ�ĵ��������Ĳ���(���ø�����ʾ��x-�˳�)"),
	
	//prop
	PROP_NO_PROP("�޵���!"),
	PROP_AVERAGE("�������ֽ�ƽ��ʹ��"),
	PROP_DEPO_FINE("�ɽ�30%���"),
	PROP_CHOOSE("������ǰ��8���ڵ�����(������ʾ��,x-ȡ��)"),
	
	//stock
	STOCK_AMOUNT_ERROR("��Ʊ���������󣡣���"),
	;
	private String message;

	Const(String str) {
		this.message = str;
	}

	public String toString() {
		return this.message;
	}
}
