package view.map;

import igui.IOption;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import bean.item.Player;


//此类定义空地地图
@SuppressWarnings("serial")
public class MapSpace extends Map {
	private final static ImageIcon ICON = new ImageIcon("picture/place/空地.png");

	public MapSpace() {
		super.setSize(120, 120);
		image = ICON.getImage();
		// type = new Space();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void event(final Player p) {
		IOption.showMessage(2000, "空地");

	}
}
