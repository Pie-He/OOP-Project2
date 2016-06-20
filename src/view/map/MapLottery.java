package view.map;

import static controller.MapController.getInstance;
import igui.IOption;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import controller.Session;
import bean.item.Player;

//以下为彩票中奖地图
@SuppressWarnings("serial")
public class MapLottery extends Map {

	private final static ImageIcon ICON = new ImageIcon(
			"picture/place/lottery.png");

	public MapLottery() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
		// type = new Lottery();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void event(Player p) {

		Session session = new Session("player", p);

		int choice = IOption.showConfirmDialog("是否花费2000元购买彩票？");
		if (choice == IOption.OK_OPTION) {
			Session response = getInstance().event(type, session);
			String message = response.getString("message");
			IOption.showMessage(message);
		}

	}

}