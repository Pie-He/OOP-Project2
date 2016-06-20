package bean.place;

import controller.Session;
import bean.PlaceEnum;
import bean.item.Player;
import util.Const;

public class Lottery extends Place {

	public Lottery() {
		super(PlaceEnum.LOTTERY.ordinal());
	}

	@Override
	public Session event(Session session) {
		Player p = session.getPlayer("player");
		Session response = new Session();
		if (!p.addCash(-2000)) {
			response.put("message", Const.CASH_NOT_ENOUGH.toString());
			return response;
		}
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
		response.put("message", Const.LOTTERY_SUCCESS.toString() + lottery
				+ "ิชฃก");
		p.addCash(lottery);

		return response;
	}

}
