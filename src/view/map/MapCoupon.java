package view.map;

import static controller.MapController.getInstance;
import igui.IDialog;
import igui.IOption;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.EventSession;
import view.ViewController;
import bean.item.Item;
import bean.item.Player;

//此类为获得点券地图类
@SuppressWarnings("serial")
public class MapCoupon extends Map {
	private transient RoundRectangle2D clip = new RoundRectangle2D.Double(0, 0,
			39, 39, 39, 39);
	private static final ImageIcon ICON = new ImageIcon("picture/place/点券.png");

	public MapCoupon() {
		super.setSize(40, 40);
		this.image = ICON.getImage();
	}

	public void paintComponent(Graphics g) {
		g.setClip(clip);
		List<Item> items = this.type.getItems();
		items.stream().forEach(i -> {
			Image image = i.getType().getIcon().getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		});
		g.setClip(null);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}

	// 触发获得点券事件
	public void event(final Player p) {

		EventSession session = new EventSession("player", p);
		EventSession response = getInstance().event(type, session);
		int coupon = (int) response.get("coupon");
		IOption.showMessage("恭喜！获得"+coupon+"点券");
	}
}
