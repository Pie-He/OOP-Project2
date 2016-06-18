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
import javax.swing.Timer;

import bean.item.Player;
import bean.place.Hospital;

//此类定义起点地图
public class MapHospital extends Map {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ImageIcon ICON = new ImageIcon("picture/place/圣杯.jpg");

	public MapHospital() {
		super.setSize(120, 120);
		this.image = ICON.getImage();
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

	public void event(final Player p) {
		IOption.showMessage(2000, "医院");

	}
}