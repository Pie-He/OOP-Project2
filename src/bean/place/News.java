package bean.place;

import java.util.ArrayList;
import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;

import controller.EventSession;
import controller.MapController;
import controller.PlayerController;
import bean.Manager;
import bean.PlaceEnum;
import bean.Prop;
import bean.item.Player;
import util.Const;
import util.IO;

public class News extends Place {

	public News() {
		super(PlaceEnum.NEWS.ordinal());
	}

	@Override
	public EventSession event(EventSession session) {
		// super.event(p);
		int random = (int) (Math.random() * 6);// 获得0~4随机数
		Player player = (Player) session.get("player");
		String[] message;
		switch (random) {
		case 0: {
			message = new String[] { news(0) };
			break;
		}
		case 1: {
			message = new String[] { news(1) };
			break;
		}
		case 2: {
			PlayerController.getInstance().getPlayerList().stream()
					.forEach(i -> i.addDeposit(i.getDeposit() / 10));
			message = new String[] { Const.NEWS_DEPO_PRIZE.toString() };
			break;
		}
		case 3: {
			PlayerController.getInstance().getPlayerList().stream()
					.map(i -> i.addDeposit(-i.getDeposit() / 10));
			message = new String[] { Const.NEWS_DEPO_FINE.toString() };
			break;
		}
		case 4: {
			List<String> l = news4();
			message = l.toArray(new String[l.size()]);
			break;
		}
		default: {
			message = new5(player);
		}
		}
		EventSession response = new EventSession("message", message);
		return response;
	}

	private String[] new5(Player player) {
		MapController.getInstance().moveToHospital(player);
		return new String[] { Const.NEWS_HOUSPITAL.toString() };
	}

	private List<String> news4() {
		List<String> strs = new ArrayList<String>();
		strs.add(Const.NEWS_CARD_PRIZE.toString());
		PlayerController.getInstance().getPlayerList().stream().forEach(i -> {
			int random = (int) (Math.random() * Prop.values().length);
			Prop prop = Prop.values()[random];
			i.addProp(prop);
			strs.add("恭喜！" + i.getName() + "获得“" + prop.toText() + "”1个！");
		});
		return strs;
	}

	private String news(int choice) {

		int rewards = ((int) (Math.random() * 10 + 1)) * 1000;
		Deque<Player> pls = new LinkedList<Player>();

		IntSummaryStatistics stats = PlayerController.getInstance()
				.getPlayerList().stream().mapToInt((x) -> x.getHouseAmount())
				.summaryStatistics();

		int tmp = choice == 0 ? stats.getMax() : stats.getMin();
		String str = choice == 0 ? Const.NEWS_MAXHOUSE.toString()
				: Const.NEWS_MINHOUSE.toString();

		PlayerController.getInstance().getPlayerList().stream()
				.filter(i -> i.getHouseAmount() == tmp).forEach(pls::add);
		return str
				+ pls.stream().map(i -> i.getName())
						.reduce((x, y) -> x += (" " + y + " ")).get() + "奖励"
				+ rewards;
	}
}
