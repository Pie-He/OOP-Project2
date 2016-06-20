package view;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import igui.IOption;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;

import util.Const;
import bean.item.Player;
import bean.other.Prop;
import controller.MapController;
import controller.PlayerController;
import controller.TimeController;

//控制gui各个界面
public class ViewController {
	private static final ViewController CONTROLLER = new ViewController();

	public static ViewController getInstance() {
		return CONTROLLER;
	}

	private Window frame = new Window();

	public void start() {
		frame.setVisible(true);
	}

	public ViewController() {
		frame.setTitle("大富翁");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setVisible(true);
	}

	public void showMenu() {
		frame.backMenu();
	}

	public void showChoose() {
		frame.showChoose();
	}

	public void showMap() {
		frame.showMap();
		frame.gameInit();
	}

	public void setEnabled(boolean aflag) {
		frame.setEnabled(aflag);
		frame.setButtonEnable(aflag);
	}

	public void refresh() {
		this.frame.mapRefresh();
		this.frame.playerRefresh();
	}

	public void event() {
		Player player = PlayerController.getInstance().getCurrentPlayer();
		frame.event(player);
		next();
	}

	public void next() {
		Player player = PlayerController.getInstance().nextPlayer();
		checkNextDay();
		frame.show(player);
		frame.timeRefresh();
		player = PlayerController.getInstance().getCurrentPlayer();
		if (!frame.preEvent(player)) {
			event();
		}
	}

	private void checkNextDay() {
		if (PlayerController.getInstance().isNextDay()) {
			if (TimeController.getInstance().isMonthLast()) {
				IOption.showMessage(1000, Const.TIME_DEPO_PRIZE);
				PlayerController
						.getInstance()
						.getPlayerList()
						.stream()
						.forEach(
								i -> {
									int m = i.getDeposit() / 10;
									IOption.showMessage(1000, i.getName()
											+ Const.TIME_INTERESTS + m);
									i.addDeposit(m);
								});

			}
			TimeController.getInstance().nextDay();
			if (TimeController.getInstance().isEnd()) {
				IOption.showMessage("游戏结束！");
				List<Player> players = PlayerController.getInstance()
						.getPlayerList();
				List<Player> winPlayer;
				int max = players.stream().mapToInt((x) -> x.getProperty())
						.summaryStatistics().getMax();
				winPlayer = players.stream()
						.filter(i -> i.getProperty() == max)
						.collect(Collectors.toList());
				this.win(winPlayer);
			}

		}
	}

	public void move(int num) {
		this.setEnabled(false);
		int[] count = { 0 };
		Timer time = new Timer(400, (e) -> {
			if (count[0] == num) {
				((Timer) (e.getSource())).stop();
				ViewController.this.setEnabled(true);
				ViewController.this.event();
				return;
			}
			count[0]++;
			Const state = MapController.getInstance().move(
					PlayerController.getInstance().getCurrentPlayer());
			if (state == Const.MOVE_EVENT_BLOCK) {
				IOption.showMessage(state);
				count[0] = num;
			}
			refresh();
			if (count[0] != num && state == Const.MOVE_EVENT_BANK) {
				ViewController.this.setEnabled(true);
				Player player = PlayerController.getInstance()
						.getCurrentPlayer();
				frame.event(player);
				ViewController.this.setEnabled(false);
			}
		});
		time.start();
	}

	public void useProp(Player player, Prop prop, JDialog jl) {
		// player.useProp(prop);
	}

	public void fail(Player player) {
		IOption.showMessage(player.getName() + "失败！");
		PlayerController.getInstance().removePlayer(player);
		MapController.getInstance().remove(player);
		player.fail();
		if (PlayerController.getInstance().getPlayerList().size() == 1) {

			List<Player> winPlayer = new LinkedList<Player>();
			winPlayer.add(PlayerController.getInstance().getCurrentPlayer());
			this.win(winPlayer);
		}
		this.refresh();
		// next();
	}

	private void win(List<Player> players) {
		String[] str = new String[players.size()];
		for (int i = 0; i < str.length; i++) {
			str[i] = players.get(i).getName() + Const.WIN;
		}
		IOption.showMessage(str);
		System.exit(0);
	}
}
