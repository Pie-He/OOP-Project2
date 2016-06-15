package bean.place;

import controller.EventSession;
import bean.PlaceEnum;
import bean.item.Player;
import util.Const;
import util.IO;

public class Lottery extends Place {

	private final static int COST = 2000;

	public Lottery() {
		super(PlaceEnum.LOTTERY.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		Player p = (Player) session.get("player");
		EventSession response = new EventSession();
		if (!p.addCash(-COST)) {
			response.put("message", Const.CASH_NOT_ENOUGH);
		} else {
			int random = (int) (Math.random() * 10 + 1);
			int lottery = 0;
			if (random == 1)
				lottery = 10000;
			else if (1 < random && random <= 3)
				lottery = 5000;
			else if (3 < random && random <= 6)
				lottery = 2000;
			else
				lottery = 1000;
			response.put("message", Const.LOTTERY_SUCCESS.toString() + lottery);
			p.addCash(lottery);
		}
		return response;
	}

}
