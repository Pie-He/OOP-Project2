package view.panel;

import igui.IButton;
import igui.IOption;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import bean.item.Player;
import controller.PlayerController;
import view.ViewController;
import view.button.DiceButton;
import view.label.MapLabel;
import view.label.PlayerMessLabel;
import view.label.TimeLabel;

//此类为地图面板
@SuppressWarnings("serial")
public class MapPanel extends JPanel {
	private ImageIcon fateImage = new ImageIcon("picture/background/背景02.jpg");
	private Image fateBackground = fateImage.getImage();

	// private ChangeButton jbtChange = new ChangeButton();

	private TimeLabel time = new TimeLabel();
	private MapLabel map = new MapLabel();
	private List<PlayerMessLabel> playerMess = new ArrayList<PlayerMessLabel>();
	private DiceButton jbtDice = new DiceButton();
	private IButton failButton = new IButton(60, 30);

	public MapPanel() {
		setSize(1200, 700);
		setLayout(null);

		add(time);
		time.setLocation(880, 50);

		add(map);
		map.setLocation(0, 0);

		add(jbtDice);
		jbtDice.setLocation(100, 200);

		failButton.setText("认输");
		failButton.setForeground(Color.WHITE);
		failButton.setBorderPainted(true);
		add(failButton);
		failButton.setLocation(880, 635);
		failButton.addActionListener((e) -> {
			Player player = PlayerController.getInstance().getCurrentPlayer();
			int choice = IOption.showConfirmDialog("确定认输？");
			if (choice == IOption.OK_OPTION) {
				ViewController.getInstance().fail(player);
				ViewController.getInstance().next();
			}

		});
	}

	public void init() {
		PlayerController.getInstance().getPlayerList().stream().forEach(i -> {
			PlayerMessLabel pml = new PlayerMessLabel(i);
			playerMess.add(pml);
			pml.setLocation(880, 230);
			pml.setVisible(false);
			this.add(pml);
		});
		playerMess.get(0).setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (fateBackground != null) {
			g.drawImage(fateBackground, 0, 0, getWidth(), getHeight(), this);
		}
	}

	// 用于显示地图各点信息

	public void refresh() {
		this.map.refresh();
		this.playerMess.stream().forEach(i -> i.refresh());
	}

	public void show(Player player) {
		playerMess.stream().forEach(i -> {
			if (i.isPlayer(player))
				i.setVisible(true);
			else
				i.setVisible(false);
		});

	}

	public void event(Player player) {
		map.event(player);
	}

	public boolean preEvent(Player player) {
		return map.preEvent(player);
	}

	public void setButtonEnable(boolean b) {
		this.jbtDice.setEnabled(b);
	}

	//刷新时间
	public void timeRefresh() {
		time.refresh();
	}

	//用户信息刷新
	public void playerRefresh() {
		playerMess.stream().forEach(i -> i.refresh());
	}

}
