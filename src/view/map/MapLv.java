package view.map;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//以下为显示土地等级的
public class MapLv extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lv;
	private transient ImageIcon[] lvIcon = new ImageIcon[7];
	private transient Image[] lvIm = new Image[lvIcon.length];
	{
		for (int i = 0; i < lvIcon.length; i++) {
			lvIcon[i] = new ImageIcon("picture/lv" + i + ".png");
			lvIm[i] = lvIcon[i].getImage();
		}
	}

	public MapLv() {
		setSize(40, 40);
		lv = 0;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (lv) {
		case 0:
			g.drawImage(lvIm[0], 0, 0, getWidth(), getHeight(), this);
			break;
		case 1:
			g.drawImage(lvIm[1], 0, 0, getWidth(), getHeight(), this);
			break;
		case 2:
			g.drawImage(lvIm[2], 0, 0, getWidth(), getHeight(), this);
			break;
		case 3:
			g.drawImage(lvIm[3], 0, 0, getWidth(), getHeight(), this);
			break;
		case 4:
			g.drawImage(lvIm[4], 0, 0, getWidth(), getHeight(), this);
			break;
		case 5:
			g.drawImage(lvIm[5], 0, 0, getWidth(), getHeight(), this);
			break;
		case 6:
			g.drawImage(lvIm[6], 0, 0, getWidth(), getHeight(), this);
			break;
		}
	}

	public void setLv(int i) {
		lv = i;
		repaint();
	}
}
