package bean.place;

import java.util.Deque;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;

import controller.EventSession;
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

	public boolean event(Player p) {
		//super.event(p);
		int random = (int) (Math.random() * 5);// 获得0~4随机数
		switch (random) {
		case 0: {
			news4();
			break;
		}
		case 1: {
			news(1);
			break;
		}
		case 2: {
			Manager.players.stream().forEach(
					i -> i.addDeposit(i.getDeposit() / 10));
			IO.printString(Const.NEWS_DEPO_PRIZE);
			break;
		}
		case 3: {
			Manager.players.stream().map(
					i -> i.addDeposit(-i.getDeposit() / 10));
			IO.printString(Const.NEWS_DEPO_FINE);
			break;
		}
		case 4: {
			news4();
			break;
		}
		}
		return true;
	}

	private void news4() {
		IO.printString(Const.NEWS_CARD_PRIZE);
		Manager.players.stream().forEach(
				i -> {
					int random = (int) (Math.random() * Prop.values().length);
					Prop prop = Prop.values()[random];
					i.addProp(prop);
					IO.printString("恭喜！" + i.getName() + "获得“" + prop.toText()
							+ "”1个！");
				});
	}

	private void news(int choice) {
		int rewards = ((int) (Math.random() * 10 + 1)) * 1000;
		Deque<Player> pls = new LinkedList<Player>();

		IntSummaryStatistics stats = Manager.players.stream()
				.mapToInt((x) -> x.getHouseAmount()).summaryStatistics();

		int tmp = choice == 0 ? stats.getMax() : stats.getMin();
		String str = choice == 0 ? Const.NEWS_MAXHOUSE.toString()
				: Const.NEWS_MINHOUSE.toString();

		Manager.players.stream().filter(i -> i.getHouseAmount() == tmp)
				.forEach(pls::add);
		IO.printString(str
				+ pls.stream().map(i -> i.getName())
						.reduce((x, y) -> x += (" " + y + " ")).get() + "奖励"
				+ rewards);
	}

	@Override
	public EventSession event(EventSession session) {
		// TODO Auto-generated method stub
		return null;
	}
}
