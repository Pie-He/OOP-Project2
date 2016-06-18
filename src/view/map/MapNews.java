package view.map;

import igui.IOption;

import java.awt.Graphics;

import javax.swing.ImageIcon;



import view.ViewController;
import controller.Session;
import controller.MapController;
import bean.item.Player;

//以下为新闻显示
@SuppressWarnings("serial")
public class MapNews extends Map {
	private static final ImageIcon ICON = new ImageIcon("picture/place/新闻.png");

	public MapNews() {
		super.setSize(120, 120);
		image = ICON.getImage();
		// type = new News();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void event(Player p) {
		//System.out.println("[MapNews]" + p + p.getName());
		Session session = new Session("player", p);

		Session response = MapController.getInstance()
				.event(type, session);
		String[] messages =response.getStrings("message");
		IOption.showMessage(messages);

		ViewController.getInstance().refresh();
	}
}