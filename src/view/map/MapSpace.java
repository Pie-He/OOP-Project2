package view.map;

import igui.IOption;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import bean.item.Player;


//���ඨ��յص�ͼ
@SuppressWarnings("serial")
public class MapSpace extends Map {
	private final static ImageIcon ICON = new ImageIcon("picture/place/�յ�.png");

	public MapSpace() {
		super.setSize(120, 120);
		image = ICON.getImage();
		// type = new Space();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void event(final Player p) {
		IOption.showMessage(2000, "�յ�");

	}
}
