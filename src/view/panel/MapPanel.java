package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.item.Player;
import controller.PlayerController;
import view.button.DiceButton;
import view.label.MapLabel;
import view.label.PlayerMessLabel;
import view.label.TimeLabel;

//此类为地图面板
public class MapPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon fateImage = new ImageIcon("picture/background/背景02.jpg");
	private Image fateBackground = fateImage.getImage();

	// private ChangeButton jbtChange = new ChangeButton();

	private TimeLabel time = new TimeLabel();
	private MapLabel map = new MapLabel();
	private List<PlayerMessLabel> playerMess = new ArrayList<PlayerMessLabel>();
	private DiceButton jbtDice = new DiceButton();

	public MapPanel() {
		setSize(1200, 700);
		setLayout(null);

		add(time);
		time.setLocation(880, 50);


		add(map);
		map.setLocation(0, 0);

		add(jbtDice);
		jbtDice.setLocation(100, 200);
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

	public void show(int index) {
		playerMess.stream().forEach(i->i.setVisible(false));
		playerMess.get(index).setVisible(true);
	}

	public void event(Player player) {
		map.event(player);
	}
}
