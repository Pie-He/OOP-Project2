package view.map;

import igui.IOption;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ViewController;
import controller.EventSession;
import controller.MapController;
import bean.item.Player;
import bean.place.News;

//以下为新闻显示
public class MapNews extends Map {
	private static final ImageIcon ICON = new ImageIcon("picture/place/新闻.png");

	public MapNews() {
		super.setSize(120, 120);
		image = ICON.getImage();
		// type = new News();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		 * if (type.isPHere) { g.drawImage(image, 0, 0, getWidth(), getHeight(),
		 * this); g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this); }
		 * else {
		 */
		// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
		// g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		// }
	}

	@Override
	public void event(Player p) {
		//System.out.println("[MapNews]" + p + p.getName());
		EventSession session = new EventSession("player", p);

		EventSession response = MapController.getInstance()
				.event(type, session);
		String[] messages = (String[]) response.get("message");
		IOption.showMessage(messages);

		ViewController.getInstance().refresh();
		/*
		 * final MFrameN frame = new MFrameN(); frame.add(new PlacePanel(p));
		 * final java.util.Timer timer = new java.util.Timer();
		 * timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() { // TODO Auto-generated method stub
		 * frame.dispose(); timer.cancel(); GloVarGUI.frame.map.change(p); } },
		 * 4000);
		 */
	}
}