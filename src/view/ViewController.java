package view;

import igui.IOption;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.Timer;

import util.Const;
import bean.Prop;
import bean.item.Player;
import controller.MapController;
import controller.PlayerController;
import controller.TimeController;

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
		frame.setTitle("Fate");
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

	private void next() {
		Player player = PlayerController.getInstance().nextPlayer();
		checkNextDay(player);
		frame.show(player);
		frame.timeRefresh();
		player = PlayerController.getInstance().getCurrentPlayer();
		if (!frame.preEvent(player)) {
			event();
		}
	}

	private void checkNextDay(Player player) {
		if (player == PlayerController.getInstance().getPlayerList().get(0)) {
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
		IOption.showMessage(player.getName() + "Ê§°Ü£¡");
		PlayerController.getInstance().removePlayer(player);
		MapController.getInstance().remove(player);
		player.fail();
		if (PlayerController.getInstance().getPlayerList().size() == 1) {
			IOption.showMessage(PlayerController.getInstance()
					.getCurrentPlayer().getName()
					+ Const.WIN);
			System.exit(0);
		}
		this.refresh();
		next();
	}
	//private void win
}
