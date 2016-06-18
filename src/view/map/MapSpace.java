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

import bean.item.Player;
import bean.place.Space;

//此类定义空地地图
public class MapSpace extends Map {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
