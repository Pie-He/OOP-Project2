package view.map;

import static controller.MapController.getInstance;
import igui.IOption;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import controller.Session;
import bean.item.Player;

//���ඨ������ͼ
@SuppressWarnings("serial")
public class MapHospital extends Map {
	private static final ImageIcon ICON = new ImageIcon("picture/place/ʥ��.jpg");

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
		// IOption.showMessage(2000, "ҽԺ");
	}
}