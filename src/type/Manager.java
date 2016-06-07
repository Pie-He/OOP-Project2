package type;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import type.item.Player;
import util.Const;
import util.IO;
import util.Tools;

public class Manager {
	/*����ģʽ*/
	private static final Manager MANAGER = new Manager();

	private Manager() {
	}

	public static Manager getInstance() {
		return MANAGER;
	}

	final private static String[] PLSYMBOL = { "��", "��", "��", "��" };
	final private static String[] HSSYMBOL = { "��", "��", "��", "��" };
	final private static SimpleDateFormat SDF = new SimpleDateFormat(
			"������yyyy��MM��dd�� EE");
	private Map map = Map.getInstance();
	private Calendar calendar = Calendar.getInstance();
	static int diceFlag = -1;
	public static LinkedList<Player> players;

	public void start() throws IOException {
		this.init();

		// for (int i = 0; i < 20; i++) {
		// players.getFirst().addProp(Prop.remoteBoson);
		for (int j = 0; j < Prop.values().length; j++) {
			players.get(0).addProp(Prop.values()[j]);

		}
		// }
	/*	for (int i = 0; i < 20; i++) {
			players.get(1).addProp(Prop.remoteBoson);
			players.get(1).addProp(Prop.stopCard);
		}*/
		//IO.printString(SDF.format(calendar.getTime()));
		EVENT: {
			while (calendar.get(Calendar.YEAR) < 2017) {
				IO.printString(SDF.format(calendar.getTime()));

				// �ж���ĩ����ĩ��������
				if (!isWeekend())
					Stock.changes();

				// ������������Ȩ
				for (int i = 0; i < players.size(); i++) {
					if (!this.event(players.get(i))) {
						players.remove(i);
						i--;
					}
					if (players.size() == 1) {
						IO.printString(Const.GAME_OVER
								+ players.peek().getName() + Const.WIN);
						break EVENT;
					}
				}

				// �ж��µף��µ����з�����Ϣ
				if (this.isMonthLast()) {
					IO.printString(Const.TIME_DEPO_PRIZE);
					players.stream().forEach(i -> {
						int m = i.getDeposit() / 10;
						IO.printString(i.getName() + Const.TIME_INTERESTS + m);
						i.addDeposit(m);
					});
				}
				calendar.add(Calendar.DAY_OF_MONTH, 1);
			}
		}
		int max = Manager.players.stream().mapToInt((x) -> x.getProperty())
				.summaryStatistics().getMax();
		players.stream().filter(i -> i.getProperty() == max)
				.forEach(i -> IO.printString(i.getName() + Const.WIN));
		IO.inputClose();
	}

	public void fail(Player p) {
		IO.printString(p.getName() + Const.FAIL);
		p.fail();
		map.removePlayer(p);
	}

	/* ��ʼ�� */
	private void init() {
		int index = 0;
		int playerNum = IO.getPlayerNumber();
		players = new LinkedList<Player>();
		for (String name : IO.getPlayerName(playerNum)) {
			players.add(new Player(name, PLSYMBOL[index], HSSYMBOL[index++]));
		}
		calendar.set(2016, 11, 30);
		map.init(players);
		while (true) {
			try {
				IO.getReady();
				break;
			} catch (IOException e) {
				IO.printString(Const.READY);
				continue;
			}
		}
	}

	/* �����¼� */
	private boolean event(Player player) {
		IO.printString("���������\"" + player.getName() + "\"����ʱ�䣬����ǰ��������"
				+ ((player.getDirection() > 0) ? "˳ʱ��" : "��ʱ��"));
		while (true) {
			int choice = IO.getMenuChoice();
			switch (choice) {
			case 0:
				IO.printStringArray2(map.toText());
				break;
			case 1:
				IO.printStringArray2(map.getInitalMap());
				break;
			case 2:
				int propChoice;
				while ((propChoice = IO.getProp(player.propToText())) >= 0) {
					player.useProp(propChoice);
					if (diceFlag >= 0) {
						boolean is = map.event(player, diceFlag);
						IO.printStringArray2(map.toText());
						diceFlag = -1;
						return is;
					}
				}
				break;
			case 3:
				warning(player);
				break;
			case 4:
				int dis = IO.getDistanceChoice(Const.SEARCH.toString(),
						-map.mapLength, map.mapLength);
				IO.printString(map.getDescription(player.getPrePoi(dis)));
				break;
			case 5:
				IO.printString(Tools.stringCover(16, "Name", "Coupon", "Cash",
						"Deposit", "House Property", "Total Property"));
				for (Player p : players)
					IO.printString(p.getMessage());
				break;
			case 6:

				return this.Dice(player);
			case 7:
				player.fail();
				return false;
			case 8:
				if (isWeekend()) {
					IO.printString(Const.TIME_BANK_CLOSE);
				} else {
					stockMarket(player);
				}
				break;
			}
		}
	}

	private void warning(Player player) {
		List<Integer> l = new LinkedList<Integer>();
		for (int i = 0; i < 11; i++) {
			if (map.isBlock(player.getPrePoi(i)))
				l.add(i);
		}
		l.stream().forEach(i -> IO.printString("ǰ��" + i + "����·�ϣ�����"));
		if (l.size() == 0)
			IO.printString(Const.BLOCK_NO);
	}

	private boolean Dice(Player player) {
		int dice = (int) (Math.random() * 6) + 1;
		IO.printString("Ͷ������:" + dice);
		boolean is = map.event(player, dice);
		IO.printStringArray2(map.toText());
		return is;
	}

	private boolean isMonthLast() {
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		boolean is = false;
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
			is = true;
		}
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return is;
	}

	private boolean isWeekend() {
		return calendar.get(Calendar.DAY_OF_WEEK) == 1
				|| calendar.get(Calendar.DAY_OF_WEEK) == 7;
	}

	private void stockMarket(Player player) {
		while (true) {
			IO.printString("�����ֽ�:" + player.getCash() + " �������д��:"
					+ player.getDeposit());
			int len = Stock.values().length;
			int[] amount = new int[len];
			for (int i = 0; i < len; i++) {
				amount[i] = player.getStockAmount(Stock.values()[i]);
			}
			int[] data = IO.getStock(amount);// 0-b or s 1-which stock
												// 2-amount
			// ��Ʊ�ж�
			if (data[0] < 0)
				return;
			if (data[0] == 0)
				Stock.values()[data[1]].buyStock(player, data[2]);
			else
				Stock.values()[data[1]].sellStock(player, data[2]);
		}
	}

}
