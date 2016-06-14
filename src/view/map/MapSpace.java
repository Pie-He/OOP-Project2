package view.map;

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
public class MapSpace extends MapJLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static ImageIcon ICON = new ImageIcon("picture/place/空地.png");

	public MapSpace() {
		super.setSize(120, 120);
		image = ICON.getImage();
		//type = new Space();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
/*		if (type.isPHere) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(p.getIm(), 0, 0, getWidth(), getHeight(), this);
		} else {*/
			// g.drawImage(pic, 0, 0, getWidth(), getHeight(), this);
			//g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		//}
	}

	public void event(final Player p) {

/*		final MFrameR frame = new MFrameR();
		frame.add(new PlacePanel(p));
		final java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				frame.dispose();
				GloVarGUI.frame.map.change(p);
				timer.cancel();
			}
		}, 2000);*/

	}

	/*class PlacePanel extends JPanel {
		private ImageIcon ico = new ImageIcon("picture/空地.jpeg");
		private Image im = ico.getImage();
		private Person p;
		private int coupon;

		PlacePanel(Person p) {
			this.p = p;
			setLayout(null);
			setSize(400, 200);
			type.event(p);
		}

		protected void paintComponent(Graphics g) {
			// g.setColor(new Color(206, 206, 0));
			g.setColor(Color.MAGENTA);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
			g.setFont(new Font("微软雅黑", Font.PLAIN, 30));
			g.drawString("魔力恢复", 225, 60);
			g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
			g.drawString("技能冷却刷新", 220, 120);
		}
	}*/
}

/*class MFrameR extends JFrame {
	MFrameR() {
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		GloVarGUI.frame.setEnabled(false);
	}

	public void dispose() {
		GloVarGUI.frame.setEnabled(true);
		super.dispose();
	}
}*/