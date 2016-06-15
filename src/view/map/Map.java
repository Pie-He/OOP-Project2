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
	public transient Player p = new Player();
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
		// ImageIcon i=new ImageIcon();
		// System.out.println(type.getDescription()+items.size());
		items.stream().forEach(i -> {
			Image image = i.getType().getIcon().getImage();
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		});
	}

	public void setType(Place place) {
		this.type = place;
	}

	public void event(Player p) {
	};

	public MapLv getLv() {
		return null;
	}

	public void setLv(int i) {
	}

	// public void houseEvent(Player p){}
	public void sellHS(Player p) {
	}

	public void changeOwner(Player p, int i) {
	}

	public void showSell(final Player p, String[] s) {
	};

	public void Cross(Player p, Timer time) {
	}
}