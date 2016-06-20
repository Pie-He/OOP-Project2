package view.map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import bean.item.Item;
import bean.item.Player;
import bean.place.Place;

//所有地图cell的父类
public abstract class Map extends JLabel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image image;
	protected List<Image> imageItems = new ArrayList<Image>();

	protected Place type;


	public Map() {
	}

	public void putImage(Image image) {
		this.imageItems.add(image);
	}

	//画出玩家、路障标志
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

	public String getMessage() {
		return type.getDescription();
	}
}