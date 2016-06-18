package view.map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.Timer;

import bean.item.Item;
import bean.item.Player;
import bean.place.Place;

//所有地图类型的父类
public abstract class Map extends JLabel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Player p2=GloVar.p2;
	protected Image image;
	protected List<Image> imageItems = new ArrayList<Image>();

	protected Place type;

	// 以下方法显示玩家行走情况

	public Map() {
		// this.imageItems.add(image);
	}

	public void putImage(Image image) {
		this.imageItems.add(image);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// System.out.println(this.type);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		List<Item> items = this.type.getItems();

		items.stream().forEach(i -> {
			Image image = i.getType().getIcon().getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		});
	}

	public void setType(Place place) {
		this.type = place;
	}

	public abstract void event(Player p);

	public boolean preEvent(Player p) {
		return true;
	}

	public void Cross(Player p, Timer time) {
	}

	public String getMessage() {
		return type.getDescription();
	}
}