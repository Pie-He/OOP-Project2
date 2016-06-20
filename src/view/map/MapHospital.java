package view.map;

import static controller.MapController.getInstance;
import igui.IOption;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import controller.Session;
import bean.item.Player;

//此类定义起点地图
@SuppressWarnings("serial")
public class MapHospital extends Map {
	private static final ImageIcon ICON = new ImageIcon("picture/place/圣杯.jpg");

	public MapHospital() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	public boolean preEvent(Player player) {
		Session session = new Session("player", player);
		Session response = getInstance().event(type, session);
		String message = response.getString("message");
		// System.out.println("hospital preevent");
		// System.out.println(message);
		if (message != null) {
			IOption.showMessage(message);
			return false;
		}
		return true;
	}

	public void event(Player p) {
		// IOption.showMessage(2000, "医院");
	}
}